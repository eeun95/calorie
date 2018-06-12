package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardFreeService;
import board.model.vo.BoardFree;

/**
 * Servlet implementation class BoardFreeFinderServlet
 */
@WebServlet("/boardFreeFinder")
public class BoardFreeFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFreeFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 변수 가져오기
		String searchType=request.getParameter("searchType");
		String searchKeyword=request.getParameter("searchKeyword");
		
		//데이터베이스에서 해당되는 멤버 가져오기
		ArrayList<BoardFree> list=null;
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}
		catch(NumberFormatException e)
		{
			cPage=1;
		}
		int numPerPage;
		try {
			numPerPage=Integer.parseInt(request.getParameter("numPerPage"));
		}
		catch(NumberFormatException e)
		{
			numPerPage=10;
		}
//		
//		
//		//관리자용 리스트를 받아오는 로직을 처리
//		//현재페이지에 표시될 자료만 필터하여 가져오는 로직구성
		
		ArrayList<String> search=new ArrayList<>();
		switch(searchType) {
		case "usertitle" : list=new BoardFreeService().selectMemberbyTitle(searchKeyword,cPage, numPerPage);
		search.add("usertitle"); search.add(searchKeyword);
		break;
		case "userId" : list = new BoardFreeService().selectMemberbyId(searchKeyword,cPage, numPerPage);
		search.add("userId"); search.add(searchKeyword);
		break;
		case "userContent" : list=new BoardFreeService().selectMemberbyContent(searchKeyword, cPage, numPerPage); 
		search.add("userContent"); search.add(searchKeyword);
		break;
		
		}
//		//페이지 구성 pageBar 작성
		int totalMember=new BoardFreeService().searchCount(search);

		int totalPage=(int)Math.ceil((double)totalMember/numPerPage);
//		//페이지바 구성
		String pageBar="";
//		//페이지바의 표현될 페이지 갯수
		int pageBarSize=5;
//		//페이지바의 시작번호 설정
		//cPage 1~5 사이의 숫자 : 1
		//cPage 6~10사이의 숫자 : 6
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
//		//페이지바의 종료번호 설정
		int pageEnd=pageNo+pageBarSize-1;
//		
//		//페이지바에 들어갈 html 구문작성
//		//이전
		if(pageNo==1) {
			pageBar="<div style='margin-left:700;'><span>[이전]</span>";
		} else {
			pageBar+="<a href='"+request.getContextPath()+"/boardFreeFinder?cPage="+(pageNo-1)+"&numPerPage="+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>[이전]</a>";
		}
		//중간에 들어가는 페이지 버튼(1~5/6~10/...)만들기
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(cPage==pageNo) {
				pageBar+="<span class='cPage'>"+pageNo+"</span>";
			} else {
				pageBar+="<a href='"+request.getContextPath()+"/boardFreeFinder?cPage="+pageNo+"&numPerPage="+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>"+pageNo+"</a>";
			}
			pageNo++;
		}
		//[다음]버튼 만들기
		if(pageNo>totalPage) {
			pageBar+="<span>[다음]</span>";
		}else {
			pageBar+="<a href='"+request.getContextPath()+"/boardFreeFinder?cPage="+pageNo+"&numPerPage="+numPerPage+"&searchType="+searchType+"&searchKeyword="+searchKeyword+"'>다음</a></div>";
		}
		//데이터 전송
		//페이징바 설정값 전송
		request.setAttribute("pageBar", pageBar);
		//현재페이지 cPage
		request.setAttribute("cPage", cPage);
		//페이지당 자료수 전송
		request.setAttribute("numPerPage", numPerPage);
		
		int no=0;
		ArrayList<Integer> temp=new ArrayList<>();
		for(BoardFree b : list) {
			no=b.getFb_num();
			temp.add(no);
		}
		ArrayList<Integer> noList=new BoardFreeService().countComment(temp);
		request.setAttribute("temp",temp );
		request.setAttribute("noList", noList);
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/views/board/boardFreeFinder.jsp");
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
