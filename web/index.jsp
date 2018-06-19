<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="views/common/header.jsp"%>
<% if(memberLoggedIn==null) { %>
<%@ include file="views/common/main.jsp" %>
<%} else { %>
<script>
	$(function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/researchCheck",
			type:"get",
			datatype:"json",
			success:function(data){
				if(data>0){
					location.href="<%=request.getContextPath()%>/researchCalendar";
				} else {
					location.href="<%=request.getContextPath()%>/calendarResearch";
				}
			}
		});
	});
</script>
<%} %>
<%@ include file="views/common/footer.jsp"%>