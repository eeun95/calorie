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
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet(name="MemberEnrollEndServlet", urlPatterns="/MemberEnrollEnd")
public class MemberJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member m=new Member();
		m.setMember_id(request.getParameter("member_id"));
		m.setMember_pw(request.getParameter("member_pw"));
		m.setMember_name(request.getParameter("member_name"));
		m.setEmail(request.getParameter("email"));
		m.setPhone(request.getParameter("phone"));
		m.setAddress(request.getParameter("address"));
		m.setGender(request.getParameter("gender"));
		
		System.out.println(m.getGender());
		int num=new MemberService().insertMember(m);
		
		String msg="";
		if(num!=0) {
			msg="회원가입을 완료하였습니다.!";
		}
		else {
			msg="회원가입을 실패하였습니다.!";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", "/");
		RequestDispatcher rd=request.getRequestDispatcher("views/common/msg.jsp");
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
