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

function fn_enroll_validate()
{
	var member_id=$("#member_id_");
	if(member_id.val().length<4)
	{
		alert("아이디는 최소 4자리 이상이어야 합니다.");
		member_id.focus();
		return false;
	}
	return true;
}
//중복검사를 위한 별도의 서블릿 요청 함수
function fn_checkIdDuplicate() {
	//아이디가 있는지 체크~
	var member_id=$("#member_id_").val().trim();
	if(!member_id||member_id.length<4){  //userId에 값이 없거나 아이디글자수가 4글자 이하일때 실행
		alert("아이디는 4자이상 입력 입력하세요");
		return;
	}
	var url="<%=request.getContextPath()%>/checkIdDuplicate";
	var title="checkIdduplicate";
	var status="left=500px,top=100px,width=300px,height=200px";
	var popup=window.open("",title,status);
	
	checkIdDuplicateFrm.member_id.value=member_id;
	checkIdDuplicateFrm.target=title;
	checkIdDuplicateFrm.action=url;
	checkIdDuplicateFrm.method="post";
	checkIdDuplicateFrm.submit();
}
function fn_emailcheck() {
	var emailch=$("#email").val();
	var url="<%=request.getContextPath()%>/emailAuth?email="+emailch;
	var title="emailAuth";
	var status="left=500px,top=100px,width=600px,height=200px";
	var popup=window.open(url,title,status);
}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullRoadAddr;
                //document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<body>
	<!-- 회원가입 -->
	<div align="center">
		<h2>회원가입정보 입력</h2>
		<form action="<%=request.getContextPath()%>/MemberEnrollEnd"
			method="post" onsubmit="return fn_enroll_validate();"
			style="width: 30%;">
			<table class="table">
				<tr>
					<th>아이디</th>
					<td><input type="text" placeholder="4글자 이상" name="member_id"
						id="member_id_" required> <input type="button"
						value="중복확인" onclick="fn_checkIdDuplicate();" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" placeholder="8글자 이상(영문,숫자,특수문자)" name="member_pw" id="member_pw_"
						required><br></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="member_pwcheck"
						id="member_pw_2" required><br></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="member_name" id="member_name"
						required></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="phone"
						placeholder="-(없이)01012345678" id="phone" maxlength=11 required></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="email" placeholder="abc@ab.com" id="email">
						<button type="button" onclick="fn_emailcheck();" id='chbtn'>이메일인증</button>
						<span id='check'></span>
						
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" id="address" placeholder="도로명주소">
						<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
						<span id="guide" style="color:#999"></span>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="gender" id="gender0" value="M"
						checked> <label for="gender0">남</label> <input
						type="radio" name="gender" id="gender1" value="F"> <label
						for="gender1">여</label></td>
				</tr>

			</table>
			<input type="submit" value="가입"> <input type="reset"
				value="취소">
		</form>
		<form name="checkIdDuplicateFrm" method="post">
			<input type="hidden" name="member_id" />
		</form>

	</div>
	<jsp:include page="footer.jsp" />