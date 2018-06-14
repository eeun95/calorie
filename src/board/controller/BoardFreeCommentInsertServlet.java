package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;
import board.model.vo.BoardFreeComment;

/**
 * Servlet implementation class BoardFreeCommentInsertServlet
 */
@WebServlet("/boardFreeCommentInsert")
public class BoardFreeCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int boardRef=Integer.parseInt(request.getParameter("boardRef"));
		String boardWriter=request.getParameter("boardCommentWriter");
		String boardContent=request.getParameter("boardCommentContent");
		int boardlev=Integer.parseInt(request.getParameter("boardCommentLevel"));
		int boardCommentRef=Integer.parseInt(request.getParameter("boardCommentRef"));
		
		BoardFreeComment bc=new BoardFreeComment();
		bc.setFreeBoardNum(boardRef);
		bc.setFreeBoardWrite(boardWriter);
		bc.setCommentContent(boardContent);
		bc.setCommentLev(boardlev);
		bc.setParentId(boardCommentRef);
		
		int result=new BoardFreeService().insertComment(bc);
		
		String view="";
		String msg="";
		String loc="";
		if(result<0) 
		{
			msg="댓글 등록에 실패하였습니다.";
			view="/views/common/msg.jsp";
			loc="/boardFreeView?no="+boardRef;
		}else {
			view="/boardFreeView?no="+boardRef;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
