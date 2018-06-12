<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<style>
#d1 {
   display: inline-block;
   width: 60%;
   height: 400px;
   background-image:
      url("http://cfile2.uf.tistory.com/image/235FC83B50CADE281CC73D");
   margin-left: 20%;
}

#d1 img {
   display: inline-block;
   width: 50%;
   height: 400px;
   margin-left: 25%;
}

#d1s img {
   display: inline-block;
   width: 60%;
   height: 265px;
   margin-left: 20%;
}

#d2s img {
   display: inline-block;
   width: 60%;
   height: 265px;
   margin-left: 20%;
}

#d3s img {
   display: inline-block;
   width: 60%;
   height: 265px;
   margin-left: 20%;
}

#d2 {
   display: inline-block;
   width: 60%;
   height: 800px;
   background-color: white;
   margin-left: 20%;
}

#d3 {
   display: inline-block;
   width: 60%;
   height: 450px;
   background-image:
      url("https://youtu.be/bmFHyKHnCkw");
   margin-left: 20%;
}

#mouse_menu {
	border-top:1px solid black;
	border-bottom:1px solid black;
   position: fixed;
   top: 40%;
   left: 90%;
   }
   #mouse_menu table {
      width: 90px;
   }
   #mouse_menu table tr td a{
      color: dark-gray;
   }
.jbFixed {
   width: 99%;
   font-family: Nanum Pen Script, cursive;
   font-size: 20px;
   color: gray;
   /* margin-left:34%;*/
   /* margin-right:34%; */
   text-decoration: none;
   text-align: center;
   position: fixed;
   top: 0px;
   background-color: white;
}

#p1 {
   font-family: 'Nanum Pen Script', cursive;
   width: 80%;
   height: 88%;
   margin-left: 10%;
   margin-top: 3%;
   padding: 5px;
   font-size: 35px;
   font-weight: bold;
   text-align: center;
   background-color: #ffffff;
   background-color: rgba(255, 255, 255, 0.5);
}

#d2 table tr td{
   width: 25%;
}
#div1 {
   width: 200px;
   height: 200px;
   border: 1px soild black;
   font-family: Nanum Pen Script, cursive;
   margin: auto;
}

#mainMenu{
   display: none;
}
#pageName hr:last-child{
   border: 0px;
}
.menubar{
   width: 100%;
}
</style>
<script type="text/javascript">
  $(window).resize(function(){resizeYoutube();});
  $(function(){resizeYoutube();});
  function resizeYoutube(){ $("iframe").each(function(){ if( /^https?:\/\/www.youtube.com\/embed\//g.test($(this).attr("src")) ){ $(this).css("width","100%"); $(this).css("height",Math.ceil( parseInt($(this).css("width")) * 480 / 854 ) + "px");} }); }
</script>
<%@ include file="/views/common/header.jsp" %>
   <div>
      
      <div class='menubar' style='text-align: center;'>
         <a href="#d1s" class='menu'>다이어트 효과</a> 
         <a href="#d2s" class='menu'>다이어트 방법</a> 
         <a href="#d3s" class='menu'>동영상</a>
         <hr style="margin-bottom: 0px">
      </div>
      <script>
                $('.menu').css({ "font-family": "Nanum Pen Script, cursive", "font-size": "20px", "color": "gray", "margin": "70px", "text-decoration": "none", "text-align": "center" });
            </script>

   </div>
   </header>
   <section>
      <div id='d1s' style='display: inline-block; width: 100%; height: 50px'>
      </div>
      <div id='d1' name='d1'>
         <table id='p1'>
            <tr>
               <td><p>1. 건강에 좋다.</p></td>
               <td><p>4. 목표를 달성할 수 있다.</p></td>
            </tr>
            <tr>
               <td><p>2. 자신감을 키울 수 있다.</p></td>
               <td><p>5. 스트레스를 줄일 수 있다.</p></td>
            </tr>
            <tr>
               <td><p>3. 활기를 찾을 수 있다.</p></td>
               <td><p>6. 원하는 옷을 입을 수 있다.</p></td>
            </tr>
         </table>
      </div>
      <!--다이어트 개요-->
      <div id='d2s' style='display: inline-block; width: 100%; height: 50px'>
      </div>
      <div id='d2' name='d2'>
         <!--<button onclick="window.open('새창페이지URL','asdfo8or','scrollbars=yes,width=417,height=385,top=10,left=20');">자세히보기</button>-->
         <table style='width: 100%;'>
            <tr>
               <td><img src='<%=request.getContextPath() %>/image/gm.jpg' width="100%" height="80%"></td>
               <td>
                  <div id='div1'>
                     <p>GM 다이어트는 일주일 동안 다소 엄격한 식단을 따르는 다이어트 방법입니다. 식단이 엄격하기는 하지만
                     극단의 결심이 있어야 성공할 수 있는 것은 아닙니다. 섭취하는 음식 양에 특별히 제한을 두지 않기 때문에 배고픔에
                     허덕이지 않는 일종의 먹으면서 하는 다이어트라고 볼 수 있기 때문입니다.</p>
                     <button
                        onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/gmdiet.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button>
                  </div>
               </td>
               
                  
               <td><img src='<%=request.getContextPath() %>/image/gi.jpg' width="100%" height="80%"></td>
               <td>
                  <div id='div1'>
                     <p>다른저인슐린 다이어트 이며 연구자에 따라서는 애트킨스(Atkins)식 다이어트, 저탄수화물 다이어트(Low carbo diet)라 부르기도 합니다. 
                     혈당지수(GI, Glycemic Index)가 낮은 음식물을 먹는 다이어트 방법입니다.
                     당지수가 낮은 음식들은 각종 과일, 채소, 해조류를 비롯해 현미와 잡곡류,콩으로 만든 식품등이 있다.</p>
                     <button
                        onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/gidiet.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button>
                  </div>
               </td>
            </tr>
            
            
            <tr>
               <td><img src='<%=request.getContextPath() %>/image/emperor.jpg' width="100%" height="80%"></td>               
               <td>
                  <div id='div1'>
                  <p>황제다이어트란, 말 그대로 황제같이 호화롭고 배부르게 다이어트를 하는 것이다. 
                  한때 꿈의 다이어트로 불렸던 다이어트입니다. 소고기만 먹으면서 살을 빼는 것. 
                  이 다이어트는 미국의사 애킨스가 저술한 다이어트의 혁명에 개제된 다이어트입니다.</p>
                     <button
                        onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/emperordiet.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button>                  
                  </div>            
               </td>
               
               <td><img src='<%=request.getContextPath() %>/image/denmark.jpg' width="100%" height="80%"></td>
               <td>
                  <div id='div1'>
                     <p>덴마크 병원에서 심장수술을 앞둔 환자에게 수술 성공률을 높이기 위해 효과 빠른 다이어트를
                         할 수 있도록 체계적이면서도 혹독한 식단표를 개발하게 되었고, 기간은 2주정도를 기본으로 하는
                          다이어트 프로그램이다.</p>
                     <button
                        onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/denmarkdiet.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button>
                  </div>
               </td>

            </tr>
            <tr>
               <td><img src='<%=request.getContextPath() %>/image/lchf.jpg' width="100%" height="80%"></td>
               <td><div id='div1'>
               <p>식이요법의 일종. 이 식단의 핵심은 단순히 지방을 많이 먹는 것이 아니라 전체적 열량을 유지하면서 탄수화물이 들어간 음식은 줄이고 지방이 들어간 음식은 늘려, 신체에서 비정상적으로 작용하던 인슐린저항성 수치를 정상으로 되돌리는 것이다.</p>
               <button onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/lchfdiet.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button></div></td>
               <td><img src='<%=request.getContextPath() %>/image/lemon.jpg' width="100%" height="80%"></td>
               <td><div id='div1'>
               <p>디톡스(정화) 식단은 말 그대로 몸을 정화하기 위한 식단입니다. 단기간에 신진대사에 필요한 미네랄과 최소의 영양분만 공급하여 신체를 정화시키고 지나치게 많은 지방 도는 축적된 노페물을 우리 몸에서 제거하는 것을 목적으로 하는 다이어트법입니다. 음식을 섭취하지 않고 주어진 재료만 섭취하여 칼로리를 제한 해야 합니다.</p>
               <button onclick="window.open('<%=request.getContextPath() %>/views/dietMeal/lemondetox.jsp','asdfo8or','scrollbars=yes,width=700,height=600,top=10,left=20');">자세히보기</button></div></td>
            </tr>
         </table>
      </div>
      <!--다이어트 방법 및 소개-->
      <div id='d3s' style='display: inline-block; width: 100%; height: 50px'>
      </div>
      <div id='d3' name='d3' align="center">
      <iframe width="854" height="480" src="https://www.youtube.com/embed/bmFHyKHnCkw" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
      </div>

      <!--칼로리별 식단-->
      <div id='mouse_menu'>
         <!--마우스 페이지 이동-->
         <table>
            <tr>
               <caption><b>페이지 이동</b></caption>
            </tr>
            <tr>
               <td><a href="<%=request.getContextPath() %>/index.jsp"><b>HOME</b></a></td>
            </tr>
            <tr>
               <td><a href="<%=request.getContextPath() %>/boardFreeMain"><b>게시판</b></a></td>
            </tr>
            <tr>
               <td><a href="<%=request.getContextPath() %>/diaryMain"><b>마이페이지</b></a></td>
            </tr>
            <tr>
               <td><a href="#none"><b>준비중</b></a></td>
            </tr>
         </table>
      </div>
   </section>
   <script> //천천히 슬라이드
        jQuery(document).ready(function ($) {
            $(".menu").click(function (event) {
                event.preventDefault();
                $('html,body').animate({ scrollTop: $(this.hash).offset().top }, 1000);
            });
        });
    </script>
   <script>//메뉴바 상단 고정
        $(document).ready(function () {
            var jbOffset = $('.menubar').offset();
            $(window).scroll(function () {
                if ($(document).scrollTop() > jbOffset.top) {
                    $('.menubar').addClass('jbFixed');
                }
                else {
                    $('.menubar').removeClass('jbFixed');
                }
            });
        });

    </script>
<%@ include file="/views/common/footer.jsp"%>