package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/boardFreeDelete")
public class BoardFreeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardFreeDeleteServlet() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		
		int result=new BoardFreeService().deleteBoard(no);
		
		String view="/views/common/msg.jsp";
		String msg="";
		if(result>0)
		{
			msg="삭제 완료되었습니다.";
		}
		else
		{
			msg="삭제 실패했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc","/boardFreeMain");
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
