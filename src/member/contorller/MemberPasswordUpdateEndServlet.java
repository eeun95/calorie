package member.contorller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberPasswordUpdateEndServlet
 */
@WebServlet(name="MemberPasswordUpdateEndServlet", urlPatterns="/updatePasswordEnd")
public class MemberPasswordUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPasswordUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id=request.getParameter("member_id");
		String member_pw=request.getParameter("member_pw");
		String pw_new=request.getParameter("member_pw_new");
		int result=new MemberService().loginCheck(member_id, member_pw);
		String msg="";
		String loc="/";
		String view="/views/common/msg.jsp";
		if(result==MemberService.LOGIN_OK) {
			result=new MemberService().updatePassword(member_id,pw_new);
			if(result>0) {
				msg="비밀번호가 변경되었습니다.";
				/*String script="self.close()";
				request.setAttribute("script", script);*/
			}
			else {
				msg="비밀번호 변경에 실패하였습니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			RequestDispatcher rd=request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
