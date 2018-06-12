package admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet("/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		if(memberLoggedId==null || !"admin".equals(memberLoggedId.getMember_id())) {
			request.setAttribute("msg", "잘못된 경로 입니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
			return;
		}
		//페이징 처리
		//1.파라미터로 
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (NumberFormatException e) {
			cPage=1;
		}
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}
		catch (NumberFormatException e) {
			numPerPage=10;
		}
		//관리자용 리스트를 받아오는 로직을 처리
		//현재 페이지에 표시될 자료만 필터하여 가져오는 로직 구성
		ArrayList<Member> list=new AdminMemberService().slecetMemberList(cPage,numPerPage);
		System.out.println(list);
		//페이지 구성 pageBar작성
		int totalMember=new AdminMemberService().selectCount();
		System.out.println("총 자료 수 : "+totalMember);
		int totalPage=(int)Math.ceil((double)totalMember/numPerPage);
		System.out.println("총 페이지 : "+totalPage);
		//페이지 바 구성
		String pageBar="";
		//페이지 바의 표현될 페이지 개수
		int pageBarSize=5;
		//페이지 바의 시작번호 설정
		//cPage 1~5사이의 숫자면 : 1;
		//cPage 6~10사이의 숫자면 : 6;
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1; //페이지의 시작번호 공식
		//페이지 바의 종료 번호 설정
		int pageEnd=pageNo+pageBarSize-1;
		
		//페이지 바에 들어갈 html구문 작성
		//[이전]버튼 만들기
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}
		else {
			pageBar+="<a href='"+request.getContextPath()+"/memberList?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"'>[이전]</a>";
		}
		//중간에 들어가는 페이지 버튼(1~5/6~10/...)만들기
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='cPage'>"+pageNo+"</span>";		
			}
			else {
				pageBar+="<a href='"+request.getContextPath()+"/memberList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		//[다음]버튼 만들기
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}
		else {
			pageBar+="<a href='"+request.getContextPath()+"/memberList?cPage="+pageNo+"&numPerPage="+numPerPage+"'>[다음]</a>";
		}
		//데이터 전송
		request.setAttribute("list", list);
		//페이징바 설정값 전송
		request.setAttribute("pageBar", pageBar);
		//현재 페이지 cPage
		request.setAttribute("cPage", cPage);
		//페이지당 자료수 전송 numPerPage
		request.setAttribute("numPerPage", numPerPage);
		
		RequestDispatcher rd=request.getRequestDispatcher("views/admin/memberList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
