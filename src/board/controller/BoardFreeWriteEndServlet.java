package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;
import board.model.vo.BoardFree;
import member.model.vo.Member;

/**
 * Servlet implementation class BoardFreeWriteEndServlet
 */
@WebServlet("/boardWriteEnd")
public class BoardFreeWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardTitle=request.getParameter("title");
		String boardWriter=request.getParameter("writer");
		String boardContent=request.getParameter("content");
		String boardEmail=request.getParameter("email");
		
		BoardFree b=new BoardFree();
		b.setFb_title(boardTitle);
		b.setFb_id(boardWriter);
		b.setFb_content(boardContent);
		
		request.setAttribute("email", boardEmail);

		
		int result=new BoardFreeService().insertBoard(b);
		String view="/boardFreeMain";
		String msg="";
		
		if(result>0) {
			msg="글이 등록되었습니다.";
		} else {
			msg="글 등록에 실패하였습니다.";
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
