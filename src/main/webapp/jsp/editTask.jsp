<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.Task" %>
<%
String task = request.getParameter("task");
String priority = request.getParameter("priority");
String limit = request.getParameter("limit");
int taskId = Integer.parseInt(request.getParameter("taskId"));
int delFlg = Integer.parseInt(request.getParameter("delFlg"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスクの編集</title>
</head>
<body>
<h1>タスク編集</h1>
<form action="${pageContext.request.contextPath}/TaskEdit" method="POST">
	<label> タスク:</label>
	<input type="text" name="task"size ="50" value="<%= task%>"><br>
	<label> 優先度:</label>
	<select name="priority">
	  <option value="高">高</option>
	  <option value="中">中</option>
	  <option value="低">低</option>
	</select><br>
	<label> 期限:</label>
	<input type="date" name="limit" value="<%= limit%>"><br>
	<input type="hidden" name="taskId" value="<%= taskId %>">
	<input type="hidden" name="delFlg" value="<%= delFlg %>">
	<input type="submit" value="更新">
</form>
<button onclick="location.href='${pageContext.request.contextPath}/jsp/main.jsp'">戻る</button>
</body>
</html>