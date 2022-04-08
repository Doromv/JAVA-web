<%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/18
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>if测试</h4>
<form action="coreif.jsp" method="get">
    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="login">
</form>
判断如果提交的用户是管理员，则登入成功
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="欢迎您！"/>
</c:if>
<c:out value="${isAdmin}"/>
</body>
</html>
