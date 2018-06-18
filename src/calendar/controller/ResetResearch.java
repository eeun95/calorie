package calendar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.model.service.CalendarService;
import member.model.vo.Member;

/**
 * Servlet implementation class ResetResearch
 */
@WebServlet("/resetResearch")
public class ResetResearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResetResearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		String member_id=memberLoggedId.getMember_id();
		int result = new CalendarService().resetResearch(member_id);
		String view = "/views/common/msg.jsp";
		String msg = "";
		String loc = "/views/calendar/calendar.jsp";
		if(result > 0) {
			msg="달력이 삭제되었습니다.";
			loc="/views/calendar/research.jsp";
		} else {
			msg="달력삭제가 실패하였습니다.";
		}

		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
