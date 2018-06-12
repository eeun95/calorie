<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String email=(String)request.getAttribute("email");
	String authNum=(String)request.getAttribute("authNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<script>
function check(){
    var form = document.authenform;
    var authNum =${authNum};
	var check="";
    if(!form.authnum.value){
        alert("인증번호를 입력하세요.");
        return false;
    }
    if(form.authnum.value!=authNum){
        alert("틀린 인증번호입니다. 인증번호를 다시입력해주세요.");
        form.authnum.value="";
        return false;
    }
    if(form.authnum.value==authNum){
        alert("인증완료");    
        $("#check",opener.document).html("인증완료");
        $("#chbtn",opener.document).css("display",'none');
        self.close();
    }
    
}
</script>
<center>
<br /><br />
<h5>인증 번호 7자리를 입력하세요</h5>

<div class="container">
    <form method="POST" name="authenform" onsubmit="return check();">
        <input type="text" name="authnum"><br /><br />
        <input type="submit" class="btn btn-info" value="submit">
    </form>
</div>
</center>
</body>
</html>