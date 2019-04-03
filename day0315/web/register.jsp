<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/14
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新用户</title>
</head>
<body>
<span>${error}</span>
<form action="reg" method="post">

    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    性别：<input type="radio" name="sex" value="男" checked>男&nbsp;&nbsp;
          <input type="radio" name="sex" value="女">女<br/>
    年龄:<input type="text" name="age" value="24"/><br/>
    个人爱好:
    <input type="checkbox" name="hobbys" value="足球"/>足球&nbsp;&nbsp;
    <input type="checkbox" name="hobbys" value="篮球"/>篮球&nbsp;&nbsp;
    <input type="checkbox" name="hobbys" value="购物"/>购物&nbsp;&nbsp;
    <input type="checkbox" name="hobbys" value="看电影"/>看电影<br/>

    <input type="submit" value="注册">

</form>
</body>
</html>
