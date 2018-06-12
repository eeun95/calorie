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
   function fn_delete_member(){
      var frm=$("#memberfrm");
      var url="<%=request.getContextPath()%>/memberDelete?member_id=<%=id%>";
      frm.attr('action',url);
      frm.submit();
   }
   function agreeCheck(frm)
   {
      if (frm.checkButton.disabled==true)
       frm.checkButton.disabled=false
      else
       frm.checkButton.disabled=true
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
				<li><a href="<%=request.getContextPath()%>/updatePassword?member_id=<%=id %>">비밀 번호 수정</a></li>
				<li><a href="#">회원 탈퇴</a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div id="page-content-wrapper">
			<div class="container-fluid"
				style="margin-left: 30%; border: 1px solid black; width: 400px; height: 300px;">
				<h2>회원 탈퇴 하시겠습니까?</h2>
				<form name="form" id="memberfrm" method="post"> 
				<label>동의</label><input type="checkbox" name="agree" onClick="agreeCheck(this.form)">
					<input type="button" name="checkButton" onclick="fn_delete_member();" value="예" disabled>
				</form>
			</div>
		</div>
		<!-- /본문 -->
	</div>

	<jsp:include page="footer.jsp" />