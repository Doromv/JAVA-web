<%@ page import="com.doromv.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/19
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
//    People people = new People();
//    people.setAddress();
//    people.setAge();
//    people.setId();
//    people.setName();
%>
<jsp:useBean id="people" class="com.doromv.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="南平"/>
<jsp:setProperty name="people" property="name" value="doromv"/>
<jsp:setProperty name="people" property="age" value="21"/>
<jsp:setProperty name="people" property="id" value="1"/>
<%
<%--<%= people.getAddress()%>--%>
%>
姓名：<jsp:getProperty name="people" property="name" />
id：<jsp:getProperty name="people" property="id"/>
年龄：<jsp:getProperty name="people" property="age" />
地址：<jsp:getProperty name="people" property="address"/>
</body>
</html>
