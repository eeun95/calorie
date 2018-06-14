package diary.model.service;

import static common.JDBCTemplate.*;

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
	
	public int deleteDiary(int no) {
		Connection conn=getConnection();
		int result=new DiaryDAO().deleteDiary(conn,no);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int insertDiary(String title, String content) {
		Connection conn=getConnection();
		int result=new DiaryDAO().insertDiary(conn,title,content);
		close(conn);
		return result;
	}
}
