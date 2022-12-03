<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
  <title>吐槽吧</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>管理员登录</h1>
<form method="POST">
  管理员用户名: <input type="text" name="userName" /><br/><br/>
  　管理员密码: <input type="password" name="password" /><br/><br/>
  <input type="submit" value="登录" />
</form>
</body>
</html>

