<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
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
</style>
<script>
function fn_emailcheck() {
	var emailch=$("#email").val();
	var url="<%=request.getContextPath()%>/emailAuth?email="+emailch;
	var title="emailAuth";
	var status="left=500px,top=100px,width=600px,height=200px";
	var popup=window.open(url,title,status);
}
$(function() {
	$('#next').click(function() {
		var emailcheck=$('#check').html();
		if(emailcheck!="인증완료"){
			alert("이메일 인증이 필요합니다.");
			return false;
		}
		return true;
	});
});
   
</script>
<body>
	<!-- 회원가입 -->
	<div align="center">
		<h2>비밀번호 찾기(1단계)</h2>
		<form id="fpw" action="<%=request.getContextPath()%>/findPassword.do" method="post" style="width: 30%;">
			<table class="table">
				<tr>
					<th>아이디</th>
					<td><input type="text" placeholder="아이디 입력" name="member_id"
						id="member_id_" required></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name" id="member_name" placeholder="이름 입력"
						required></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" placeholder="이메일 입력" id="email">
						<button type="button" onclick="fn_emailcheck();" id='chbtn'>이메일인증</button>
						<span id='check'></span>
						
					</td>
				</tr>
			</table>
			<input id='next' type="submit" value="확인">
		</form>
	</div>
<jsp:include page="footer.jsp" />