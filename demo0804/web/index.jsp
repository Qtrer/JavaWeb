<%--
  Created by IntelliJ IDEA.
  User: Qtrer
  Date: 2021/8/18
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <table border="1">
    <%
      for (int i=1;i<10;i++){
        out.println("<tr>");
        for (int j=1;j<=i;j++){
          out.println("<td>"+j+"x"+i+"="+i*j+"</td>");
        }
        out.println("</tr>");
      }
    %>
  </table><hr/>
  <table border="1">
    <%
      for (int i=1;i<10;i++){
    %>
    <tr>
    <%
        for (int j=1;j<=i;j++){
    %>
      <td><%=j%>x<%=i%>=<%=i*j%></td>
    <%
        }
    %>
    </tr>
    <%
      }
    %>
  </table>
  </body>
</html>
