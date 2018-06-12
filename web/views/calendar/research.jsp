<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<style>
  .research{
  	width:80%;
  	margin:0 auto;
  }
  #regiration_form fieldset:not(:first-of-type) {
    display: none;
  }
  .progress-bar{
 	background-color: #00d000;
  }
  .form-research{
  	width:30%;
  	margin:0 auto;
  }
  .previous{
  	float: left;
  }
  .next, .submit{
  	float: right;
  }
  .ui-datepicker {
	background: #333;
	border: 1px solid #555;
	color: #EEE;
	font-size:20px;
   }
</style>

<div class="research">
	<div class="progress">
	    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
	</div>
  <div class="alert alert-success hide"></div>
  <form id="regiration_form" action="<%=request.getContextPath()%>/Calendar" method="post" novalidate>
	  <fieldset class="form-research">
	    <h2>Step 1: 현재 키와 몸무계</h2>
	    <div class="form-group">
		    <label for="height">현재 키를 입력해 주세요</label>
		    <input type="number" class="form-control" id="height" name="height" placeholder="키">
	    </div>
	    <div class="form-group">
		   <label for="weight">현재 몸무계를 입력해 주세요</label>
		   <input type="number" class="form-control" id="weight" name="weight" placeholder="몸무계">
	    </div>
	    <div class="form-group">
		   <label for="gender">성별을 입력해 주세요</label>
	       <input type="radio" name="gender" id="gender0" value="M" checked>
	       <label for="gender0">남</label>
	       <input type="radio" name="gender" id="gender1" value="F">
	       <label for="gender1">여</label>
	    </div>
	    <input type="button" name="next" class="next btn btn-info" value="Next" />
	  </fieldset>
	  <fieldset class="form-research">
	    <h2> Step 2: 목표하시는 체중</h2>
	    <div class="form-group">
	    	<label for="target_weight">목표로 하시는 체중을 입력해주세요</label>
	    	<input type="number" class="form-control" name="target_weight" id="target_weight" placeholder="목표체중">
	    </div>
	    <input type="button" name="previous" class="previous btn btn-default" value="Previous" />
	    <input type="button" name="next" class="next btn btn-info" value="Next" />
	  </fieldset>
	  <fieldset class="form-research">
	    <h2>Step 3: 목표기간</h2>
	    <div class="form-group">
		    <label for="datepicker">목표기간</label>
		    <input type="text" class="form-control" id="datepicker" placeholder="클릭해주세요.">
			<p>No. of days:<input type="text" id="days-count"></p>
	    </div>
	    <input type="button" name="previous" class="previous btn btn-default" value="Previous" />
	    <input type="submit" name="submit" class="submit btn btn-success" value="Submit" />
	  </fieldset>
  </form>
</div>
<script>
	$(document).ready(function(){
		  var current = 1,current_step,next_step,steps;
		  steps = $("fieldset").length;
		  $(".next").click(function(){
		    current_step = $(this).parent();
		    next_step = $(this).parent().next();
		    next_step.show();
		    current_step.hide();
		    setProgressBar(++current);
		  });
		  $(".previous").click(function(){
		    current_step = $(this).parent();
		    next_step = $(this).parent().prev();
		    next_step.show();
		    current_step.hide();
		    setProgressBar(--current);
		  });
		  setProgressBar(current);
		  // Change progress bar action
		  function setProgressBar(curStep){
		    var percent = parseFloat(100 / steps) * curStep;
		    percent = percent.toFixed();
		    $(".progress-bar")
		      .css("width",percent+"%")
		      .html(percent+"%");   
		  }
		});
	$( "#regiration_form" ).submit(function(event) {
	    jQuery('.alert-success').removeClass('hide').html( "Handler for .submit() called and see console logs for your posted variable" );
	    console.log($(this).serialize());
	    event.preventDefault();
	  });
	
	$(document).ready(function(){
		var today = new Date();
		var $datepicker = $("#datepicker");
		$datepicker.datepicker({
			dateFormat:"yy-mm-dd",
			minDate:10,
			onClose: function(){
				var toDate = $datepicker.datepicker('getDate');
				var diff = new Date(toDate - today);
				var days = diff/1000/60/60/24;

	            document.getElementById("days-count").value = '' + days;
			}
		});
	});
</script>
<%@ include file="/views/common/footer.jsp"%>