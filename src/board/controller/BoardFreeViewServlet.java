package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;
import board.model.vo.BoardFree;
import board.model.vo.BoardFreeComment;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardFreeView")
public class BoardFreeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int no=Integer.parseInt(request.getParameter("no"));
		BoardFree b=new BoardFreeService().selectOne(no);
		if(b!=null) {
			ArrayList<BoardFreeComment> list=new BoardFreeService().selectComment(no);
		    request.setAttribute("comment", list);
		} 
	
	 //조회수 증가
	Cookie[] cookie=request.getCookies();
    String boardCookieVal="";
    boolean hasRead=false;
    
    if(cookie!=null) {
  	  outter:
  		  for(Cookie c:cookie) {
  			  String name=c.getName();
  			  String value=c.getValue();
  			  
  			  if("boardCookie".equals(name)) {
  				  boardCookieVal=value;
  				  if(value.contains("|"+no+"|")) {
  					  hasRead=true;
  					  break outter;
  				  }
  			  }
  		  }
    }
    if(!hasRead) {
  	  new BoardFreeService().incrementCount(no);
  	  
  	  Cookie c=new Cookie("boardCookie",boardCookieVal+"|"+no+"|");
  	  c.setMaxAge(-1); //브라우저가 session을 끊는 경우 삭제
  	  response.addCookie(c);
    }
    //사이트 방문시 아무런 쿠키를 갖고 있지않으면 cookie값은 null이 나옴

    request.setAttribute("boardList", b);
    RequestDispatcher rd = request.getRequestDispatcher("/views/board/boardFreeView.jsp");
    rd.forward(request, response);
 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
