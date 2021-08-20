<%@ page import="com.qtrer.vo.Atm" %><%--
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
</head>
<body>
<div style="width: 100%; height: 50px; background:aqua;">
    <h1>Welcome,<%=((Atm)session.getAttribute("account")).getAccount()%>, Remain: <%=((Atm)session.getAttribute("account")).getRemain()%></h1>
</div>
</body>
</html>
