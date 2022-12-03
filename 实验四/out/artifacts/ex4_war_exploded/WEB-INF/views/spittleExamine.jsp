<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
  <title>吐槽吧</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>审核吐槽</h1>
<form method="POST">
  ID:<input type="text" name="id" /><br/><br/>
  <input type="submit" value="审核" />
</form>
</body>
</html>
