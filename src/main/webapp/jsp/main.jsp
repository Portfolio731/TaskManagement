<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="model.Task,java.util.List" %>
<%
List<Task> taskList = (List<Task>)session.getAttribute("TaskList");
String priority = (String)session.getAttribute("priority");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧</title>
</head>
<body>
	<h1>タスク一覧</h1>
	<button onclick="location.href='${pageContext.request.contextPath}/jsp/addTask.jsp'">タスクを追加</button><br>	
	<% if(taskList !=null){ %>
	<table border="1">
		<thead>
			<tr>
				<th>タスク</th>
				<th>優先度</th>
				<th>期日</th>
			</tr>
		</thead>
		<tbody>	
		<% for(int i=0;i<taskList.size();i++){%>
			<% if(taskList.get(i).getDelFlg()==0){%>
			<tr>
				<td><%= taskList.get(i).getTask()%></td>
				<td><%= taskList.get(i).getPriority()%></td>
				<td><%= taskList.get(i).getLimit()%></td>
				<td>
				<form action="${pageContext.request.contextPath}/jsp/editTask.jsp" method="GET">
					<input type="hidden" name="task" value="<%= taskList.get(i).getTask()%>">
					<input type="hidden" name="priority" value="<%= taskList.get(i).getPriority()%>">
					<input type="hidden" name="limit" value="<%= taskList.get(i).getLimit()%>">
					<input type="hidden" name="taskId" value="<%= taskList.get(i).getTaskId()%>">
					<input type="hidden" name="delFlg" value="<%= taskList.get(i).getDelFlg()%>">
					<input type="submit" value="編集">
				</form>
				</td>
				<td>
				<form action="${pageContext.request.contextPath}/TaskComp" method="post">
					<input type="hidden" name="taskId" value="<%= taskList.get(i).getTaskId()%>">
					<input type="submit" value="完了">
				</form>
				</td>
			</tr>
			<% } %>
		<% } %>			
		</tbody>
	</table>
	<% } %>
</body>
</html>