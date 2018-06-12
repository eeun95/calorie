package member.contorller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet(name="MemberLoginServlet", urlPatterns="/login") //암호화 작업을 해주면 반드시 해야한다.
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String member_id=request.getParameter("member_id");
		String member_pw=request.getParameter("member_pw");
		System.out.println(member_id);
		System.out.println(member_pw);
		//서비스단에 id/password check요청
		int result=new MemberService().loginCheck(member_id,member_pw);
		
		//결과에 따른 로그인처리 및 거부처리
		String view="";
		if(result==MemberService.LOGIN_OK) {
			Member member=new MemberService().selectOne(member_id);
			//System.out.println(member);
			//session객체를 받아서 login데이터를 삽입
			HttpSession session=request.getSession();
			System.out.println(session.getId());
			session.setAttribute("memberLoggedIn", member);
			session.setMaxInactiveInterval(600);  //로그인 지속시간을 설정 30초 이상이 되면 자동 로그아웃
			//아이디 저장 쿠키
			String saveId=request.getParameter("saveId");
			if(saveId!=null) {
				Cookie c= new Cookie("saveId", member_id);
				c.setMaxAge(6*24*60*60); //쿠키를 저장하는 기간 설정(초단위), 6일간 쿠키 보관
				c.setPath("/"); //저장되는 경로
				response.addCookie(c); //c를 보냄 쿠키는 response.addCookie로 밖에 전송을 하지 못한다.
			}
			else{
				Cookie c= new Cookie("saveId", member_id);
				c.setMaxAge(0); //쿠키 삭제
				c.setPath("/"); //저장되는 경로
				response.addCookie(c);
			}
			
			
			//request.setAttribute("memberLoggedIn", member);
			view="/"; //로그인 성공시 메인 화면으로 
			
		}
		else {
			String msg;
			if(result==MemberService.WRONG_PASSWORD) {
				msg="패스워드를 잘못 입력하셨습니다.";
			}
			else {
				msg="존재하지 않는 아이디 입니다.";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("loc", "/");
			view="views/common/msg.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(view);
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
