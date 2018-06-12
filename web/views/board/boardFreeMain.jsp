<%@page import="board.model.vo.BoardFree"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<BoardFree> list=(ArrayList)request.getAttribute("boardList"); 
ArrayList<Integer> noList=(ArrayList)request.getAttribute("noList"); 
ArrayList<Integer> temp=(ArrayList)request.getAttribute("temp"); 
	 
	int numPerPage=(int)request.getAttribute("numPerPage");
	int cPage=(int)request.getAttribute("cPage");
	String pageBar=(String)request.getAttribute("pageBar"); %>    

    <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script" rel="stylesheet">
<script>
window.onload=function(){
    var stitle=document.querySelector("#search-usertitle");
    var sid=document.querySelector("#search-userId");
    var snum=document.querySelector("#search-userContent");
    
    var searchType=document.querySelector("#searchType");
    searchType.addEventListener("change",function(){
       stitle.style.display="none";
       sid.style.display="none";
       snum.style.display="none";
       
       (document.querySelector("#search-"+this.value)).style.display="inline-block";
    });
    
    //페이징 처리 함수
    var numPerPage=document.querySelector("#numPerPage");
    numPerPage.addEventListener("change",function(){
       numPerPageFrm.submit();
    });
    
    
    
 }
</script>
<style>
div#search-usertitle {
		display:inline-block;
	}
	div#search-userId {
		display:none;
	}
	div#search-userContent{
		display:none;
	}
</style>
    <%@ include file="/views/common/header.jsp"%>
    <div class="container">
        <table class="table table-hover" style="width:80%; margin:25px auto">
            <thead>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회수</th>
            </thead>
            <tbody>
        
            <% 
			if(list!=null) {
				for(BoardFree b:list) {
				
			%>
                <tr>
                    <td><%=b.getFb_num() %></td>
                    <td style="width:400px;"><a href="<%=request.getContextPath() %>/boardFreeView?no=<%=b.getFb_num()%>"><%=b.getFb_title() %></a> 
                	<%for(int i=0; i<temp.size(); i++) {
                	if(temp.get(i)==b.getFb_num()) {%>
                    [<%=noList.get(i) %>]
                    <%} }%>
                    
                    </td>
                    <td><%=b.getFb_id() %></td>
                    <td><%=b.getFb_date() %></td>
                    <td><%=b.getFb_count() %></td>
                    <%}
				} else {%>
				<td colspan="5" style="text-align:center">결과가 없습니다.</td>
				<%} %>
                </tr>
            </tbody>
        </table>
          <div id='pageBar'>
          <ul class='pagination'>
			<%=pageBar%>
          </ul>
		</div>
        <hr>
        <button class="btn btn-default pull-right" style="width:80px; margin-right:150px;" onclick="fn_addboard()">글쓰기</button>
        <script>
		function fn_addboard() {
			location.href="<%=request.getContextPath() %>/boardFreeAdd";
		};
	</script>
       
     
        <div style="text-align: center">
                <select id="searchType" class="pagination" style="margin-left: 150px">
                    <option value="usertitle" selected>제목</option>
                    <option value="userId">작성자</option>
                    <option value="userContent">내용</option>
                </select>
                <div id="search-usertitle">
            <form action="<%=request.getContextPath()%>/boardFreeFinder">
               <input type="hidden" name="searchType" value="usertitle">
                <input type='text' name="searchKeyword" size='25' placeholder="검색어를 입력하세요." style="width: 300px" >
                <button class="btn btn-primary" type='submit' style="width:60px">검색</button>
            </form>
         </div>
         <div id="search-userId">
            <form action="<%=request.getContextPath()%>/boardFreeFinder">
               <input type="hidden" name="searchType" value="userId">
                <input type='text' name="searchKeyword" size='25' placeholder="검색어를 입력하세요." style="width: 300px" >
                <button class="btn btn-primary" type='submit' style="width:60px">검색</button>
            </form>
         </div>
         <div id="search-userContent">
            <form action="<%=request.getContextPath()%>/boardFreeFinder">
               <input type="hidden" name="searchType" value="userContent">
               <input type='text' name="searchKeyword" size='25' placeholder="검색어를 입력하세요." style="width: 300px" >
               <button class="btn btn-primary" type='submit' style="width:60px">검색</button>
            </form>
         </div>
        </div>
    </div>
<%@ include file="/views/common/footer.jsp"%>
