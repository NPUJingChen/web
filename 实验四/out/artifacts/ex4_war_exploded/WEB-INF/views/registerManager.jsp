<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
  <title>吐槽吧</title>
  <link rel="stylesheet" type="text/css"
        href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>添加管理员</h1>

<sf:form method="POST" commandName="manager">
  <sf:errors path="*" cssClass="error"/><br/><br/>

  姓名：<sf:input path="fullName" /><sf:errors path="fullName" cssClass="error"/><br/><br/>
  电话号码：<sf:input path="phoneNo" /><sf:errors path="phoneNo" cssClass="error"/><br/><br/>
  邮箱：<sf:input path="email" /><sf:errors path="email" cssClass="error"/>  <br/><br/>
  用户名：<sf:input path="userName" /><sf:errors path="userName" cssClass="error"/><br/><br/>
  密码：<sf:password  path="password" /><sf:errors path="password" cssClass="error"/><br/><br/>
  <input type="submit" value="添加" />
</sf:form>
</body>
</html>
