<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
  <title>吐槽吧</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>管理员信息</h1>
用户名：<c:out value="${manager.userName}" /><br/><br/>
　姓名：<c:out value="${manager.fullName}" /><br/><br/>
　邮箱：<c:out value="${manager.email}" /><br/><br/>
手机号：<c:out value="${manager.phoneNo}" /> <br/><br/>

<a href="<c:url value="/manager/update" />">修改个人信息</a><br/><br/>
<a href="<c:url value="/manager/check_manager" />">查看Manager列表</a><br/><br/>
<a href="<c:url value="/manager/check_spitter" />">查看Spitter列表</a><br/><br/>
<a href="<c:url value="/manager/check_spittle" />">查看Spittle列表</a><br/><br/>

</body>
</html>
