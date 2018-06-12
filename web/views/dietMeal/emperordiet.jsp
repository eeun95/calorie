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

<h2 align="center">Emperor(황제) 다이어트</h2>

<div class="tab">
  <button class="tablinks active" onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요</h3>

  <p>황제다이어트란, 말 그대로 황제같이 호화롭고 배부르게 다이어트를 하는 것이다.</p>
  <p>한때 꿈의 다이어트로 불렸던 다이어트입니다.</p>
  <p>소고기만 먹으면서 살을 빼는 것.</p>
  <p>이 다이어트는 미국의사 애킨스가 저술한 다이어트의 혁명에 개제된 다이어트입니다.</p>
  <h3>효과</h3>
  <p>어떤 사람들은 이 다이어트를 하므로써 근육도 생길 뿐만아니라 몸도 건강!! </p>
  <p>살도 빠지는 효과도 가져오지만 어떤 분들의 경우는 오히려 역효과를 나타내기도 합니다.</p>
</div>

<div id="dietMenu" class="tabcontent"  style="display:none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/emperor_menu.jpg">
  <p>황제다이어트의 가장 큰 핵심은 저탄수화물,고단백 섭취입니다.</p>
  <p>따라서 밥,감자,옥수수 등 탄수화물 함유 식품은 섭취하지 않고 식이섬유가 풍부한 채소와 고기를 곁들여 먹으면 됩니다.</p>
  <p>고기가 물리면 생선이나 닭가슴살, 계란 등 탄수화물이 없고 단백질이 많은 음식을 먹으면 됩니다.</p>
  <p>고기를 먹을 때는 고기를 양념에 조리하지 않고 먹어야 합니다.</p>
</div>

<div id="precautions" class="tabcontent" style="display:none">
  <h3>주의사항</h3>
  <p>황제다이어트는 고기를 이용한 다이어트로 고단백을 섭취하여 근육량을 늘리면서 살을 빼는 방법 이지만</p>
   <p>고기를 많이 먹으면 혈중 콜레스테롤 수치가 높아져 심장관련질환,뇌졸증관련 질병 발생 확률이 높아집니다.</p>
  <p>또한 탄수화물 부족 현상으로 짜증이 나기도 하고, 지방세포를 에너지원으로 전환을 할 때는 체내의 수분과 칼슘,칼륨이 빠져나가게 됩니다.
  <p>따라서 탄수화물은 소량으로 섭취하고, 단백질을 많이 섭취함으로써 포만감을 늘려 폭식을 막으며 운동을 병행 하는 것이 중요하다.</p>
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





