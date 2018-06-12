package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminMemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberFinderServlet
 */
@WebServlet("/memberFinder")
public class AdminMemberFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMemberFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member memberLoggedId=(Member)request.getSession().getAttribute("memberLoggedIn");
		if(memberLoggedId==null && !"admin".equals(memberLoggedId.getMember_id())) {
			request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
			return;
		}
		int cPage2;
		try {
			cPage2=Integer.parseInt(request.getParameter("cPage2"));
		}catch (NumberFormatException e) {
			cPage2=1;
		}
		int numPerPage2;
		try {
			numPerPage2=Integer.parseInt(request.getParameter("numPerPage2"));
		}
		catch (NumberFormatException e) {
			numPerPage2=10;
		}
		String searchType2=request.getParameter("searchType2");
		String searchKeyword2=request.getParameter("searchKeyword2");
		int totalMember=0;
		System.out.println(searchType2);
		List<Member> list2=null;
		switch (searchType2) {
		case "userId":list2=new AdminMemberService().selectMemberbyId(searchKeyword2);
		totalMember=new AdminMemberService().selectIdCount(searchKeyword2);
		break;
		case "userName":list2=new AdminMemberService().selectMemberbyName(searchKeyword2);
		totalMember=new AdminMemberService().selectNameCount(searchKeyword2);
		break;
		case "gender":list2=new AdminMemberService().selectMemberbygender(searchKeyword2);
		totalMember=new AdminMemberService().selectgenderCount(searchKeyword2);
		break;
		}
		
		System.out.println("총 자료 수 : "+totalMember);
		int totalPage=(int)Math.ceil((double)totalMember/numPerPage2);
		System.out.println("총 페이지 : "+totalPage);
		//페이지 바 구성
		String pageBar2="";
		//페이지 바의 표현될 페이지 개수
		int pageBar2Size=5;
		//페이지 바의 시작번호 설정
		//cPage2 1~5사이의 숫자면 : 1;
		//cPage2 6~10사이의 숫자면 : 6;
		int pageNo=((cPage2-1)/pageBar2Size)*pageBar2Size+1; //페이지의 시작번호 공식
		//페이지 바의 종료 번호 설정
		int pageEnd=pageNo+pageBar2Size-1;
		
		//페이지 바에 들어갈 html구문 작성
		//[이전]버튼 만들기
		if(pageNo==1) {
			pageBar2+="<span>[이전]</span>";
		}
		else {
			pageBar2+="<a href='"+request.getContextPath()+"/memberlist2?cPage2="+(pageNo-1)+"&numPerPage2="+numPerPage2+"'>[이전]</a>";
		}
		//중간에 들어가는 페이지 버튼(1~5/6~10/...)만들기
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage2==pageNo) {
				pageBar2+="<span class='cPage2'>"+pageNo+"</span>";		
			}
			else {
				pageBar2+="<a href='"+request.getContextPath()+"/memberlist2?cPage2="+pageNo+"&numPerPage2="+numPerPage2+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		//[다음]버튼 만들기
		if(pageNo>totalPage) {
			pageBar2+="<span>[다음]</span>";
		}
		else {
			pageBar2+="<a href='"+request.getContextPath()+"/memberlist2?cPage2="+pageNo+"&numPerPage2="+numPerPage2+"'>[다음]</a>";
		}
		//데이터 전송
		request.setAttribute("list2", list2);
		//페이징바 설정값 전송
		request.setAttribute("pageBar2", pageBar2);
		//현재 페이지 cPage2
		request.setAttribute("cPage2", cPage2);
		//페이지당 자료수 전송 numPerPage2
		request.setAttribute("numPerPage2", numPerPage2);
		request.setAttribute("searchType2", searchType2);
		request.setAttribute("searchKeyword2", searchKeyword2);
		RequestDispatcher rd=request.getRequestDispatcher("/views/admin/memberFinder.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
