package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {
	//service객체의 역할
	//1. DB접속정보를 경로 확인 conn객체 생성 / 반환
	//2. 처리된 수정, 삭제, 삽입에 대한 commit rollback처리
	//3. dao에서 받은 결과를 controller에 전달.
	
	//로그인 결과를 확인하는 변수 선언
	public static int LOGIN_OK=1;
	public static int WRONG_PASSWORD=0;
	public static int ID_NOT_EXIST=-1;
	public int loginCheck(String member_id ,String member_pw) {
		Connection conn=getConnection();
		int result= new MemberDao().loginCheck(conn,member_id,member_pw);
		
		close(conn);
		
		return result;
	}
	public Member selectOne(String member_id) {
		//1. DB와의 연결 객체를 생성 : connection
		//2. 데이터 CRUD(삽입, 수정, 삭제)가 발생한 경우 commit, rollback을 통제
		//3. 자신이 생성한 DB연결객체 반환 : connection
		//   **객체삭제
		
		Connection conn=getConnection();  //1번
		Member m=new MemberDao().selectOne(conn,member_id);
		close(conn); //3번
		return m;
	}
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int num=new MemberDao().insertMember(conn, m);
		if(num>0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return num;
	}
	public boolean duplicateId(String member_id) {
		Connection conn=getConnection();
		boolean flag=new MemberDao().duplicateId(conn,member_id);
		close(conn);
		return flag;
	}
	public int updateMember(Member member) {
		Connection conn=getConnection();
		int result=new MemberDao().updateMember(conn,member);
		//이작업은 수정이죠! CRUD에 해당! 수정!이면
		//성공시 commit / 실패시 rollback을 해줘야함.
		//구분은 결과가 1이상이면 commit이고 아니면 rollback
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}
	public int deleteMember(String member_id) {
		Connection conn=getConnection();
		int result=new MemberDao().deleteMember(conn,member_id);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}
	
	public int updatePassword(String member_id,String member_pw) {
		Connection conn=getConnection();
		int result=new MemberDao().updatePassword(conn,member_id,member_pw);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		return result;
	}
	public int selectEmail(String email) {
		Connection conn=getConnection();
		int result=new MemberDao().selectEmail(conn,email);
		return result;
	}
}