package member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberDao {
	
	private Properties prop=new Properties();
	
	public MemberDao() {
		try{
			String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
			prop.load(new FileReader(fileName));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int loginCheck(Connection conn, String member_id, String member_pw) {
		int result=-1;
		PreparedStatement pstmt=null;
		String sql="";
		ResultSet rs=null;
		try{
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("member_id").equals(member_id) && rs.getString("member_pw").equals(member_pw)) {
					return 1;
				}
				else if(rs.getString("member_id").equals(member_id)) {
					return 0;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public Member selectOne(Connection conn, String member_id) {
		PreparedStatement pstmt=null;
		Member member=null;
		ResultSet rs=null;
		String sql="";
		try{
			sql=prop.getProperty("selectOne");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setMember_id(rs.getString("member_id")); //DB columname이 들어가야 한다.
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setMember_date(rs.getDate("member_date"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}
	public int insertMember(Connection conn,Member m) {
		PreparedStatement pstmt=null;
		int num=0;
		String sql="";
		try{
			sql=prop.getProperty("insert");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMember_id());
			pstmt.setString(2, m.getMember_pw());
			pstmt.setString(3, m.getMember_name());
			pstmt.setString(4, m.getGender());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getAddress());
			num=pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return num;
	}
	
	public boolean duplicateId(Connection conn, String member_id) {
		boolean flag=false;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int cnt=0;
		String sql="";
		try {
			sql=prop.getProperty("checkIdDuplicate");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");  //cnt값을 가져온다(카운트)
			}
			if(cnt==0) {
				flag=true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return flag;
	}
	public int updateMember(Connection conn,Member m) {
		//1. 각 필요객체 statement, resultSet, int, sql문
		//2. sql문을 가져오기 위한 properties로직 처리
		//3. 데이터 DBMS에 전송!(statement객체이용!)
		//  -실행 : 데이터가 있으면 executeQuery() / 
		//				 아니면 executeUpdate();
		//  -결과에 데이터를 가지면 ResultSet으로 받고
		//  -결과에 데이터 없는 수정, 삭제, 삽입이면 int로 받음
		PreparedStatement pstmt=null;
		int result=0;
		String sql="";
		//sql문가져오기
		try {
			sql=prop.getProperty("update");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getMember_name());
			pstmt.setString(2, m.getGender());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getMember_id());
			//수정이기 때문에
			result=pstmt.executeUpdate(); //숫자가 1증가
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteMember(Connection conn,String member_id) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql="";
		try {
			sql=prop.getProperty("delete");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			result=pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	public int updatePassword(Connection conn,String member_id,String member_pw) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql="";
		try {
			sql=prop.getProperty("updatePassword");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member_pw);
			pstmt.setString(2, member_id);
			result=pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	public int selectEmail(Connection conn,String email) {
		int result=0;
		PreparedStatement pstmt=null;
		String sql="";
		try {
			sql=prop.getProperty("selectEmail");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			result=pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}