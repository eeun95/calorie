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
 * Servlet implementation class MemberCheckIdDuplicate
 */
@WebServlet("/checkIdDuplicate")
public class MemberCheckIdDuplicate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 받아와서 한글은 인코딩을 해줘야함.
		request.setCharacterEncoding("UTF-8");
		//보낸 userId값 받아오기
		String member_id=request.getParameter("member_id");
		//보낸 userId값 반복확인 비지니스로직 수행
		//플래그값으로 isUsable을 선언하여 true면 사용가능
		//false면 사용불가능
		boolean isUsable=new MemberService().duplicateId(member_id);
		//4.받은결과 페이지 팝업창으로 전송처리
		request.setAttribute("member_id", member_id);
		request.setAttribute("isUsable", isUsable);
		RequestDispatcher rd=request.getRequestDispatcher("views/common/checkDuplicate.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
