<%@page import="diary.model.vo.Diary"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="diary.model.vo.Diary,diary.model.vo.DietInfo, java.util.*" %>
    <%@ include file="/views/common/header.jsp"%>
    
    <%ArrayList<Diary> list=(ArrayList)request.getAttribute("list"); 
    ArrayList<DietInfo> info=(ArrayList)request.getAttribute("info"); 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Calorie#</title>
<link rel="stylesheet" href="css/bootstrap.css">
    <style>
        table{
            border-collapse: collapse;
            width:700px;
            height: 300px;
            padding: 10px;
            margin: auto;
            text-align: center;
        }
    </style>
</head>
<body>
<form action="" method="post" enctype="multipart/form-data">
<div style="margin:50px">
        <table border="1">
        <%for(DietInfo di:info) { %>
            <tr>
                <td rowspan="4" style="width:400px"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQpYv9A5YF2nIYLnpxgHUXar9p_vYE_UZXyLn0crCLsc8cr45pH"></td>
                <td style="color:white; background-color: pink; width:100px;">ID</td>
                <td ><%=di.getMemberId() %></td>
                
            </tr> 
            <tr>
                <td style="color:white; background-color: pink;">체중</td>
				<td ><%=di.getWeight() %>kg</td>
            </tr>
            <tr>
                <td style="color:white; background-color: pink;">기간</td>
                <td ><%=di.getObjectiveDate() %>일</td>
            </tr>
            <tr>
                <td style="color:white; background-color: pink;">목표체중</td>
				<td ><%=di.getPurposeWeight() %>kg</td>
            </tr>
            <tr>
                <td rowspan="1"><input type="file">
                    <input type="submit" value="업로드"></td>
                <td style="color:white; background-color: pink;">진행경과</td>
                <td style="padding:10px; margin:auto;"><div class="progress">
                        <div class="progress-bar progress-bar-striped bg-warning" role="progressbar" style="width: 50%;" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"></div>
                      </div></td>            
            </tr>   
            <%} %> 
        </table>
        </div>
    </form>
    
    <!-- 일기장부분 -->
	<table>
	<%for(Diary d:list) { %>
	<tr>
	<td><%=d.getDiaryWriter() %>
	</tr>
	<tr>
	<td><%=d.getDiaryContent() %></td>
	</tr>
	<%} %>
	</table>
    
</body>
</html>
<%@ include file="/views/common/footer.jsp"%>