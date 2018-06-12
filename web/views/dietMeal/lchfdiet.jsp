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

<h2 align="center">LCHF(저탄고지) 다이어트</h2>

<div class="tab">
  <button class="tablinks active" onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요</h3>
  <p>식이요법의 일종.</p>
  <p>이 식단의 핵심은 단순히 지방을 많이 먹는 것이 아니라 전체적 열량을 유지하면서 탄수화물이 </p>
  <p>들어간 음식은 줄이고 지방이 들어간 음식은 늘려, 신체에서 비정상적으로 작용하던 인슐린저항성 수치를 정상으로 되돌리는 것이다.</p>
  <p>저탄고지 다이어트 는 다양한 연구 결과 체지방을 감소시키는 것으로 그 효과가 입증되었습니다</p>
</div>

<div id="dietMenu" class="tabcontent" style="display: none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/lchf_menu.jpg" width="100%" height="100%">
  <ul>
  	<li>생선, 살코기, 달걀을 식단의 35%로 구성하고, 채소류로 45%, 과일 10, 견과류 10% 정도로 식단을 구성합니다.</li>
  	<li>총 칼로리 양은 본인에게 권장되는 칼로리 양으로 정하시면 됩니다.</li>
  </ul>
</div>

<div id="precautions" class="tabcontent" style="display: none">
  <h3>주의사항</h3>
  <p>저탄고지 다이어트가 국내에 잘못 알려져 극단적으로 지방만 섭취하는 다이어터들이 있는 것 같습니다.이런 극단적인 식단은 바로 우리 몸의 신진대사를 망치게 됩니다.</p>
  <p>절대로 한 두가지의 식품으로 지방만 섭취하거나 탄수화물을 아예 끊는 잘못된 식단을 선택하시면 안됩니다!</p>
  <p>가능하면 건강한 잡곡류(오트밀, 퀴노아 등)나 뿌리채소(고구마, 감자 등)로 탄수화물을 섭취해주면서 운동을 겸하시기를 추천합니다.</p>
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





