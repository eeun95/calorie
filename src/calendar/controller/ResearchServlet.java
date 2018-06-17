package calendar.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calendar.model.service.CalendarService;
import diary.model.vo.DietInfo;
import member.model.vo.Member;
import oracle.sql.DATE;


@WebServlet("/research")
public class ResearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ResearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		String member_id=memberLoggedId.getMember_id();
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		int purposeWeight = Integer.parseInt(request.getParameter("purposeWeight"));
		Date objectiveDate = Date.valueOf(request.getParameter("objectiveDate"));
		Date start = new Date(new java.util.Date().getTime());
		
		DietInfo di = new DietInfo();
		
		di.setMemberId(member_id);
		di.setHeight(height);
		di.setWeight(weight);
		di.setPurposeWeight(purposeWeight);
		di.setObjectiveDate(objectiveDate);
		di.setDietDate(start);
		
		System.out.println(di);
		
		int result = new CalendarService().insertResearch(di);
		
		String view = "/views/common/msg.jsp";
		String msg = "";
		String loc = "/views/calendar/calendar.jsp";
		if(result>0) {
			msg="달력이 등록되었습니다.";
		} else {
			msg="달력 등록에 실패하였습니다.";
			loc="/views/calendar/research.jsp";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
