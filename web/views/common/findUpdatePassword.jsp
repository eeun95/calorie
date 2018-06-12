<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
	Member member=(Member)request.getAttribute("member");
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
</style>
<script>
$(function(){
	$("#member_pw_").blur(function(){
		var p1=$("#member_pw_").val();
		if(p1.length==0){
			
		}
		else{
			if(p1.length<8 || !p1.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
			    alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
			    $("#member_pw_").val("");
			    $("#member_pw_").focus();
				return false;
		  	}
		}
		return true;
		
	});
	$("#member_pw_2").blur(function(){
		var p1=$("#member_pw_").val();
		var p2=$("#member_pw_2").val();
	  	if(p1!=p2)
			{
				alert("패스워드가 일치하지 않습니다.");
				$("#member_pw_").focus();
				$("#member_pw_").val("");
				$("#member_pw_2").val("");
			}	
	});
});
</script>
<body>
	<!-- 회원가입 -->
	<div align="center">
		<h2>비밀번호 찾기(2단계)</h2>
		<form action="<%=request.getContextPath()%>/findPasswordEnd.do"
			method="post" onsubmit="return fn_enroll_validate();"
			style="width: 30%;">
			<table class="table">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="member_id" value="<%=member.getMember_id() %>" readonly></td>
				</tr>
				<tr>
					<th>새로운 비밀번호</th>
					<td><input type="password" placeholder="8글자 이상(영문,숫자,특수문자)" name="member_pw" id="member_pw_"
						required><br></td>
				</tr>
				<tr>
					<th>새로운 비밀번호 확인</th>
					<td><input type="password" name="member_pwcheck"
						id="member_pw_2" required><br></td>
				</tr>
			</table>
			<input type="submit" value="확인">
		</form>
	</div>
	<jsp:include page="footer.jsp" />