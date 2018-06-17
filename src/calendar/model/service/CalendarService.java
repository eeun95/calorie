package calendar.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import calendar.model.dao.CalendarDAO;
import calendar.model.vo.Calendar;
import diary.model.vo.DietInfo;

import static common.JDBCTemplate.*;

public class CalendarService {

	public int insertResearch(DietInfo di) {
		Connection conn = getConnection();
		int result = new CalendarDAO().insertResearch(conn, di);
		int result2 = 0;
		int result3 = 0;
		if(result > 0) {
		   result2 = new CalendarDAO().insertCalendar(conn, di);
		   System.out.println("배경");
		   if(result2>0) {
			   result3 = new CalendarDAO().insertCalendardata(conn, di);
			   System.out.println("식단");
			   if(result3>0) {
				   System.out.println("운동");
				   commit(conn);
			   } else {
				   rollback(conn);
			   }
		   } else {
			   rollback(conn);
		   }
		} else {
		   rollback(conn);
		}
		close(conn);
		return result3;
	}

	public ArrayList<Calendar> selectAll(String member_id) {
		Connection conn = getConnection();
		ArrayList<Calendar> list = new CalendarDAO().selectAll(conn, member_id);
		close(conn);
		return list;
	}

}
