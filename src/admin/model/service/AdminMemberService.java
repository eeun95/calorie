package admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import admin.model.dao.AdminMemberDao;

import static common.JDBCTemplate.*;
import member.model.vo.Member;

public class AdminMemberService {

	public ArrayList<Member> slecetMemberList(int cPage,int numPerPage){
		Connection conn =getConnection();
		ArrayList<Member> list=new AdminMemberDao().slecetMemberList(conn,cPage,numPerPage);
		close(conn);
		return list;
	}
	public List<Member> selectMemberbyId(String searchKeyword){
		Connection conn =getConnection();
		List<Member> list=new AdminMemberDao().selectMemberbyId(conn, searchKeyword);
		close(conn);
		return list;
	}
	public List<Member> selectMemberbyName(String searchKeyword){
		Connection conn =getConnection();
		List<Member> list=new AdminMemberDao().selectMemberbyName(conn,searchKeyword);
		close(conn);
		return list;
	}
	public List<Member> selectMemberbygender(String searchKeyword){
		Connection conn =getConnection();
		List<Member> list=new AdminMemberDao().selectMemberbygender(conn,searchKeyword);
		close(conn);
		return list;
	}
	public int selectCount() {
		Connection conn=getConnection();
		int result=new AdminMemberDao().selectCount(conn);
		close(conn);
		return result;
	}
	public int selectIdCount(String searchKeyword) {
		Connection conn=getConnection();
		int result=new AdminMemberDao().selectIdCount(conn,searchKeyword);
		close(conn);
		return result;
	}
	public int selectNameCount(String searchKeyword) {
		Connection conn=getConnection();
		int result=new AdminMemberDao().selectNameCount(conn,searchKeyword);
		close(conn);
		return result;
	}
	public int selectgenderCount(String searchKeyword) {
		Connection conn=getConnection();
		int result=new AdminMemberDao().selectgenderCount(conn,searchKeyword);
		close(conn);
		return result;
	}
}
