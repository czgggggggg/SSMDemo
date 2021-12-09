<%--
  Created by IntelliJ IDEA.
  User: 12102
  Date: 2021/12/9
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>文件上传</h1>
    <form action="file/upload" enctype="multipart/form-data" method="post">
        <input type="file" name="myfile"><br>
        <input type="submit">
    </form>
</body>
</html>
