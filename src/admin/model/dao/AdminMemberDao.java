package admin.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static common.JDBCTemplate.*;
import member.model.vo.Member;

public class AdminMemberDao {

	private Properties prop = new Properties();

	public AdminMemberDao() {
		try {
			String FileName=AdminMemberDao.class.getResource("/sql/admin/admin-query.properties").getPath();
			prop.load(new FileReader(FileName));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Member> slecetMemberList(Connection conn,int cPage,int numPerPage) {
		ArrayList<Member> list = new ArrayList<>();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectPage");
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			pstmt.setInt(2, cPage*numPerPage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member member=new Member();
				member.setMember_id(rs.getString("member_id")); //DB columname이 들어가야 한다.
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setMember_date(rs.getDate("member_date"));

				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Member> selectMemberbyId(Connection conn,String searchKeyword){
		ArrayList<Member> list = new ArrayList<>();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMemberId");
		try{
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Member member=new Member();
				member.setMember_id(rs.getString("member_id")); //DB columname이 들어가야 한다.
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setMember_date(rs.getDate("member_date"));				
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Member> selectMemberbyName(Connection conn,String searchKeyword){
		ArrayList<Member> list = new ArrayList<>();
		Member member;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMemberName");
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setMember_id(rs.getString("member_id")); //DB columname이 들어가야 한다.
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setMember_date(rs.getDate("member_date"));

				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public List<Member> selectMemberbygender(Connection conn,String searchKeyword){
		ArrayList<Member> list = new ArrayList<>();
		Member member;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql=prop.getProperty("selectMembergender");
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchKeyword);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				member=new Member();
				member.setMember_id(rs.getString("member_id")); //DB columname이 들어가야 한다.
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender"));
				member.setPhone(rs.getString("phone"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setMember_date(rs.getDate("member_date"));

				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public int selectCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectCount");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectIdCount(Connection conn,String searchKeyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectIdCount");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectNameCount(Connection conn,String searchKeyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectNameCount");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int selectgenderCount(Connection conn,String searchKeyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=prop.getProperty("selectgenderCount");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchKeyword);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt("cnt");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}








