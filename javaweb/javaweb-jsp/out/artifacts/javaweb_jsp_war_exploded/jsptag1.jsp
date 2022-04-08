<%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/18
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="jsptag2.jsp">
    <jsp:param name="name" value="doromv"/>
    <jsp:param name="age" value="21"/>
</jsp:forward>
<h1>jsptag1</h1>
</body>
</html>
