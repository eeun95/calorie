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
 * Servlet implementation class MemberViewServlet
 */
@WebServlet("/memberView")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자페이지에서 보낸 데이터 확인
		String member_id=request.getParameter("member_id");
		System.out.println(member_id);
		
		//DB에서 사용자가 보낸 데이터를 기준으로
		//사용자 정보 가져오기
		Member member=new MemberService().selectOne(member_id);
		
		//DB로부터 받아온 테이터를 페이에 전송하기 위해
		//request객체에 setAttribute()메소드 이용
		//저장!(key:value방식)
		String msg=""; //에러메세지 출력 변수
		String view=""; //이동한 페이지 설정변수
		String loc=""; //이동한 페이지에서 재이동할 페이지 설정
		//DB로부터 리턴받은 값에 따라 페이지를 선택하는 로직
		//페이지이동시 필요한 데이터 세팅
		//필요한 데이터를 request객체에 저장
		if(member==null) { //msg.jsp 에러메세지 출력을 위해
			view="views/common/msg.jsp";
			msg="회원정보를  가져올 수 없습니다.";
			loc="/";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		else {
			view="views/member/memberView.jsp";
			request.setAttribute("member", member);
		}
		//설정된 페이지로 세팅된 데이터를 가지고 이동시키는 로직
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
