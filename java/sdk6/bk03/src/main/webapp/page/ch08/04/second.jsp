<%--
  User: Morn
  Date: 2013-10-12 12:37
--%>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
//    response.getWriter().println("<citylist>");
    out.println("<citylist>");
    switch (id) {
        case 1:
%>
            <city>ShangHai</city>
            <city>GuangZhou</city>
            <city>BeiJing</city>
<%
            break;
        case 2:
%>
            <city>Washington</city>
            <city>NewYork</city>
            <city>California</city>
            <city>Florida</city>
<%
            break;
        case 3:
%>
            <city>Tokyo</city>
            <city>Osaka</city>
            <city>Fukuoka</city>
<%
            break;
    }
%>
</citylist>