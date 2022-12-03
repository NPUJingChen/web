<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>
<html>
<head>
    <title>吐槽吧</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <h1>删除管理员</h1>
    <form method="post">
        用户名:<input type="text" name="userName">
        <br>
        <br>
        <input type="submit" value="删除">
    </form>
</body>
</html>
