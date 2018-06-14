<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,member.model.vo.Member"%>
    <%
       List<Member> list=(List<Member>)request.getAttribute("list");
       String searchKeyword=(String)request.getAttribute("searchKeyword");
       String searchType=(String)request.getAttribute("searchType");    
    %>
    
<%@ include file="/views/common/header.jsp"%>
    <style>
      section#memeberList-container {text-align:center;}   
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
   #neck-container{
      padding: 0px;
      height: 50px;
      background-color:rgba(0,188,212,0.3);
   }
    </style>
    <script>
    window.onload=function(){
       var searchType=document.querySelector("#searchType");
       searchType.addEventListener("change", function(){
          //document.memberFinderFrm.searchType.value=this.value;
          var key=$("input[name=searchKeyword]");
          changeSearchKeyword(key);
          sumitMemberFinder();         
       });
    };       
       function changeSearchKeyword(obj){
          
          document.memberFinderFrm.searchKeyword.value=obj.value;
       }

       function sumitMemberFinder(){
          
          document.memberFinderFrm.submit();
       }
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
       }
    </script>    
    <div id='size_table'>
<section id="memberList-container">
<h2>회원관리</h2>
<div id='neck-container'>
   <div id="search-container">
        검색타입 : 
        <select id="searchType">
            <option value="member_id" <%="member_id".equals(searchType)?"selected":""%>>아이디</option>      
            <option value="member_name" <%="member_name".equals(searchType)?"selected":""%>>회원명</option>
            <option value="gender" <%="gender".equals(searchType)?"selected":""%>>성별</option>
        </select>
        <div id="search-member_id">
            <form action="<%=request.getContextPath()%>/memberFinder">
                <input type="hidden" name="searchType" value="member_id"/>
                <input type="text" name="searchKeyword"  size="25" placeholder="검색할 아이디를 입력하세요." 
                    value="<%="member_id".equals(searchType)?searchKeyword:""%>" />
                <button type="submit">검색</button>         
            </form>   
        </div>
        <div id="search-member_name">
            <form action="<%=request.getContextPath()%>/memberFinder">
                <input type="hidden" name="searchType" value="member_name"/>
                <input type="text" name="searchKeyword" size="25" placeholder="검색할 이름을 입력하세요."
                    value="<%="member_name".equals(searchType)?searchKeyword:""%>"/>
                <button type="submit">검색</button>         
            </form>   
        </div>
        <div id="search-gender">
            <form action="<%=request.getContextPath()%>/memberFinder">
                <input type="hidden" name="searchType" value="gender"/>
                <input type="radio" name="searchKeyword" value="M" <%="gender".equals(searchType) && "M".equals(searchKeyword)?"checked":""%>> 남
                <input type="radio" name="searchKeyword" value="F" <%="gender".equals(searchType) && "F".equals(searchKeyword)?"checked":""%>> 여
                <button type="submit">검색</button>
            </form>
        </div>
    </div>
    </div>
           <table id="tbl-member">
            <thead>
                <tr>
                    <th>아이디</th>
                   <th>이름</th>
                   <th>성별</th>
                   <th>이메일</th>
                   <th>전화번호</th>
                   <th>주소</th>
                    <th>가입날짜</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
            <%if(list==null||list.isEmpty()) { %>
            <tr>
               <td colspan="9" align="center"> 검색결과가 없습니다.</td>
            </tr>
         <% } 
         else { 
            for(Member m : list)
            {         
         %>
         <tr>
            <td><%= m.getMember_id() %></td>
            <td><%=m.getMember_name()%></td>
                <td><%="M".equals(m.getGender())?"남":"여"%></td>
                <td><%=m.getEmail()%></td>
                <td><%=m.getPhone()%></td>
                <td><%=m.getAddress()%></td>
                <td><%=m.getMember_date()%></td>   
                 <td><a href="<%=request.getContextPath()%>/deleteMember?member_id=<%=m.getMember_id() %>"><input type="button" value="삭제"></a></td>
         </tr>
         <% }
         } %>
         </tbody>
      </table>
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