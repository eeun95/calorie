package calendar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import calendar.model.service.CalendarService;
import diary.model.vo.DietInfo;
import member.model.vo.Member;

/**
 * Servlet implementation class ResearchCheckServlet
 */
@WebServlet("/researchCheck")
public class ResearchCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResearchCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		String member_id=memberLoggedId.getMember_id();
		int result = new CalendarService().selectID(member_id);
		response.setContentType("application/json");
		response.setContentType("UTF-8");
		String json = new Gson().toJson(result);
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
