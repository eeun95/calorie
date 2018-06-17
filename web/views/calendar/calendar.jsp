<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link href='<%=request.getContextPath()%>/css/fullcalendar.min.css' rel='stylesheet' />
<link href='<%=request.getContextPath()%>/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='<%=request.getContextPath()%>/js/moment.min.js'></script>
<script src='<%=request.getContextPath()%>/js/jquery.min.js'></script>
<script src='<%=request.getContextPath()%>/js/fullcalendar.min.js'></script>
<script src='<%=request.getContextPath()%>/js/locale-all.js'></script>

<link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' rel='stylesheet' />
<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'></script>

<script>

	$(document).ready(function(){
		$('#calendar').fullCalendar({
			locale:"ko",
			editable:false,
			eventLimit:true,
		    header: {
		        left: 'prevYear,prev,today,next,nextYear',
		        center: 'title',
		        right: 'month,agendaWeek,agendaDay'
		    },
		    eventRender: function(eventObj, $el) {
		    	$el.popover({
		    		title:eventObj.title,
		    		content:eventObj.description,
		    		trigger:'hover',
		    		placement:'right',
		    		container:'body'
		    	});
		    },
		    events:"<%=request.getContextPath()%>/calendar"
		    	
		    	/* [
		    	{
		    		title:'birthday',
		    		description:'birthday',
		    		start:'2018-06-10'
		    	},
		    	{
		    		title:'권성준',
		    		description:'성준',
		    		start:'2018-06-10'
		    	},
		    	{
		    		title:'성준',
		    		description:'권성준',
		    		start:'2018-06-11'
		    	}]*/
		});
	});
</script>
<style>
	body {
	    margin: 40px 10px;
	    padding: 0;
	    font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	    font-size: 14px;
	}
	#calendar {
	    max-width: 900px;
	    margin: 0 auto;
	}
    .fc-sat { color:#0000FF; }     /* 토요일 */
    .fc-sun { color:#FF0000; }    /* 일요일 */

</style>
<br>
<div id='calendar'></div>
<%@ include file="/views/common/footer.jsp"%>