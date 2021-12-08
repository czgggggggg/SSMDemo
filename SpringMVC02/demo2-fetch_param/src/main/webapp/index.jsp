<%--
  Created by IntelliJ IDEA.
  User: 12102
  Date: 2021/12/8
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>这个jsp不经过SpringMVC，由默认的servlet来处理</h1>
    <h1>通过request来获取请求参数</h1>
    <%--<form action="/param/direct" method="post">--%>
        <%--用户名：<input type="text" name="username"><br>--%>
        <%--密码：<input type="password" name="password"><br>--%>
        <%--年龄：<input type="text" name="age"><br>--%>
        <%--性别：<input type="text" name="gender"><br>--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <%--<form action="/param/javabean" method="post">--%>
        <%--用户名：<input type="text" name="username"><br>--%>
        <%--密码：<input type="password" name="password"><br>--%>
        <%--年龄：<input type="text" name="age"><br>--%>
        <%--婚配：<input type="text" name="married"><br>--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <%--<form action="/param/javabean/nested" method="post">--%>
        <%--用户名：<input type="text" name="username"><br>--%>
        <%--密码：<input type="password" name="password"><br>--%>
        <%--年龄：<input type="text" name="age"><br>--%>
        <%--婚配：<input type="text" name="married"><br>--%>
        <%--电话：<input type="text" name="userDetail.phone"><br>--%>
        <%--邮箱：<input type="text" name="userDetail.email"><br>--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <%--<form action="/param/javabean/nested/array" method="post">--%>
        <%--用户名：<input type="text" name="username"><br>--%>
        <%--密码：<input type="password" name="password"><br>--%>
        <%--年龄：<input type="text" name="age"><br>--%>
        <%--婚配：<input type="text" name="married"><br>--%>
        <%--电话：<input type="text" name="userDetail.phone"><br>--%>
        <%--邮箱：<input type="text" name="userDetail.email"><br>--%>
        <%--爱好：--%>
        <%--<input type="text" name="hobbys">--%>
        <%--<input type="text" name="hobbys">--%>
        <%--<input type="text" name="hobbys"><br>--%>
        <%--<input type="submit">--%>
    <%--</form>--%>

    <form action="/param/javabean/nested/list" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        年龄：<input type="text" name="age"><br>
        婚配：<input type="text" name="married"><br>
        电话：<input type="text" name="userDetail.phone"><br>
        邮箱：<input type="text" name="userDetail.email"><br>
        爱好：
            <input type="text" name="hobbys">
            <input type="text" name="hobbys">
            <input type="text" name="hobbys"><br>
        课程信息：<br>
            课程：<input type="text" name="courses[0].courseName">
            成绩：<input type="text" name="courses[0].score"><br>
            课程：<input type="text" name="courses[1].courseName">
            成绩：<input type="text" name="courses[1].score"><br>
            课程：<input type="text" name="courses[2].courseName">
            成绩：<input type="text" name="courses[2].score"><br>
        <input type="submit">
    </form>
</body>
</html>
