package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;

/**
 * Servlet implementation class BoardFreeDeleteCommentServlet
 */
@WebServlet("/boardFreeDeleteComment")
public class BoardFreeDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeDeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo=Integer.parseInt(request.getParameter("commentNo"));
		int boNum=Integer.parseInt(request.getParameter("boNum"));
		int resultCom=new BoardFreeService().deleteComment(commentNo);
		
		String view="/views/common/msg.jsp";
		String msg="";
		
		if(resultCom>0)
		{
			msg="삭제 완료되었습니다.";
		}
		else
		{
			msg="삭제 실패했습니다.";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc","/boardFreeView?no="+boNum);
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
