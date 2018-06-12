<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
   String id=(String)request.getAttribute("member_id");
%>
<jsp:include page="header.jsp" />
<style>
#userId_ {
   width: 60%;
}

.table tr td input {
   height: 30px;
}

.table tr td input[type=password] {
   width: 60%;
}

.table tr td input#userName, input#age {
   width: 20%;
}

#page-wrapper {
   padding-left: 250px;
}

#sidebar-wrapper {
   position: fixed;
   width: 250px;
   height: 100%;
   margin-left: -250px;
   background: white;
   overflow-x: hidden;
   overflow-y: auto;
}

#page-content-wrapper {
   width: 100%;
   padding: 20px;
}
/* 사이드바 스타일 */
.sidebar-nav {
   width: 250px;
   margin: 0;
   padding: 0;
   list-style: none;
}

.sidebar-nav li {
   text-indent: 1.5em;
   line-height: 2.8em;
}

.sidebar-nav li a {
   display: block;
   text-decoration: none;
   color: #337ab7;
}

.sidebar-nav li a:hover {
   color: white;
   background: gray;
}

.sidebar-nav>.sidebar-brand {
   font-size: 1.3em;
   line-height: 3em;
}
</style>
<script src="//code.jquery.com/jquery.min.js"></script>
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script>   
function fn_update_password() {
    
    var url="<%=request.getContextPath()%>/updatePasswordEnd";
    var status="left=500px, top=200px, width=400px, height=210px";
    var title="updatePassword";
    
    var popup=window.open(url,title,status);
    
 }
</script>
<body>
   <div id="page-wrapper">
      <!-- 사이드바 -->
      <div id="sidebar-wrapper">
         <ul class="sidebar-nav">
            <li class="sidebar-brand">
               <h2>회원 정보</h2>
            </li>
            <li><a href="<%=request.getContextPath()%>/updateMember?member_id=<%=id %>">회원 정보 수정</a></li>
            <li><a href="#">비밀 번호 수정</a></li>
            <li><a href="<%=request.getContextPath()%>/deleteView?member_id=<%=id %>">회원 탈퇴</a></li>
         </ul>
      </div>
      <!-- /사이드바 -->

      <!-- 본문 -->
      
<div id="updatePassword-container">
      <form name="updatePwdFrm" action="<%=request.getContextPath()%>/updatePasswordEnd" method="post" >
         <table>
            <tr>
               <th>현재 비밀번호</th>
               <td><input type="password" name="member_pw" id="member_pw" required></td>
            </tr>
            <tr>
               <th>변경할 비밀번호</th>
               <td>
                  <input type="password" name="member_pw_new" id="member_pw_new" required>
               </td>
            </tr>
            <tr>
               <th>비밀번호 확인</th>
               <td>   
                  <input type="password" id="member_pw_chk" required><br>
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="submit" onclick="return password_validate();" value="변경" />
               </td>
            </tr>
         </table>
         <input type="hidden" name="member_id" value="<%=id%>" />
      </form>
   </div>
      <!-- /본문 -->
   </div>

   <jsp:include page="footer.jsp" />