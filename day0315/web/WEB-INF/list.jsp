
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/14
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
注册用户列表：<br/>
<table border="1px">
    <thead>
    <tr><th>用户名</th><th>密码</th><th>性别</th><th>年龄</th><th>个人爱好</th></tr>
    </thead>
    <tbody>


<%
    List<User> lstUsers= (List<User>) request.getAttribute("lstUsers");
    for(User user:lstUsers)
    {
%>
    <tr>
        <td><%=user.getUsername()%></td>
        <td><%=user.getPassword()%></td>
        <td><%=user.getSex()%></td>
        <td><%=user.getAge()%></td>
        <td><%=Arrays.toString(user.getHobbys())%></td>

    </tr>
<%
    }
%>
    </tbody>
</table>
</body>
</html>
