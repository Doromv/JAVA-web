<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%--
get:上传文件大小有限制
post:上传文件大小没限制
--%>
<form action="${pageContext.request.contextPath}/upload.do" method="post">
    上传用户: <input type="text" name="username"><br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file1"></p>
    <p><input type="submit"> | <input type="reset"></p>
</form>
</body>
</html>
