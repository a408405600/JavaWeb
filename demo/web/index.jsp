<%@ page import="java.util.*" %><%--
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
    <%--<c:out value="${param.username}" escapeXml="false">--%>
      <%--<meta http-equiv="refresh" content="0" url="http://www.itcast.cn" />--%>
    <%--</c:out>--%>
  </head>
  <body>
  <center>
    <h3>欢迎光临</h3>
  </center>
  <br/>
  <br/>
  <c:choose>
    <c:when test="${sessionScope.user ==null}">
      <a href="login.jsp">用户登录</a>
    </c:when>
    <c:otherwise>
      欢迎您，${sessionScope.user.username}!
      <a href="/Logout2Servlet">注销</a>
    </c:otherwise>
  </c:choose>
  <br/>
  欢迎您，现在时间是：
  <%@ include file="date.jsp"%>
  <c:out value="Hello world"> </c:out>
  <br/>

  userName的属性值为：

  <c:out value="${param.username}" default="unknwn"/><br/>
  userName的属性值为：
  <c:out value="${param.username}" >
    unknown
  </c:out><br/>

  <c:set value="1" var="visitCount" property="visitCount" />
  <c:if test="${visitCount == 1}">
    This is you first visit. welcome to the site!
  </c:if><br/>

  <c:choose>
    <c:when test="${empty param.username}">
      unknown user.
    </c:when>
    <c:when test="${param.username == 'admin'}">
      ${param.username} is manager.
    </c:when>
    <c:otherwise>
      ${param.username} is employee
    </c:otherwise>
  </c:choose>
  <hr/>
  <% String[] fruits = {"apple","orange","grape","banana"}; %>
  String数组中的元素:
  <br/>
  <c:forEach var="name" items="<%=fruits%>">
    ${name}<br/>
  </c:forEach>

  <%
    Map userMap = new HashMap();
    userMap.put("Tom",123);
    userMap.put("make",123);
    userMap.put("Lina",123);
  %>
  <hr/>
  HashMap集合中的元素:
  <br/>
  <c:forEach var="entry" items="<%=userMap%>">
    ${entry.key}&nbsp;${entry.value}<br/>
  </c:forEach>

  colorList集合(指定迭代范围和步长)<br/>
  <%
    List colorList = new ArrayList();
    colorList.add("red");
    colorList.add("yellow");
    colorList.add("blue");
    colorList.add("green");
    colorList.add("black");
  %>
  <c:forEach var="color" items="<%=colorList%>" begin="1" end="3" step="2">
    ${color} &nbsp;
  </c:forEach>

  <%
    List userList = new ArrayList();
    userList.add("Tom");
    userList.add("Make");
    userList.add("Lina");
  %>

  <table border="1">
    <tr>
      <td>序号</td>
      <td>索引</td>
      <td>是否为第一个元素</td>
      <td>是否为最后一个元素</td>
      <td>元素的值</td>
    </tr>

    <c:forEach var="name" items="<%=userList%>" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td>${status.index}</td>
        <td>${status.first}</td>
        <td>${status.last}</td>
        <td>${name}</td>
      </tr>
    </c:forEach>
  </table>

  </body>
</html>
