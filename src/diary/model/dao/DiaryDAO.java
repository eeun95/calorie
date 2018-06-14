package diary.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import diary.model.vo.Diary;
import diary.model.vo.DietInfo;

public class DiaryDAO {
	private Properties prop = new Properties();

	public DiaryDAO() {
		try {
			String fileName = DiaryDAO.class.getResource("/sql/diary/diary-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public ArrayList<Diary> selectList(Connection conn) {
		ArrayList<Diary> list = new ArrayList<>();
		Diary d = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				d=new Diary();
				d.setDiaryNum(rs.getInt(1));
				d.setDiaryTitle(rs.getString(2));
				d.setDiaryContent(rs.getString(3));
				d.setDiaryDate(rs.getDate(4));

				list.add(d);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}public ArrayList<DietInfo> selectInfo(Connection conn) {
		ArrayList<DietInfo> info = new ArrayList<>();
		DietInfo di = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectInfo");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				di=new DietInfo();
				di.setMemberId(rs.getString(1));
				di.setHeight(rs.getInt(2));
				di.setWeight(rs.getShort(3));
				di.setPurposeWeight(rs.getInt(4));
				di.setObjectiveDate(rs.getInt(5));
				di.setDietDate(rs.getDate(6));
				
				info.add(di);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return info;
	}
	
	public int deleteDiary(Connection conn, int no) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("deleteDiary");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int insertDiary(Connection conn, String title, String content) {
		ArrayList<Diary> diary = new ArrayList<>();
		Diary d = null;
		PreparedStatement pstmt = null;
		int result=0;
		String sql = prop.getProperty("insertDiary");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
