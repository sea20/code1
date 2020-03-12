<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2020/3/12
  Time: 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form method="post" action="/sea/login">
    学号:<input type="text" name="id" placeholder="请输入学号"><br>
    密码:<input type="text" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
    <div>
        <%=request.getSession().getAttribute("loginError")==null ? "":request.getSession().getAttribute("loginError")%><br>
    </div>
    <% request.getSession().removeAttribute("loginError");%>
</form>
</body>
</html>
