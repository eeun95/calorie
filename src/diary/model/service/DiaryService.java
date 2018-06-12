package diary.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import diary.model.dao.DiaryDAO;
import diary.model.vo.Diary;
import diary.model.vo.DietInfo;

public class DiaryService {
	public ArrayList<Diary> selectList() {
		Connection conn=getConnection();
		ArrayList<Diary> list=new DiaryDAO().selectList(conn);
		close(conn);
		return list;
	}
	public ArrayList<DietInfo> selectInfo() {
		Connection conn=getConnection();
		ArrayList<DietInfo> info=new DiaryDAO().selectInfo(conn);
		close(conn);
		return info;
	}
}
