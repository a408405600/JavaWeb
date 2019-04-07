<%--
  Created by IntelliJ IDEA.
  User: CK
  Date: 2019/4/7
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    请求URL为:${pageContext.request.requestURL}<br/>
    Content-Type响应头: ${pageContext.response.contentType}<br/>
    服务器信息 ${pageContext.servletContext.serverInfo}<br/>
    Servlet注册名为：${pageContext.servletConfig.servletName}<br/>

    <% pageContext.setAttribute("username","admin"); %>
    <% request.setAttribute("bookName","Java Web"); %>
    <% session.setAttribute("username","admin"); %>
    <% application.setAttribute("bookName","Java 基础");%>

    ${pageScope.username}<br/>
    ${requestScope.bookName}<br/>
    ${sessionScope.username}<br/>
    ${applicationScope.bookName}<br/>






</body>
</html>
