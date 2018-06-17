<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
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
</style>

<div class="research">
	<div class="progress">
	    <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>
	</div>
  <form id="regiration_form" action="<%=request.getContextPath()%>/research" method="post" onsubmit="return fn_enroll()">
	  <fieldset class="form-research">
	    <h2>Step 1: 현재 키와 체중</h2>
	    <div class="form-group">
		    <label for="height">현재 키를 입력해 주세요</label>
		    <input type="number" class="form-control" id="height" name="height" placeholder="키">
	    </div>
	    <div class="form-group">
		   <label for="weight">현재 체중를 입력해 주세요</label>
		   <input type="number" class="form-control" id="weight" name="weight" placeholder="몸무계">
	    </div>
	    <div class="form-group">
		   <label for="gender">성별을 입력해 주세요</label>
	       <input type="radio" name="gender" id="gender0" value="M" checked>
	       <label for="gender0">남</label>
	       <input type="radio" name="gender" id="gender1" value="F">
	       <label for="gender1">여</label>
	    </div>
	    <input type="button" name="next" class="next btn btn-info" onclick="next1()" value="Next" />
	  </fieldset>
	  <fieldset class="form-research">
	    <h2> Step 2: 목표하시는 체중</h2>
	    <div class="form-group">
	    	<label for="purposeWeight">목표로 하시는 체중을 입력해주세요</label>
	    	<input type="number" class="form-control" name="purposeWeight" id="purposeWeight" placeholder="목표체중">
	    </div>
	    <input type="button" name="previous" class="previous btn btn-default" value="Previous" />
	    <input type="button" name="next" class="next btn btn-info" onclick="next2()" value="Next" />
	  </fieldset>
	  <fieldset class="form-research">
	    <h2>Step 3: 목표기간</h2>
	    <div class="form-group">
		    <label for="datepicker">목표기간</label>
		    <input type="text" class="form-control" id="datepicker" name="objectiveDate" placeholder="클릭해주세요.">
	    </div>
	    <input type="button" name="previous" class="previous btn btn-default" value="Previous" />
	    <input type="submit" name="submit" class="submit btn btn-success" value="Submit" />
	  </fieldset>
  </form>
</div>
<script>
	
	$(document).ready(function(){//다음버튼 이전 버튼
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
	
	$(document).ready(function(){//달력
		var today = new Date();
		var $datepicker = $("#datepicker");
		$datepicker.datepicker({
			dateFormat:"yy-mm-dd",
			minDate:10,
		    showOtherMonths: true,
		    selectOtherMonths: true,
	        changeMonth: true, 
	        changeYear: true,
	        nextText: '다음 달',
	        prevText: '이전 달',
		    showOn: "button",
		    buttonText: "Select date",
			onClose: function(){
				var toDate = $datepicker.datepicker('getDate');
			}
		});
	});

	function next1(){
		var height = $("#height");
		var weight = $("#weight");
		if(height.val().length==0){
			alert("키를 입력해 주세요");
			height.focus();
			return false;
		} else {
			if(weight.val().length==0){
				alert("체중을 입력해 주세요");
				weight.focus();
				return false;
			}
		}
		return true;
	}
	
	function next2(){
		var weight = $("#purposeWeight");
		if(weight.val().length==0){
			alert("목표체중을 입력해주세요");
			weight.focus();
			return false;
		}
		return true;
	}
	
	function fn_enroll(){
		var datepicker = $("#datepicker");
		if(datepicker.val().length<7){
			alert("날짜를 입력해 주십시오");
			datepicker.focus();
			return false;
		}
		return true;
	}
</script>
<%@ include file="/views/common/footer.jsp"%>