<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member,java.util.*"%>
<%
   ArrayList<Member> list=(ArrayList<Member>)request.getAttribute("list");
   int numPerPage=(int)request.getAttribute("numPerPage");
   int cPage=(int)request.getAttribute("cPage");
   String pageBar=(String)request.getAttribute("pageBar");

%>
<%@ include file="/views/common/header.jsp"%>
<style>
   section#memberList-container table#tbl-member{
      width:100%;
      
      border: 1px solid gray;
      border-collapse:collapse;
   }
   section#memberList-container table#tbl-member th,table#tbl-member td{
      border:1px solid gray;
      padding: 10px;      
   }
   /*검색 로직 구현*/
   div#search-container{
      margin:0 0 10px;
      padding: 3px;
      background-color:rgb(0,188,212,0.3);
   }
   div#search-member_id{
      display:inline-block;
   }
   div#search-member_name{
      display:none;
   }
   div#search-gender{
      display:none;
   }
   /*페이징스타일 추가*/
   section#memberList-container div#neck-container{
      padding: 0px;
      height: 50px;
      background-color:rgba(0,188,212,0.3);
   }
   section#memberList-container div#search-container{
      margin:0 0 10px 0;
      padding:3px;
      float:left;
   }
   section#memberList-container div#numPerPage-container{
      float:right;
   }
   section#memberList-container form#numPerPageFrm{
      display:inline;   
   }
   #size_table{
      width:70%;
      margin:auto;
   }
   #mouse_menu {
   position: fixed;
   top: 30%;
   left: 90%;
   }

   #mouse_menu table {
      background-color: darkgray;
      width: 80px;
   }
   #mouse_menu table tr td a{
      color: white;
   }
   
</style>
<script>
window.onload=function(){
    var sid=document.querySelector("#search-member_id");
    var sname=document.querySelector("#search-member_name");
    var sgender=document.querySelector("#search-gender");
    
    var searchType=document.querySelector("#searchType");
    searchType.addEventListener("change",function(){
       sid.style.display="none";
       sname.style.display="none";
       sgender.style.display="none";
       
       (document.querySelector("#search-"+this.value)).style.display="inline-block";
    });
    
    //페이징 처리 함수
    var numPerPage=document.querySelector("#numPerPage");
    numPerPage.addEventListener("change",function(){
       numPerPageFrm.submit();
    });
    
    
    
 }
</script>
<div id='size_table'>
<section id="memberList-container">
      <h2>회원관리</h2>
      <div id='neck-container'>
         <div id='search-container'>
         검색타입:
         <select id='searchType'>
            <option value='member_id'>아이디</option>
            <option value='member_name'>이름</option>
            <option value='gender'>성별</option>
         </select>
         <div id="search-member_id">
            <form action="<%=request.getContextPath()%>/memberFinder">
               <input type="hidden" name="searchType" value="member_id">
               <input type="text" name="searchKeyword" size="25" placeholder="검색할 아이디를 입력하세요">
               <button type="submit">검색</button>            
            </form>
         </div>
         <div id="search-member_name">
            <form action="<%=request.getContextPath()%>/memberFinder">
               <input type="hidden" name="searchType" value="member_name">
               <input type="text" name="searchKeyword" size="25" placeholder="검색할 이름를 입력하세요">
               <button type="submit">검색</button>            
            </form>
         </div>
         <div id="search-gender">
            <form action="<%=request.getContextPath()%>/memberFinder">
               <input type="hidden" name="searchType" value="gender">
               <input type="radio" name="searchKeyword" value="M" checked>남
               <input type="radio" name="searchKeyword" value="F">여
               <button type="submit">검색</button>            
            </form>
         </div>
      </div>
   
      <div id="numPerPage-container">
         페이지당 회원수:
         <form name="numPerPageFrm" id="numPerPageFrm" action="<%=request.getContextPath()%>/memberList">
            <input type="hidden" name="cPage" value="<%=cPage%>">
            <select name="numPerPage" id="numPerPage">
               <option value='10' <%=numPerPage==10 ? "selected": ""%>>10</option>
               <option value='5' <%=numPerPage==5 ? "selected": ""%>>5</option>
               <option value='3' <%=numPerPage==3 ? "selected": ""%>>3</option>            
            </select>            
         </form>
      </div>
      </div>
      
      <table id="tbl-member">
         <thead>
            <tr>
               <th>아이디</th>
               <th>이름</th>
               <th>성별</th>
               <th>전화번호</th>
               <th>이메일</th>
               <th>주소</th>
               <th>가입날짜</th>
               <th>삭제</th>
            </tr>
         </thead>
         <tbody>
         <%if(list==null || list.isEmpty()){ %>
         <tr>
               <td colspan="9" align="center">검색 결과가 없습니다.</td>
         </tr>
         <%} 
         else{
            for(Member m :list)
            {         
         %>
         <tr>
            <td><%=m.getMember_id()%></td>
            <td><%=m.getMember_name()%></td>
            <td><%="M".equals(m.getGender())?"남":"여"%></td>
            <td><%=m.getPhone()%></td>
            <td><%=m.getEmail()%></td>
            <td><%=m.getAddress()%></td>
            <td><%=m.getMember_date()%></td>
            <td><a href="<%=request.getContextPath()%>/memberDelete?member_id=<%=m.getMember_id()%>"><input type="button" value="삭제"></a></td>
         </tr>
         <%}
         }%>
         </tbody>
      </table>
      <div id='pageBar'>
         <%=pageBar %>
      </div>
         
   </section>
</div>

   <div id='mouse_menu'>
         <!--마우스 페이지 이동-->
         <table>
            <tr>
               <caption><b>페이지 이동</b></caption>
            </tr>
            <tr>
               <td><a href="#none"><b>회원관리</b></a></td>
            </tr>
            <tr>
               <td><a href="#none"><b>식단관리</b></a></td>
            </tr>
            <tr>
               <td><a href="#none"><b>운동관리</b></a></td>
            </tr>
            <tr>
               <td><a href="#none"><b>게시판관리</b></a></td>
            </tr>
         </table>
      </div>

<%@ include file="/views/common/footer.jsp"%>