<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
    background-color: inherit;
    float: left;
    border: none;
    outline: none;
    cursor: pointer;
    padding: 14px 16px;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
    background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
    
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}

</style>
</head>
<body>

<h2 align="center">GM 다이어트</h2>

<div class="tab">
  <button class="tablinks active"  onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요</h3>
  <p>GM 다이어트는 일주일 동안 다소 엄격한 식단을  따르는 다이어트 방법입니다.</p>
  <p>식단이 엄격하기는 하지만 극단의 결심이 있어야 성공할 수 있는 것은 아닙니다.</p>
  <p>섭취하는 음식 양에 특별히 제한을 두지 않기 때문에 배고픔에 허덕이지 않는 일종의 먹으면서 하는 다이어트라고 볼 수 있기 때문입니다.</p>
  <h3>효과</h3>
  <p>7일이라는 짧은 기간이지만 식단대로 따르기만 하면 최대 8Kg까지 감량할수 있다.</p>
  <p>일주일간 철저한 저염분 식단을 통해 몸 안의 독서와 함께 붓기 제거의 다이어트 효과를 얻을 수 있다.</p>
</div>

<div id="dietMenu" class="tabcontent"  style="display:none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/GM_menu.jpg">
  <ul>
  	<li>1일 : 바나나를 제외한 과일만 먹기</li>
  	<li>2일 : 감자를 제외한 채소만 먹기</li>
  	<li>3일 : 바나나와 감자를 제외한 과일&채소만 먹기</li>
  	<li>4일 : 바나나 8~9개와 저지방 우유 3잔만 먹기</li>
  	<li>5일 : 쇠고기 또는 닭가슴살과 토마토 6개만 먹기</li>
  	<li>6일 : 쇠고기 또는 닭가슴살 야채만 먹기</li>
  	<li>7일 : 현미밥 한 공기, 과일주스, 채소 먹는 날</li>
  </ul>
</div>

<div id="precautions" class="tabcontent" style="display:none">
  <h3>주의사항</h3>
  <p>7일 기간 중 소금과 설탕은 철저히 통제 해야 합니다.</p>
  <p> 당 성분은 과일 등에 포함된 천연 당으로 한정 해야 합니다.</p>
  <p>GM다이어트는 일주일간 식단을 유지하도록 하며, 끝난 후엔 반드시 보식 기간을 가지도록 합니다.</p>
  <ul>
  	<li>하루 1.5ℓ 이상 물 마시기</li>
  	<li>금주</li>
  	<li>채소를 먹을 땐, 드레싱을 뿌리지 않고 먹는다</li>
  	<li>블랙커피, 홍차 이외에 당분은 피하는 것이 좋다</li>
  	<li>일주일 식단 실천 후, 보식 기간을 가진다</li>
  	<li>부작용이 의심된다면, 반드시 다이어트를 중단한다</li>
  </ul>
</div>

<script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>

</body>
</html>





