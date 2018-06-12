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

<h2 align="center">Denmark 다이어트</h2>

<div class="tab">
  <button class="tablinks active" onclick="openCity(event, 'effect')">개요 및 효과</button>
  <button class="tablinks" onclick="openCity(event, 'dietMenu')">식단</button>
  <button class="tablinks" onclick="openCity(event, 'precautions')">주의사항</button>
</div>

<div id="effect" class="tabcontent">
  <h3>개요 및 효과</h3>

  <p>덴마크 병원에서 심장수술을 앞둔 환자에게 수술 성공률을 높이기 위해 효과 빠른 다이어트를</p>
  <p>할 수 있도록 체계적이면서도 혹독한 식단표를 개발하게 되었고, 기간은 2주정도를 기본으로</p>
  <p> 하는 다이어트 프로그램이다.</p>
</div>

<div id="dietMenu" class="tabcontent"  style="display:none">
  <h3>식단</h3>
  <img src="<%=request.getContextPath()%>/image/denmark_menu.jpg">
  <p>계란(반드시 삶아서), 자몽(비타민 보충을위한 필수), 토스트(버터나 설탕첨가 no),
	블랙커피(설탕 프림 no), 야채샐러드(식초,레몬즙으로 드레싱), 고기(기름없이 굽거나 쪄서 닭가슴살 good)
  </p>
</div>

<div id="precautions" class="tabcontent" style="display:none">
  <h3>주의사항</h3>
  <p>프로그램 기간중 식단을 어기면 효과가 떨어져 처음부터 다시해야 하고,
   예정기간 이상으로 진행하면 몸에 무리가 갈 수 있으니 자제해야한다.</p>
  <p>짧은기간에 효과를 볼 수 있겠지만 무리하게 진행하게 되면 영향 결핍과 요요등의 부작용이 올 수 있다.</p>
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





