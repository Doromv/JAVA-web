<%--
  Created by IntelliJ IDEA.
  User: DoromvQAQ
  Date: 2022/1/16
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登入</title>
</head>
<body>
<h1>登入</h1>
<div style="text-align: center">
    <form action="${pageContext.request.contextPath}/login" method="post">
       用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobbies" value="代码">代码
        <input type="checkbox" name="hobbies" value="唱歌">唱歌
        <input type="checkbox" name="hobbies" value="电影">电影
        <input type="checkbox" name="hobbies" value="游戏">游戏 <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
