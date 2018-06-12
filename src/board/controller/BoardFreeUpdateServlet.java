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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardFreeUpdate")
public class BoardFreeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardFree b=new BoardFreeService().selectOne(no);
		
		String view="";
		if(b!=null)
		{
			request.setAttribute("board", b);
			view="/views/board/boardFreeUpdate.jsp";
		}
		else
		{
			view="/views/common/msg.jsp";
			request.setAttribute("msg", "게시물을 찾을수 없습니다.");
			request.setAttribute("loc","/views/board/boardFreeMain.jsp");
		}
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
