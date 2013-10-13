<%--
  User: Morn
  Date: 2013-10-12 12:37
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    System.out.println(id);
    switch (id) {
        case 1:
%>
            ShangHai$GuangZhou$BeiJing
<%
            break;
        case 2:
%>
            Washington$NewYork$California
<%
            break;
        case 3:
%>
            Tokyo$Osaka$Fukuoka
<%
            break;
    }
%>
