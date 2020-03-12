<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script>
        window.onload = function () {
            var image = document.getElementById("code");
            image.onclick = function () {
                var time = new Date().getTime();
                this.src="/sea/code?"+time;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="/sea/regist" method="post">
    学号：<input  name="id" type="text" placeholder="请输入账号" >
    <br>
    名字 :<input name="name" type="text" placeholder="请输入名字"><br>
    密码 :<input name="password" type="password" placeholder="请输入密码"><br>
    验证码 :<input name="code" placeholder="请输入验证码" >
    <img id="code" src="/sea/code"/>
    看不清请点击图片更换<br>
    <input type="submit" value="注册">
    <div>
        <%=request.getSession().getAttribute("idError")==null ? "":request.getSession().getAttribute("idError")%><br>
        <%= request.getSession().getAttribute("codeError")==null ? "":request.getSession().getAttribute("codeError") %>
    </div>
    <% request.getSession().removeAttribute("idError");%>
    <% request.getSession().removeAttribute("codeError");%>
</form>
</body>
</html>