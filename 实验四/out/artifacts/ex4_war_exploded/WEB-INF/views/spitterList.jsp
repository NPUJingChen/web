<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<html>
<head>
    <title>吐槽吧</title>
</head>
<body>
<div>
    <input type="button" value="返回" onclick="javascript:window.location.href='/ex5/manager/page?page=managerview'">
    <br/><br/>
</div>
<div class="spitterList">
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>姓名</th>
            <th>邮箱</th>
        </tr>
        <e:forEach items="${spitterlist.items}" var="spit">
            <tr>
                <td><c:out value="${spit.id}"/></td>
                <td><c:out value="${spit.userName}"/></td>
                <td><c:out value="${spit.firstName} ${spit.lastName}"/></td>
                <td><c:out value="${spit.email}"/></td>
            </tr>
        </e:forEach>
    </table>

</div>
<br/><br/>
<div>
    每页${spitterList.pageSize}位用户，  第${spitterlist.currentPageNo}/${spitterList.totalPageCount}页,共${spitterList.totalCount}位用户
    <c:if test="${spitterList.previousPage}">
        <a href="<c:url value="/manager/check_spitter?pageNo=${spitterList.currentPageNo-1}" />" >上一页</a>
    </c:if>
    <c:if test="${spitterList.nextPage}">
        <a href="<c:url value="/manager/check_spitter?pageNo=${spitterList.currentPageNo+1}" />" >下一页</a>
    </c:if>
</div>

</body>
</html><head>
    <title>Title</title>
</head>
<body>

</body>
</html>
