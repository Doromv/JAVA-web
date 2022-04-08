<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径需要寻找到项目的路径--%>
<%--${pageContext.request.getcontextPath}代表当前的项目--%>
<form action="${pageContext.request.getcontextPath}/login" method="get">
用户名：<input type="text" name="username"><br>
密码： <input type="password" name="password"><br>
    <input type="submit">
</form>
</body>
</html>
