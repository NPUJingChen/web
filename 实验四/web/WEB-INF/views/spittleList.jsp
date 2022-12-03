<%--
  Created by IntelliJ IDEA.
  User: chenjing
  Date: 2022/11/11
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
  <title>吐槽吧</title>
</head>
<body>
<div>
  <input type="button" value="返回" onclick="javascript:window.location.href='/ex5/manager/page?page=managerview'">
  <br/><br/>
</div>
<div>
  <a href="<c:url value="/manager/deletespittle" />">删除吐槽</a><br/><br/>
  <a href="<c:url value="/manager/examine" />">审核吐槽</a><br/><br/>
</div>
<div class="spittleList">
  <table border="1" cellpadding="10">
    <tr>
      <th>ID</th>
      <th>用户名</th>
      <th>内容</th>
      <th>发布时间</th>
      <th>审核状态</th>
      <th>审核人</th>
      <th>审核时间</th>
    </tr>
    <c:forEach items="${spittleList.items}" var="spit">
      <tr>
        <td><c:out value="${spit.id}"/></td>
        <td><c:out value="${spit.spitter.userName}"/></td>
        <td><c:out value="${spit.message}"/></td>
        <td><c:out value="${spit.postedTime}"/></td>
        <td><c:out value="${spit.ischecked}"/></td>
        <td><c:out value="${spit.checker_id}"/></td>
        <td><c:out value="${spit.check_time}"/></td>
        <td><input type="checkbox"><br></td>
      </tr>
    </c:forEach>
  </table>

</div>
每页${spittleList.pageSize}条吐槽，  第${spittleList.currentPageNo}/${spittleList.totalPageCount}页,共${spittleList.totalCount}条吐槽
<c:if test="${spittleList.previousPage}">
  <a href="<c:url value="/manager/check_spittle?pageNo=${spittleList.currentPageNo-1}" />" >上一页</a>
</c:if>
<c:if test="${spittleList.nextPage}">
  <a href="<c:url value="/manager/check_spittle?pageNo=${spittleList.currentPageNo+1}" />" >下一页</a>
</c:if>

</body>
</html>
