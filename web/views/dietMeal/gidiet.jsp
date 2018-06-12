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

<h2 align="center">GI 다이어트</h2>

<div class="tab">
  <button class="tablinks active" onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요</h3>
  <p>다른저인슐린 다이어트 이며 연구자에 따라서는 애트킨스(Atkins)식 다이어트, 저탄수화물 다이어트(Low carbo diet)라 부르기도 합니다. </p>
  <p>혈당지수(GI, Glycemic Index)가 낮은 음식물을 먹는 다이어트 방법입니다.</p>
  <p>당지수가 낮은 음식들은 각종 과일, 채소, 해조류를 비롯해 현미와 잡곡류,콩으로 만든 식품등이 있다.</p>
  <h3>효과</h3>
  <p>배불리 먹고 살을 뺀다.</p>
  <p>GI 수치가 낮은 음식은 소화 속도가 느려 포만감이 오래 가기 때문에 많이 먹게 되지 않는다.</p>
  <p>필요한 만큼 먹고 그것이 에너지로 사용되기 때문에 지방이 축적되지 않아 균형잡인 몸매를 유지시켜준다.</p>
  <p>요요현상 zero!</p>
  <p>식사제한을 하는 것이 아니기 때문에 몸의 균형이 깨지지 않고, 배고픔을 참지 않아도 되므로 누구나 쉽게 할 수 있다.</p>
</div>

<div id="dietMenu" class="tabcontent"  style="display:none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/GI_menu.jpg">
</div>

<div id="precautions" class="tabcontent" style="display:none">
  <h3>주의사항</h3>
  <p>-GI 수치가 60이하인 식품을 골라먹는다.<br>
  GI 수치가 높은 음식에는 당분과 탄수화물이 많이 들어 있기 때문에 조심해야 한다.</p>
  <p>-천천히 꼭꼭 씹어먹는다.<br>
  음식을 빨리 먹으면 혈당치가 급상승하고 인슐린 분비가 많아진다. 이로 인해 다시 혈당치가 급격하게 떨어지면서 배고픔을 느끼게 되고 따라서 먹는 양도 늘어난다.</p>
  <p>-GI 수치가 높은 식품은 유제품, 식초, 식이섬유와 함께 먹어야 한다.</p>
  <p>-식후 디저트는 피하고 간식을 먹자.</p>
  <p>-운동으로 효과 up!</p>
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





