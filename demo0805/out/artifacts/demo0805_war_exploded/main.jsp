<%@ page import="java.util.List" %>
<%@ page import="com.qtrer.vo.Dish" %><%--
  Created by IntelliJ IDEA.
  User: Qtrer
  Date: 2021/8/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/mainjs.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
    List<Dish> list = (List<Dish>) request.getAttribute("dishList");
%>
<table align="center" border="1">
    <tr>
        <th>name</th>
        <th>number</th>
        <th>price</th>
        <th>action</th>
    </tr>
    <%
        for (int i=0;i<list.size();i++){
    %>
    <tr>
        <th><%=list.get(i).getName()%></th>
        <th><%=list.get(i).getNumber()%></th>
        <th><%=list.get(i).getPrice()%></th>
        <th><input type="number" class="number" value="0" min="0" max="<%=list.get(i).getNumber()%>" style="width: 80px" disabled/><input type="checkbox" class="count" value=""/></th>
    </tr>
    <%
        }
    %>
    <tr>
        <th colspan="3">sum: <span id="sum" name="sum">0</span></th>
        <th><button><a href="" style="text-decoration: none">submit</a></button></th>
    </tr>
</table>
</body>
</html>
