<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク管理アプリ</title>
</head>
<body>
<h1>ログイン</h1>
<form action="${pageContext.request.contextPath}/Login" method="post">
ID：<input type="text"name="id"><br>
パスワード：<input type="password"name="pass"><br>
<input type="submit"value="ログイン">
</form>
</body>
</html>