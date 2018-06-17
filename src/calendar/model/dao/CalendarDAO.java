package calendar.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import board.model.dao.BoardFreeDAO;
import calendar.model.vo.Calendar;
import diary.model.vo.DietInfo;

import static common.JDBCTemplate.*;

public class CalendarDAO {
	private Properties prop = new Properties();
	
	public CalendarDAO() {
		try {
			String fileName = BoardFreeDAO.class.getResource("/sql/research/research-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int insertResearch(Connection conn, DietInfo di) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("insertResearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, di.getMemberId());
			pstmt.setInt(2, di.getHeight());
			pstmt.setInt(3, di.getWeight());
			pstmt.setInt(4, di.getPurposeWeight());
			pstmt.setDate(5, di.getObjectiveDate());
			
			result = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertCalendar(Connection conn, DietInfo di) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertCalendarBackground");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, di.getMemberId());
			pstmt.setString(2, "배경");
			pstmt.setDate(3, di.getObjectiveDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	private int doDiffOfDate(Date start, Date end) {
		int result = 0;
		try {
			long diff = end.getTime()-start.getTime();
			result = (int) (diff/(24*60*60*1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private Date plusDate(Date date) {//날짜에 1 더하기
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(java.util.Calendar.DATE, 1);
		
		Date d = new Date(cal.getTimeInMillis());
		return d;
	}
	
	private String breakfast(Date date) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(java.util.Calendar.HOUR_OF_DAY, 9);

		String d = sdformat.format(cal.getTime());
		return d;
	}

	private String lunch(Date date) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(java.util.Calendar.HOUR_OF_DAY, 12);

		String d = sdformat.format(cal.getTime());
		return d;
	}
	private String dinner(Date date) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(java.util.Calendar.HOUR_OF_DAY, 18);

		String d = sdformat.format(cal.getTime());
		return d;
	}
	private String movement(Date date) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		cal.add(java.util.Calendar.HOUR_OF_DAY, 14);

		String d = sdformat.format(cal.getTime());
		return d;
	}
	private int[] bmiCal(int height, int weight) {
		//bmi계산
		/*
		  BMI < 18.5 - 저체중
		  BMI (18.5 - 24.9) - 정상 체중
		  BMI (25 - 29.9) - 초과 중량
		  BMI > 29.9 - 비만
		 */
		int calorie1 = 0; // bmi별 음식칼로리 
		int calorie2 = 0; // bmi별 음식칼로리
		int calorie3 = 0; // bmi별 운동소모 칼로리
		int calorie4 = 0; // bmi별 운동소모 칼로리
		double d = weight/((height*0.01)*(height*0.01)); 
		if(d>29.9) {
			calorie1 = 100;
			calorie2 = 300;
			calorie3 = 100;
			calorie4 = 400;
		} else if(29.9>=d && d>=25) {
			calorie1 = 300;
			calorie2 = 400;
			calorie3 = 300;
			calorie4 = 500;
		} else if(24.9>d && d>=18.5) {
			calorie1 = 400;
			calorie2 = 500;
			calorie3 = 400;
			calorie4 = 500;
		} else {
			calorie1 = 500;
			calorie2 = 1000;
			calorie3 = 500;
			calorie4 = 1000;
		}
		
		return new int[] {calorie1 , calorie2, calorie3, calorie4};
	}

	public int insertCalendardata(Connection conn, DietInfo di) {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int result = 0;
		int result2 = 0;
		String sql = prop.getProperty("insertCalendarFoodData");
		String sql2 = prop.getProperty("insertCalendarExerciseData");
		String [] count = {"아침", "점심", "저녁"};
		try {
			int[] calorie = bmiCal(di.getHeight(), di.getWeight());
			Date datestart = di.getDietDate();
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			for(int i=0; i<=doDiffOfDate(di.getDietDate(), di.getObjectiveDate())+1; i++) {
				for(int j=0; j<count.length; j++) {
					pstmt.setString(1, di.getMemberId());
					pstmt.setString(2, count[j]);
					pstmt.setDate(3, datestart);
					pstmt.setString(4, count[j]);
					pstmt.setInt(5, calorie[0]);
					pstmt.setInt(6, calorie[1]);
					result = pstmt.executeUpdate();
				}
				pstmt2.setString(1, di.getMemberId());
				pstmt2.setString(2, "운동");
				pstmt2.setDate(3, datestart);
				pstmt2.setInt(4, calorie[2]);
				pstmt2.setInt(5, calorie[3]);
				result2 = pstmt2.executeUpdate();
				
				
				datestart = plusDate(datestart);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(pstmt2);
		}
		return result+result2;
	}

	public ArrayList<Calendar> selectAll(Connection conn, String member_id) {
		ArrayList<Calendar> list = new ArrayList<>();
		Calendar cal = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			pstmt.setString(2, "아침");
			pstmt.setString(3, "점심");
			pstmt.setString(4, "운동");
			pstmt.setString(5, "저녁");
			rs = pstmt.executeQuery();
			System.out.println("쿼리문" + sql);
			while(rs.next()) {
				Date date = rs.getDate("calendar_start");
				cal = new Calendar();
				cal.setTitle(rs.getString("title"));
				if(rs.getString("title").equals("배경")) {
					cal.setStart(rs.getString("calendar_start"));
					cal.setEnd(rs.getString("calendar_end"));
					cal.setRendering("background");
					cal.setColor("#ff9f89");
				}
				if(rs.getString("title").equals("운동")) {
					cal.setStart(movement(date));
					cal.setDescription(rs.getString("ex_name"));
					cal.setColor("blue");
				} else if(rs.getString("title").equals("배경")){
					cal.setDescription("배경");
				} else {
					cal.setDescription(rs.getString("foods"));
					if(rs.getString("title").equals("아침")) {
						cal.setStart(breakfast(date));
						cal.setColor("green");
					} else if(rs.getString("title").equals("점심")) {
						cal.setStart(lunch(date));
						cal.setColor("red");
					} else {
						cal.setStart(dinner(date));
						cal.setColor("gray");
					}
				}
				list.add(cal);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

}
