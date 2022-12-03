<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>吐槽吧</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
  </head>
  <body>
    <div class="spittleForm">
      <h1>吐个槽...</h1> 
      <form method="POST" name="spittleForm">
        <textarea name="message" cols="80" rows="5"></textarea><br/><br/>
        <input type="submit" value="吐..." />
      </form>
    </div>
    <a href="<c:url value="/" />">返回首页</a>
    <div class="spittleList">
      <h1>最近吐槽</h1>
      <ul class="spittleList">
        <c:forEach items="${spittleList}" var="spittle" >
          <li id="spittle_<c:out value="${spittle.id}"/>">
            <div class="spittleMessage"><c:out value="${spittle.message}" /></div>
            <div class="spittleTime">
              <fmt:formatDate value="${spittle.postedTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
              by <c:out value="${spittle.spitter.userName }" />
            </div>
          </li>
        </c:forEach>
      </ul>
      </div>
  </body>
</html>