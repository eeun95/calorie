package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberFinderServlet
 */
@WebServlet("/memberFinder")
public class AdminMemberFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
	      //관리자가 아닐 경우 페이지 접속을 차단하는 로직
	      if(memberLoggedId==null || !"admin".equals(memberLoggedId.getMember_id())) {
	         request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
	         request.setAttribute("loc", "/");
	         request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	         return;
	      }
	      //파라미터 변수 가져오기
	      String searchType=request.getParameter("searchType");
	      String searchKeyword=request.getParameter("searchKeyword");
	      //데이터베이스에서 해당되는 멤버가져오기(searchKeyword하고 일치하는)
	      List<Member> list=null;
	      switch (searchType) {
	      case "member_id": list=new AdminMemberService().selectMemberbyId(searchKeyword);break;
	      case "member_name": list=new AdminMemberService().selectMemberbyName(searchKeyword);break;
	      case "gender": list=new AdminMemberService().selectMemberbygender(searchKeyword);break;
	      }
	    
	      //응답할 view선택하고 해당하는 데이터 전송
	   
	      request.setAttribute("list", list);
	      request.setAttribute("searchType", searchType);
	      request.setAttribute("searchKeyword", searchKeyword);
	      RequestDispatcher rd=request.getRequestDispatcher("/views/admin/memberFinder.jsp");
	      rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
