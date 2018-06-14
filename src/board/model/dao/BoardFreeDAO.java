package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.BoardFree;
import board.model.vo.BoardFreeComment;

public class BoardFreeDAO {
	private Properties prop = new Properties();

	public BoardFreeDAO() {
		try {
			String fileName = BoardFreeDAO.class.getResource("/sql/board/board-query.properties").getPath();
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<BoardFree> selectList(Connection conn, int cPage, int numPerPage) {
		ArrayList<BoardFree> list = new ArrayList<>();
		BoardFree b = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			 pstmt.setInt(1, ((cPage-1)*numPerPage+1));
			 pstmt.setInt(2, cPage*numPerPage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				b = new BoardFree();
				b.setFb_num(rs.getInt(2));
				b.setFb_title(rs.getString(3));
				b.setFb_content(rs.getString(4));
				b.setFb_id(rs.getString(5));
				b.setFb_date(rs.getDate(6));
				b.setFb_count(rs.getInt(7));

				list.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int selectCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = prop.getProperty("selectCount");
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	public int searchCount(Connection conn,ArrayList<String> keyword) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql="";
		if(keyword.get(0).equals("usertitle")) {
			sql = prop.getProperty("titleCount");
		} else if(keyword.get(0).equals("userId")) {
			sql=prop.getProperty("idCount");
		} else if(keyword.get(0).equals("num")) {
			sql=prop.getProperty("numCount");
		}
		try {
			pstmt = conn.prepareStatement(sql);
			if(keyword.get(0).equals("num")) {
				pstmt.setInt(1, Integer.parseInt(keyword.get(1)));
			} else {
				pstmt.setString(1, '%'+keyword.get(1)+'%');
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public BoardFree selectOne(Connection conn, int no) {
		BoardFree b = new BoardFree();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectOne");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				b.setFb_num(rs.getInt(1));
				b.setFb_title(rs.getString(2));
				b.setFb_content(rs.getString(3));
				b.setFb_id(rs.getString(4));
				b.setFb_date(rs.getDate(5));
				b.setFb_count(rs.getInt(6));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return b;
	}

	public int insertBoard(Connection conn, BoardFree b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getFb_title());
			pstmt.setString(2, b.getFb_content());
			pstmt.setString(3, b.getFb_id());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateBoard(Connection conn, BoardFree b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBoard(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteBoard");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	public int deleteComment(Connection conn, int commentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNo);
			result =pstmt.executeUpdate();
			if(result>0) {
				sql=prop.getProperty("deleteComment2");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, commentNo);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	

	public int incrementCount(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("incrementCount");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertComment(Connection conn, BoardFreeComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc.getCommentLev());
			pstmt.setInt(2, bc.getFreeBoardNum());
			pstmt.setString(3, bc.getFreeBoardWrite());
			pstmt.setString(4, bc.getCommentContent());
			pstmt.setInt(5, bc.getParentId());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<BoardFreeComment> selectComment(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardFreeComment bc = null;
		ArrayList<BoardFreeComment> list = new ArrayList<BoardFreeComment>();
		String sql = prop.getProperty("selectComment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bc = new BoardFreeComment();
				bc.setCommentNum(rs.getInt("comment_num"));
				bc.setCommentLev(rs.getInt("comment_level"));
				bc.setFreeBoardNum(rs.getInt("free_board_num"));
				bc.setFreeBoardWrite(rs.getString("free_board_writer"));
				bc.setCommentContent(rs.getString("comment_content"));
				bc.setParentId(rs.getInt("parent_id"));
				bc.setCommentDate(rs.getDate("comment_date"));

				list.add(bc);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public ArrayList<Integer> countComment(Connection conn, ArrayList<Integer> no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Integer> noList=new ArrayList<>();
		String sql = prop.getProperty("countComment");

		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < no.size(); i++) {
				pstmt.setInt(1, no.get(i));
				rs = pstmt.executeQuery();
				if(rs.next()) {
				noList.add(rs.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return noList;
	}
	//검색어
	public ArrayList<BoardFree> selectMemberbyId(Connection conn, String keyword, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardFree b = null;
		ArrayList<BoardFree> boardList=new ArrayList<>();
		String sql=prop.getProperty("selectMemberId");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			 pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			 pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				b=new BoardFree();
				b.setFb_num(rs.getInt(2));
				b.setFb_title(rs.getString(3));
				b.setFb_content(rs.getString(4));
				b.setFb_id(rs.getString(5));
				b.setFb_date(rs.getDate(6));
				b.setFb_count(rs.getInt(7));
				
				boardList.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	public ArrayList<BoardFree> selectMemberbyTitle(Connection conn, String keyword, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardFree b = null;
		ArrayList<BoardFree> boardList=new ArrayList<>();
		String sql=prop.getProperty("selectTitle");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			 pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			 pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				b=new BoardFree();
				b.setFb_num(rs.getInt(2));
				b.setFb_title(rs.getString(3));
				b.setFb_content(rs.getString(4));
				b.setFb_id(rs.getString(5));
				b.setFb_date(rs.getDate(6));
				b.setFb_count(rs.getInt(7));
				
				boardList.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
	public ArrayList<BoardFree> selectMemberbyContent(Connection conn, String keyword, int cPage, int numPerPage) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BoardFree b = null;
		ArrayList<BoardFree> boardList=new ArrayList<>();
		String sql=prop.getProperty("selectContent");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			 pstmt.setInt(2, ((cPage-1)*numPerPage+1));
			 pstmt.setInt(3, cPage*numPerPage);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				b=new BoardFree();
				b.setFb_num(rs.getInt(2));
				b.setFb_title(rs.getString(3));
				b.setFb_content(rs.getString(4));
				b.setFb_id(rs.getString(5));
				b.setFb_date(rs.getDate(6));
				b.setFb_count(rs.getInt(7));
				
				boardList.add(b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardList;
	}
}
