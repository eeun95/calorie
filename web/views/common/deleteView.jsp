<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
   String id=(String)request.getAttribute("member_id");

%>
<jsp:include page="header.jsp" />
<style>
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

#position {
	margin-left: 20%;
}
.toggle-button {
	margin: 0 20px;
}

.toggle-button {
	position: relative;
	display: inline-block;
	color: #fff;
}

.toggle-button label {
	display: inline-block;
	text-transform: uppercase;
	cursor: pointer;
	text-align: left;
}

.toggle-button input {
	display: none;
}

.toggle-button__icon {
	cursor: pointer;
	pointer-events: none;
}

.toggle-button__icon:before, .toggle-button__icon:after {
	content: "";
	position: absolute;
	top: 45%;
	left: 35%;
	transition: 0.2s ease-out;
}

.toggle-button--tuuli label {
	height: 50px;
	line-height: 50px;
	transition: all 0.2s;
	border-radius: 2rem;
}

.toggle-button--tuuli label:before, .toggle-button--tuuli label:after {
	position: absolute;
	right: 1rem;
	transition: all 0.2s .1s ease-out;
}

.toggle-button--tuuli input[type=checkbox]+label {
	width: 50px;
	background: #FF5335;
}

.toggle-button--tuuli input[type=checkbox]+label:before {
	opacity: 0;
	transform: translate(0, 20px);
}

.toggle-button--tuuli input[type=checkbox]+label:after {
	opacity: 1;
	transform: translate(0, 0);
}

.toggle-button--tuuli input[type=checkbox]:checked ~ label {
	width: 50px;
	background: #337ab7;
}

.toggle-button--tuuli input[type=checkbox]:checked ~
	.toggle-button__icon:before {
	transform: translate(-30%, 100%) rotate(45deg) scale(0.6, 1);
}

.toggle-button--tuuli input[type=checkbox]:checked ~
	.toggle-button__icon:after {
	transform: translate(20%) rotate(-45deg);
}

.toggle-button--tuuli .toggle-button__icon {
	position: absolute;
	height: 50px;
	width: 50px;
	top: 0;
	left: 0;
}

.toggle-button--tuuli .toggle-button__icon:before, .toggle-button--tuuli .toggle-button__icon:after
	{
	width: 25px;
	height: 3px;
	border-radius: 3px;
	background: #fff;
	box-shadow: 0 1px 0 rgba(0, 0, 0, 0.1);
	margin-left: -10%;
	top: 48%;
}

.toggle-button--tuuli .toggle-button__icon:before {
	transform: rotate(45deg);
}

.toggle-button--tuuli .toggle-button__icon:after {
	transform: rotate(-45deg);
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
				<li><a
					href="<%=request.getContextPath()%>/updateMember?member_id=<%=id %>">회원
						정보 수정</a></li>
				<li><a
					href="<%=request.getContextPath()%>/updatePassword?member_id=<%=id %>">비밀
						번호 수정</a></li>
				<li><a href="#">회원 탈퇴</a></li>
			</ul>
		</div>
		<!-- /사이드바 -->

		<!-- 본문 -->
		<div id="page-content-wrapper">
			<div class="container-fluid"
				style="margin-left: 20%; width: 80%; height: 100px;">
				<h3>회원 탈퇴전 다음 사항을 확인 해주시기 바랍니다.</h3>
				<ul>
					<li>개설된 사이트의 모든 데이터는 탈퇴해도 남아있습니다.</li>
					<li>회원 탈퇴를 해도 다시 가입이 가능합니다.</li>
				</ul>

			</div>
			<div id='position'>

				<img src="<%=request.getContextPath()%>/image/deleteId.jpg">

				<h2>회원 탈퇴 하시겠습니까?</h2>
				<form name="form" id="memberfrm" method="post">
					<div class="container">
						<section class="section section--tuuli">
							<div class="toggle-button toggle-button--tuuli">
								<input id="toggleButton3" type="checkbox"
									onClick="agreeCheck(this.form)"> <label
									for="toggleButton3"></label>
								<div class="toggle-button__icon"></div>
							</div>
						</section>
					</div>
					<input type="button" name="checkButton" class="btn btn-dafault"
						onclick="fn_delete_member();" value="예" disabled>
			</div>




		</div>
		<!-- /본문 -->
	</div>

	<jsp:include page="footer.jsp" />