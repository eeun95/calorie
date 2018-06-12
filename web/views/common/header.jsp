<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	//Member memberLoggedIn=(Member)request.getAttribute("memberLoggedIn");
	//HttpSession session1=request.getSession();
	//Member memberLoggedIn=(Member)(request.getSession().getAttribute("memberLoggedIn"));
	Member memberLoggedIn=(Member)session.getAttribute("memberLoggedIn");
	Cookie[] cookie=request.getCookies(); //받을때는 배열로 받아야한다.
	boolean saveId=false;
	String userIdSaved="";
	if(cookie!=null){
		for(Cookie c:cookie){
			String key=c.getName();  //saveId
			String value=c.getValue(); //userId
			if("saveId".equals(key)){
				saveId=true;
				userIdSaved=value;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식단관리 페이지</title>
<!-- 부트스트랩 footer -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style2.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script"
	rel="stylesheet">
<style>
	/*메인페이지에서 게시판 들어가는 드롭다운 효과*/
	.boarddown{position:relative;display:inline-block;}
	.boarddown-content{display:none;position:absolute;width:250px;background-color:#f9f9f9;z-index:1;padding:70px;list-style-type:none;}
	.boarddown:hover .boarddown-content{display:block;}
	#member_id, #member_pw {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;box-sizing: border-box;}
</style>
</head>
<body>
	<header>

		<div class='login'>
		<% if(memberLoggedIn==null) { %>
			<a href="Join.do">join</a>
			<a onclick="document.getElementById('login').style.display='block'">Login</a>
		<% }
		else {
		%>
			<a href="<%=request.getContextPath() %>/logout">logout</a>
			<p style="font-family:Nanum Pen Script,cursive;font-size:18px;float:right;margin-right:20px;"><%=memberLoggedIn.getMember_name()%>님 환영합니다. </p>
			<a href="<%=request.getContextPath()%>/updateMember?member_id=<%=memberLoggedIn.getMember_id() %>"><img src="<%=request.getContextPath()%>/image/update.jpg" style="float:right;width:30px;height:30px;"></a>
			<style>#homeName{margin-left: 5%;}</style>
		<% } %>
		</div>
		<div id="pageName">
			<!-- <h1 style="margin-left: 100px;">Calorie#</h1>
			<p>To be Healthy, To be Slim</p> -->
			<h1 style="margin-left: 5%;">
               <a  id="homeName" style="text-decoration: none;" href="<%=request.getContextPath() %>/index.jsp" >#Calorie</a>
            </h1>
                <p>To be Healthy, To be Slim</p>
			<hr>
			<div id="mainMenu" style='text-align: center;'>
				<a href="<%=request.getContextPath() %>/dietMealView" class='menu'>Diet Meal</a> 
				<span class="boarddown"><a href="#" class='menu'>Board</a>
					<ul class="boarddown-content">
						<li><a href="<%=request.getContextPath()%>/boardFreeMain"> 자유게시판 </a></li>
						<li><a href="<%=request.getContextPath()%>/boardRecipeList"> 나만의 레시피</a></li>
						<li><a href="<%=request.getContextPath()%>/boardReviewList"> 후기</a></li>
					</ul> 
				</span>
				<a href="#none" class='menu'>Calculator</a>
				<a href="<%=request.getContextPath() %>/diaryMain" class='menu'>D.Diary</a>
				<%if(memberLoggedIn!=null && "admin".equals(memberLoggedIn.getMember_id())){ %>
				<a class='menu' href="<%=request.getContextPath()  %>/memberList">administer<span class="animate_line"></span></a>
				<%} %>
			</div>
			<hr style="margin-bottom: 0px">
		</div>
	</header>
	<!-- 로그인 시작-->

   <div id="login" class="modal">
      <form class="modal-content animate"
         action="<%=request.getContextPath() %>/login">
         <div class="imgcontainer">
            <span
               onclick="document.getElementById('login').style.display='none'"
               class="close" title="Close Modal">&times;</span>
            <!--<img src="img_avatar2.png" alt="Avatar" class="avatar">-->
         </div>
         <div class="container">
            <label for="member_id"><b>아이디</b></label> <input type="text"
               placeholder="아이디입력" name="member_id" id="member_id" value="<%=saveId?userIdSaved:"" %>" required><br> <label
               for="member_pw"><b>비밀번호</b></label> <input type="password"
               placeholder="비밀번호 입력" name="member_pw" id="member_pw" required>

            <button class="loginbutton" type="submit">Login</button>
            <input type="checkbox" name="saveId" id="saveId" <%=saveId?"checked":"" %>>
            <label for="saveId">아이디저장</label>&nbsp;&nbsp;
         </div>

         <div class="container" style="background-color: #f1f1f1">
            <button type="button"
               onclick="document.getElementById('login').style.display='none'"
               class="cancelbtn">Cancel</button>
            <span class="password"><a href="<%=request.getContextPath()%>/views/common/FindPassword.jsp"><input type="button" 
               value="비밀번호찾기"></a></span>
         </div>
      </form>
   </div>
   <script>
               // Get the modal
               var modal = document.getElementById('login');

               // When the user clicks anywhere outside of the modal, close it
               window.onclick = function(event) {
                     if (event.target == modal) {
                       modal.style.display = "none";
                     }
               }
      </script>
   <!-- 로그인 끝 -->
	<section>