<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/1/21
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="anno/testRequestParam?name=haha">RequestParam</a>

    <form action="anno/testRequestBody" method="post">

        用户姓名:<input type="text" name="username" /><br>
        用户年龄:<input type="text" name="age" /><br>
        <input type="submit" value="提交"/>
    </form>

    <a href="anno/testRequestHeader">RequestHeader</a>\
    <br>

    <a href="anno/testCookieValue">testCookieValue</a>
    <br>

    <form action="anno/testModelAttribute" method="post">

        用户姓名:<input type="text" name="username" /><br>
        用户年龄:<input type="text" name="age" /><br>
        <input type="submit" value="提交"/>
    </form>
    <br>

</body>
</html>
