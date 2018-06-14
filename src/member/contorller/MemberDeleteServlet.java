package member.contorller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String member_id=request.getParameter("member_id");
      String admin="";
      Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
      System.out.println(memberLoggedId);
      if("admin".equals(memberLoggedId.getMember_id())) {
         admin=memberLoggedId.getMember_id();
      }
      
      System.out.println(admin);
      int result=new MemberService().deleteMember(member_id);
      String view="";
      String msg="";
      String loc="";
      if(result>0) {
         msg="회원탈퇴가 완료 되었습니다.";
         if(admin.equals("admin")) {
            loc="/memberList";
         }else {
            request.getSession().invalidate(); //로그아웃
            loc="/";
         }
      }
      else {
         msg="회원탈퇴를 실패 하였습니다.";
         loc="/";
      }
      view="views/common/msg.jsp";
      request.setAttribute("msg", msg);
      request.setAttribute("loc", loc);
      RequestDispatcher rd = request.getRequestDispatcher(view);
      rd.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}