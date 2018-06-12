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

<h2 align="center">Lemon Detox(레몬 디톡스) 다이어트</h2>

<div class="tab">
  <button class="tablinks active" onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요</h3>
  <p>디톡스(정화) 식단은 말 그대로 몸을 정화하기 위한 식단입니다.</p>
  <p>단기간에 신진대사에 필요한 미네랄과 최소의 영양분만 공급하여 신체를 정화시키고 지나치</p>
  <p>게 많은 지방 도는 축적된 노페물을 우리 몸에서 제거하는 것을 목적으로 하는 다이어트법입니다.</p>
  <p>음식을 섭취하지 않고 주어진 재료만 섭취하여 칼로리를 제한 해야 합니다.</p>
  <h3>효과</h3>
  <p>다이어트 기간 동안 체내에 쌓여 있던 성분을 분해해 불필요한 노페물을 몸 밖으로 배출하여 </p>
  <p>해독 효과 및 소화 긴능 증진과 피부트러블 해소효과까지 볼수있습니다.</p>
  <p>레몬디톡스 음료의 신맛에 익숙해 지면 군것질과 폭식이 줄어듭니다.</p>
</div>

<div id="dietMenu" class="tabcontent" style="display: none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/Lemon_menu.jpg" width="100%" height="100%">
  <img src="<%=request.getContextPath()%>/image/Lemon_menu2.jpg" width="100%" height="100%">
</div>

<div id="precautions" class="tabcontent" style="display: none">
  <h3>주의사항</h3>
  <p>3일정도 준비기간을 갖고 원래 먹던 양을 1/3로 줄입니다.</p>
  <p>레몬디톡스 다이어트에 들어가기 시작하면 밥을 먹지 않아야 하기 때문에 준비기간 동안 식사량을 최대한 줄여나갑니다.</p>
  <p>다이어트 기간은 1주일에서 10일이내여야 하며 다이어트 기간 중에는 물을 제외한 다른 음식물 섭취를 하지 않으며, 배고플때마다 레몬디톡스 드링크물을 마셔주면 신기하게 포만감이 생겨 배고픈 느낌이 사라져 자연스럽게 다이어트가 됩니다.</p>
  <p>다이어트 기간이 끝나고 곧바로 많은 양의 음식을 섭취하면 요요현상이 오기 쉬우므로 죽이나 미음같은 연한 음식을 조금씩 먹다가 일반식으로 서서히 바꿔서 섭취하고 물과 허브티를 수시로 마셔 줍니다.</p>
  <p>이러한 보식기간에 음식을 천천히 조금씩 섭취하여야 하며 늘어난 칼로리를 소화히기위해 운동을 반드시 병행해야 합니다.</p>
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





