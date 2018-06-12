<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String loc=request.getContextPath()+"/boardFreeMain";
    %>
<%@include file="/views/common/header.jsp"%>
<style>
        .wr_option {
           border-bottom:1px dotted #e0e0e0;
           padding:1em 0.2em;
        }

        .wr_option h5 {
            display:inline-block;
            width:6.5em;
            *margin:0 0 1em 0;
            margin:0;
            font-size: 9pt !important;
        }

        .wr_option label.bf_file_del {
            width:auto !important;
        }

        #fwrite textarea {height:20em;}

        .wr_subject label,
        .wr_content label {
            margin-bottom:1em;
        }

        .wr_captcha label {
            vertical-align:top;
            margin-top:2.5em;
        }

        /* .wr_option label[for=notice] {margin:0 !important;} */
        .wr_option select ,
        .wr_option input[type=text],
        .wr_option input[type=password] {
            display:inline-block;
            height:30px;
            border: 1px solid lightgray;
            border-radius: 8px
        }
     
        </style>
        <script>
        	function validate() {
        		var content=$("[name=content]").val();
        		if(content.trim().length==0) {
        			alert("내용을 입력하세요!");
        			return false;
        		}
        		return true;
        	}
        </script>
<h1 style="text-align: center"> 게시물 등록 </h1>
        <form action="<%=request.getContextPath() %>/boardWriteEnd" method="post">
    <div style="margin-left: 500px; margin-right: 500px">
        <div class='wr_option'>
        <h5>ID</h5>
            <input type='text' name='writer' value=<%=memberLoggedIn.getMember_id()%> style="border:0px;" readonly>
        </div>
        <div class='wr_option'>
            <h5>이메일</h5>
            <input type='text' name='email' value=<%=memberLoggedIn.getEmail() %> style="border:0px;" readonly>
       
        </div>
        <div class='wr_option'>
            <h5>제목</h5>
            <input type='text' style="width: 500px" maxlength='20' name="title">
        </div>
        <div class='wr_option'>
            <h5>내용</h5>
        </div>
        <div>
            <textarea rows="20" cols="70" style="resize: none;" name="content"></textarea>
        </div>
        <br/>
        <div style="text-align: center">
            <button class="btn btn-default" onclick="return validate();" style="width:80px;">저장</button>
            <input class="btn btn-default" type='reset' onclick="location.href='<%=loc%>'" style="width:80px;" value="취소"><br><br>
        </div>
    </div>
        </form>
<%@ include file="/views/common/footer.jsp"%>