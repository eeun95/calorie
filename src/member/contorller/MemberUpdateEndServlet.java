package member.contorller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet(name="MemberUpdateServlet",urlPatterns="/memberUpdateEnd")
public class MemberUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member m=new Member();
		m.setMember_id(request.getParameter("member_id"));
		m.setMember_name(request.getParameter("member_name"));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));
		m.setGender(request.getParameter("gender"));
		//입력받은데이터DB저장의뢰 ->MemberService();
		//결과값은 !! CRUD int로 나옴
		int result=new MemberService().updateMember(m);
		
		//요청에 대한 응답작성/처리
		String view="";
		String msg="";
		String loc="";
		if(result>0) {
			msg="성공적으로 회원정보를 수정하였습니다.";
			request.getSession().invalidate();
		}
		else {
			msg="회원정보 수정에 실패하였습니다.";
		}
		view="views/common/msg.jsp";
		loc="/";
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
