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
 * Servlet implementation class FindPasswordServlet
 */
@WebServlet("/findPassword.do")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id=request.getParameter("member_id");
		String email=request.getParameter("email");
		String view="";
		String msg="";
		String loc="";
		Member m=new Member();
		int result=new MemberService().selectEmail(email);
		if(result==0) {
			msg="회원 이메일이 존재하지 않습니다.";
			view="/views/common/msg.jsp";
			loc="/views/common/FindPassword.jsp";
		}
		else {
			m=new MemberService().selectOne(member_id);
			if(m!=null) {
				view="/views/common/findUpdatePassword.jsp";
			}else {
				msg="아이디가 존재하지 않습니다.";
				view="/views/common/msg.jsp";
				loc="/views/common/FindPassword.jsp";
			}
		}
		request.setAttribute("member", m);
		request.setAttribute("loc", loc);
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(view);
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
