<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="board.model.vo.BoardFree, java.util.*, board.model.vo.BoardFreeComment" %>
<%@include file="/views/common/header.jsp"%>
<%
    	BoardFree b=(BoardFree)request.getAttribute("boardList");
    	String loc=request.getContextPath()+"/boardFreeMain";
    	List<BoardFreeComment> list=(List)request.getAttribute("comment");

    %>
    <style>
    	th{
    		text-align:center;

    	}
div#board-container {
	width: 600px;
	margin: 0 auto;
	text-align: center;
}

div#board-container h2 {
	margin: 10px 0;
}

table#tbl-board {
	width: 500px;
	margin: 0 auto;
	border: 1px solid black;
	border-collapse: collapse;
	clear: both;
}

table#tbl-board th {
	width: 125px;
	border: 1px solid;
	padding: 5px 0;
	text-align: center;
}

table#tbl-board td {
	border: 1px solid;
	padding: 5px 0 5px 10px;
	text-align: left;
}
 table#tbl-comment{width:500px;  border-collapse:collapse; clear:both; } 
    table#tbl-comment tr td{border-bottom:1px solid lightgray; padding:5px; text-align:left; line-height:120%;}
    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
    table#tbl-comment button.btn-reply{display:none;}
    table#tbl-comment tr:hover {background:lightgray;}
    table#tbl-comment tr:hover button.btn-reply{display:inline;}
    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
    </style>
    
	<div class="container" style="margin:50px auto">
    <table class="table table-hover" style="width:800px; margin:0 auto;">
    <tbody>
    <tr>
        <th>글번호</th>
        <td><%= b.getFb_num() %></td>
        <th>조회수</th>
        <td><%= b.getFb_count() %></td>
    </tr>
       
     
    <tr>
        <th>작성자</th>
        <td><%= b.getFb_id() %></td>
        <th>작성일</th>
        <td><%= b.getFb_date() %></td>
    </tr>
     
   
     
    <tr>
        <th>제목</th>
        <td colspan="3"><%= b.getFb_title() %></td>
    </tr>
     
    <tr>
        <th>글 내용</th>
        <td colspan="3"><%=b.getFb_content() %></td>
    </tr>
			</tbody>
		</table><br/>
		<table style="margin:0 auto;">
 			<tr>
				<td colspan='2'>
				<button class="btn btn-info pull-right" onclick="location.href='<%=loc%>'" style="width:80px; margin:5px;">목록으로</button>
			<%if(memberLoggedIn!=null) {
			if(b.getFb_id().equals(memberLoggedIn.getMember_id())||"admin".equals(memberLoggedIn.getMember_id())) { %>
 				<button class="btn btn-default pull-right" onclick="fn_updateBoard()" style="width:80px; margin:5px;">수정하기</button>
				<button class="btn btn-default pull-right" onclick="fn_deleteBoard()" style="width:80px; margin:5px;">삭제하기</button>
 				<%} } %> 
 				</td>				
			</tr>
		</table><br/>
		<script>
				function fn_updateBoard() {
					location.href="<%=request.getContextPath()%>/boardFreeUpdate?no=<%=b.getFb_num()%>";
				}
				function fn_deleteBoard() {
					location.href="<%=request.getContextPath()%>/boardFreeDelete?no=<%=b.getFb_num()%>";
				}
			</script>
		
 	<div style='margin-left:500px;'>
			<script>
				$(function() {
					$("[name=boardCommentContent]").click(function(e) {
						if(<%=memberLoggedIn==null%>) {
							fn_loginAlert();
							e.preventDefault();
							$("[name=boardCommentContent]").attr("readonly",'readonly');
							return;
						};
					});
				});
				$("[name=boardCommentFrm]").submit(function(e) {
					if(<%=memberLoggedIn==null%>) {
						fn_loginAlert();
						e.preventDefault();
						return;
					}
					var len=$("texarea[name=boardComment]").val().trim().length;
					if(len==0) {
						e.preventDefault();
					}
				});
				
				function fn_loginAlert() {
					alert("로그인 후 이용할 수 있습니다.");
					$("#userId").focus();
				};
			</script>
			<table id="tbl-comment">
    <%
    if(list != null){
        for(BoardFreeComment bc : list){
        	if(bc.getCommentLev()==1) {%>
        
    <tr class='level1'>
        <td width='450'>
            <sub class=comment-writer><%=bc.getFreeBoardWrite() %></sub>
            <sub class=comment-date><%=bc.getCommentDate()%></sub>
	    <br />
            <%=bc.getCommentContent() %>
	</td>
        <td>
            <button class="btn btn-success btn-xs" value="<%=bc.getCommentNum()%>">&nbsp답글</button>
            <%if(memberLoggedIn!=null) {
			if(b.getFb_id().equals(memberLoggedIn.getMember_id())||"admin".equals(memberLoggedIn.getMember_id())) { %>
            <button id='delCo' class="btn btn-xs" value="<%=bc.getCommentNum()%>" onclick='fn_deleteComment()'>&nbsp삭제</button>
            <%} } %>
        </td>
        	<script>
        	var delCo=$("#delCo").val();
			function fn_deleteComment() {
				location.href="<%=request.getContextPath()%>/boardFreeDeleteComment?commentNo="+delCo+"&boNum="+<%=b.getFb_num()%>;
				
			}
			</script>
  <% } 
    else { %>
  		<tr class='level2'>
  		<td>
  		<sub><%=bc.getFreeBoardWrite() %></sub>
  		<sub><%=bc.getCommentDate() %></sub>
  		<br>
  			<%=bc.getCommentContent() %>
  			</td>
  			<td></td>
  			</tr>
 <%  } } }%>
        <script>
        	$(".btn-success").on('click',function(e) {
        		<% if(memberLoggedIn != null) { %>
        		var tr=$("<tr></tr>");
        		var html="<td style='display:none; text-align:left;' colspan=2>";
        		html+='<form action="<%=request.getContextPath()%>/boardFreeCommentInsert" method="post">';
        		html+="<input type='hidden' name='boardRef' value='<%=b.getFb_num()%>'/>";
        		html+="<input type='hidden' name='boardCommentWriter' value='<%=memberLoggedIn.getMember_id() %>'/>";
        		html+="<input type='hidden' name='boardCommentLevel' value='2'/>";
        		html+="<input type='hidden' name='boardCommentRef' value='"+$(this).val()+"'/>";
        		html+="<textarea name='boardCommentContent' cols='53' rows='2'></textarea>";
        		html+="<button type='submit' class='btn btn-success btn-xs'>등록</button>";
        		html+="</form></td>"
        		//위에서 작성한 html 구문을 tr변수 text 노드에 삽입
        		tr.html(html);
        		//작성된 tr태그(객체)를 원본 html구문의 (tr class=level1) 뒤에 삽입
        		tr.insertAfter($(this).parent().parent()).children("td").slideDown(800);
        		//이벤트가 1회만 발생하게 제한
        		$(this).off('click');
        		//답글 달고 버튼 누르면 해당 서블릿에 데이터 전송
        		tr.find('form').submit(function(e) {
        			if(<%=memberLoggedIn==null %>) {
        				fn_loginAlert();
        				e.preventDefault();
        			}
        			var len=$(this).children('textarea').val().trim().length;
        			if(len==0) {
        				e.preventDefault();
        			}
        		});
        		tr.find('textarea').focus;
        	<% } %>
        	}); 
        </script>
    </tr>
    </table><br/>
			<form name='boardCommentFrm' action="<%=request.getContextPath() %>/boardFreeCommentInsert" method='post'
			style='margin-left:15px;'>
				<input type='hidden' name='boardRef' value='<%=b.getFb_num()%>'/>
				<input type='hidden' name='boardCommentWriter' value='<%=memberLoggedIn!=null ? memberLoggedIn.getMember_id() : ""%>'/>
				<input type='hidden' name='boardCommentLevel' value='1'/>
				<input type='hidden' name='boardCommentRef' value='0' />
				<textarea name='boardCommentContent' cols='60' rows='3'></textarea>&nbsp
				<button class='btn btn-warning' type='submit'>등록</button>
			</form>
	</div>
		</div>
<%@ include file="/views/common/footer.jsp"%>