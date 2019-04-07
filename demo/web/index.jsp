<%--
  Created by IntelliJ IDEA.
  User: CK
  Date: 2019/4/1
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  欢迎您，现在时间是：
  <%@ include file="date.jsp"%>
  <c:out value="Hello world"> </c:out>


  </body>
</html>
