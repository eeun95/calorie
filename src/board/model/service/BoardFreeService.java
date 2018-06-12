package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardFreeDAO;
import board.model.vo.BoardFree;
import board.model.vo.BoardFreeComment;

public class BoardFreeService {

	public ArrayList<BoardFree> selectList(int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<BoardFree> list=new BoardFreeDAO().selectList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	public int selectCount() {
		Connection conn=getConnection();
		int result=new BoardFreeDAO().selectCount(conn);
		close(conn);
		return result;
	}
	public int searchCount(ArrayList<String> keyword) {
		Connection conn=getConnection();
		int result=new BoardFreeDAO().searchCount(conn,keyword);
		close(conn);
		return result;
	}
	public BoardFree selectOne(int no) {
		Connection conn=getConnection();
		BoardFree b=new BoardFreeDAO().selectOne(conn, no);
		close(conn);
		return b;
	}
	public int insertBoard(BoardFree n) {
		Connection conn=getConnection();
		int result=new BoardFreeDAO().insertBoard(conn, n);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);			
		}
		close(conn);
		return result;
	}
	public int updateBoard(BoardFree b) {
		Connection conn=getConnection();
		int result=new BoardFreeDAO().updateBoard(conn, b);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);			
		}
		close(conn);
		return result;
	}
	public int deleteBoard(int no) {
		Connection conn=getConnection();
		int result=new BoardFreeDAO().deleteBoard(conn, no);
		if(result>0) {
			commit(conn);
		} else {
			rollback(conn);			
		}
		close(conn);
		return result;
	}
	public int incrementCount(int no) {
	      Connection conn = getConnection();
	      int result = new BoardFreeDAO().incrementCount(conn, no);
	      if(result > 0) {
	         commit(conn);
	      } else {
	         rollback(conn);
	      }
	      close(conn);
	      return result;
	   }
	public int insertComment(BoardFreeComment bc) {
		Connection conn = getConnection();
	      int result = new BoardFreeDAO().insertComment(conn, bc);
	      if(result > 0) {
	         commit(conn);
	      } else {
	         rollback(conn);
	      }
	      close(conn);
	      return result;
	   }
	public ArrayList<BoardFreeComment> selectComment(int no) {
		Connection conn=getConnection();
		ArrayList<BoardFreeComment> list=new BoardFreeDAO().selectComment(conn,no);
		close(conn);
		return list;
	}
	public ArrayList<Integer> countComment(ArrayList<Integer> no) {
		Connection conn = getConnection();
	      ArrayList<Integer> noList = new BoardFreeDAO().countComment(conn, no);
	      close(conn);
	      return noList;
	   }
	
	//검색어
	public ArrayList<BoardFree> selectMemberbyId(String keyword, int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<BoardFree> list=new BoardFreeDAO().selectMemberbyId(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}
	public ArrayList<BoardFree> selectMemberbyTitle(String keyword, int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<BoardFree> list=new BoardFreeDAO().selectMemberbyTitle(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}
	public ArrayList<BoardFree> selectMemberbyContent(String keyword, int cPage, int numPerPage) {
		Connection conn=getConnection();
		ArrayList<BoardFree> list=new BoardFreeDAO().selectMemberbyContent(conn, keyword, cPage, numPerPage);
		close(conn);
		return list;
	}
	}

