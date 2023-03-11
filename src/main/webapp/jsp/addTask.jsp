<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスクの追加</title>
</head>
<body>
<h1>タスクの追加</h1>
<form action="${pageContext.request.contextPath}/TaskMain" method="post">
タスク：<input type="text"name="task"size ="50"><br>
期限：<input type="date"name="limit"value="2000-01-01"><br>
優先度:
<select name="priority">
  <option value="高">高</option>
  <option value="中">中</option>
  <option value="低">低</option>
</select><br>
<input type="submit"value="追加">
</form>
<button onclick="location.href='${pageContext.request.contextPath}/jsp/main.jsp'">戻る</button>
</body>
</html>
<!--  -->