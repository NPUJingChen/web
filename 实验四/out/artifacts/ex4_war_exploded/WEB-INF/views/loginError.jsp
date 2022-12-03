<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
  <title>吐槽吧</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>登录有误，请重新尝试</h1>
<a href="<c:url value="/login" />">登录</a> |
<a href="<c:url value="/spitter/register" />">注册</a>
<a href="<c:url value="/manager/login" />">管理员登录</a>
</body>
</html>
