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
 #page-wrapper {
    padding-left: 250px;
  }
  
  #sidebar-wrapper {
    position: fixed;
    width: 250px;
    height: 100%;
    margin-left: -250px;
    background:   white;
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
    color:    white;
    background: gray;
  }
  
  .sidebar-nav > .sidebar-brand {
    font-size: 1.3em;
    line-height: 3em;
  }
</style>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script>
   function fn_update_member(){
      var frm=$("#memberfrm");
      var url="<%=request.getContextPath()%>/memberUpdateEnd";
      frm.attr('action',url);
      frm.submit();
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
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
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
<div id="page-wrapper">
  <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
      <li class="sidebar-brand">
         <h2>회원 정보</h2>
      </li>
      <li><a href="#">회원 정보 수정</a></li>
      <li><a href="<%=request.getContextPath()%>/updatePassword?member_id=<%=member.getMember_id()%>">비밀 번호 수정</a></li>
      <li><a href="<%=request.getContextPath()%>/deleteView?member_id=<%=member.getMember_id()%>">회원 탈퇴</a></li>
    </ul>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
  <div id="page-content-wrapper">
   <div class="container-fluid" style="margin-left:30%;">
      <h2>회원정보 수정</h2>
      <form id="memberfrm" method="post" style="width: 40%;">
         <table class="table">
            <tr>
               <th>아이디</th>
               <td><input type="text" placeholder="4글자 이상" name="member_id" id="member_id_" value="<%=member.getMember_id()%>" readonly></td>
            </tr>
            
            <tr>
               <th>이름</th>
               <td><input type="text" name="member_name" id="member_name" value="<%=member.getMember_name()%>"  readonly></td>
            </tr>
            <tr>
               <th>이메일</th>
               <td><input type="email" name="email" id="email" value="<%=member.getEmail()%>" readonly></td>
            </tr>
            <tr>
               <th>전화번호</th>
               <td><input type="tel" name="phone"
                  placeholder="-(없이)01012345678" id="phone" maxlength=11 value="<%=member.getPhone()%>" required></td>
            </tr>
            <tr>
               <th>주소</th>
               <td><input type="text" name="address" id="address" value="<%=member.getAddress()%>">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
					<span id="guide" style="color:#999"></span>
				</td>
            </tr>
            <tr>
                    <th>성별</th>
                  <td>
                  <%if("M".equals(member.getGender())) {%>
                     <input type="radio" name="gender" id="gender0" value="M" checked>
                     <label for="gender0">남</label>
                     <input type="radio" name="gender" id="gender1" value="F">
                     <label for="gender1">여</label>
                 <%} else{ %>
                     <input type="radio" name="gender" id="gender0" value="M" >
                     <label for="gender0">남</label>
                     <input type="radio" name="gender" id="gender1" value="F" checked>
                     <label for="gender1">여</label>
                 <%} %>
                 </td>
             </tr>
         </table>
         <input type="button" onclick="fn_update_member();" value="정보수정" style="margin-left:30%;">
      </form>
   </div>
     
  </div>
  <!-- /본문 -->
</div>
   <!-- 회원가입 -->
   
   <jsp:include page="footer.jsp" />