<%--
  User: Morn
  Date: 13-9-20
  Time: 下午5:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page info="This is JSP Base Study" %>

<html>
<head>
    <title>JSP 基本页面</title>
</head>

<%!
    // Declare an integer variable
    public int count;

    // Declare a method
    public String info() {
        return "hello";
    }
%>

<body>
<!-- jsp declare j2ee -->
    <%
        out.println(count++);
    %>
<br/>
    <%
        out.println(info());
    %>
<br/>
    <%=count++%><br/>
    <%out.println(new java.util.Date());%>

<!-- jsp script j2ee -->
<table>
    <%
        for (int i = 0; i < 10; i++) {
    %>
    <tr>
        <td>循环值:</td>
        <td><%=i%>
        </td>
    </tr>
    <%
        }
    %>
</table>

<!-- jsp page indicator j2ee>
    <%=getServletInfo()%><br/>


</body>
</html>