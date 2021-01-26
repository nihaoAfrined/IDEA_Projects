<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/1/20
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--请求参数绑定
    request
    <a href="param/testParam?username=hehe">请求参数绑定</a>
    --%>
<%--    把数据封装到Account类中--%>
<%--    <form action="param/saveAccount" method="post">--%>
<%--        姓名:<input type="text" name="name" /><br>--%>
<%--        密码:<input type="text" name="password" /><br>--%>
<%--        金额:<input type="text" name="money" /><br>--%>
<%--        用户姓名:<input type="text" name="user.username" /><br>--%>
<%--        用户年龄:<input type="text" name="user.age" /><br>--%>
<%--        <input type="submit" value="提交"/>--%>
<%--    </form>--%>

<%--        把数据封装在Account类中，类中存在list和map集合--%>

    <%-- 自定义类型转换器 --%>
        <form action="param/saveUser" method="post">

            用户姓名:<input type="text" name="username" /><br>
            用户年龄:<input type="text" name="age" /><br>
            用户生日:<input type="text" name="date" /><br>
            <input type="submit" value="提交"/>
        </form>
</body>
</html>
