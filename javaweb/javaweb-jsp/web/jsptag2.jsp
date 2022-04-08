<%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/18
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>jsptag2</h1>
<%
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    out.print("姓名为："+name+"<br>"+"年龄为："+age);
%>
</body>
</html>
