<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true" %>
<html>
<head>
    <title>吐槽吧</title>
</head>
<body>
<div>
    <input type="button" value="返回" onclick="javascript:window.history.go(-1);">
    <br/><br/>
</div>

<div>
    <a href="<c:url value="/manager/add" />">增加管理员</a><br/><br/>
    <a href="<c:url value="/manager/delete" />">删除管理员</a><br/><br/>
</div>

<div class="managerList">
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>状态</th>
        </tr>
        <c:forEach items="${managerList.items}" var="manager">
            <tr>
                <td><c:out value="${manager.id}"/></td>
                <td><c:out value="${manager.userName}"/></td>
                <td><c:out value="${manager.fullName}"/></td>
                <td><c:out value="${manager.email}"/></td>
                <td><c:out value="${manager.phoneNo}"/></td>
                <td><c:out value="${manager.isDelete}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>
<br/><br/>


<div>
    每页${managerList.pageSize}位用户，  第${managerList.currentPageNo}/${managerList.totalPageCount}页,共${managerList.totalCount}位用户
    <c:if test="${managerList.previousPage}">
        <a href="<c:url value="/manager/check_manager?pageNo=${managerList.currentPageNo-1}" />" >上一页</a>
    </c:if>
    <c:if test="${managerlist.nextPage}">
        <a href="<c:url value="/manager/check_manager?pageNo=${managerList.currentPageNo+1}" />" >下一页</a>
    </c:if>
</div>

</body>
</html>
