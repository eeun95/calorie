package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;
import board.model.vo.BoardFree;

/**
 * Servlet implementation class BoardFreeUpdateEndServlet
 */
@WebServlet("/boardFreeUpdateEnd")
public class BoardFreeUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo=Integer.parseInt(request.getParameter("no"));
		String boardTitle=request.getParameter("title");
		String boardContent=request.getParameter("content");
		
		BoardFree b=new BoardFree();
		b.setFb_num(boardNo);
		b.setFb_title(boardTitle);
		b.setFb_content(boardContent);
		
		int result=new BoardFreeService().updateBoard(b);
		String view="/boardFreeMain";
		String msg="";
		
		if(result>0) {
			msg="글이 수정되었습니다.";
		} else {
			msg="글 수정에 실패하였습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", view);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
