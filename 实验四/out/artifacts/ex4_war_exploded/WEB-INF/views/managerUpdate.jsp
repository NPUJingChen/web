<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 18:38
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
<h1>修改信息</h1>
<form method="POST">
  用户名:<input type="text" name="userName" /><br/><br/>
  密码:<input type="password" name="password" /><br/><br/>
  邮箱:<input type="email" name="email" /><br/><br/>
  电话:<input type="text" name="phoneNo" /><br/><br/>
  <input type="submit" value="修改" />
</form>

</body>
</html>
