<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        window.onload = function () {
            var link = document.getElementById("link");
            var image = document.getElementById("code");
            link.onclick = function () {
                var time = new Date().getTime();
                image.src="/sea/code"+time;
            }
        }
    </script>
</head>
<body>
<img id="code" src="/sea/code"/>
<a id="link" href="">换一个</a>
</body>
</html>