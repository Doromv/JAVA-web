<%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) request.getAttribute("name2");
    String name3 = (String) session.getAttribute("name3");
    String name4 = (String) application.getAttribute("name4");
%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
</body>
</html>
