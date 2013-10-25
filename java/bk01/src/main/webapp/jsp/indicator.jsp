<%--
  User: Morn
  Date: 13-9-20
  Time: 下午3:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indicator JSP</title>
</head>
<body>
    <%=request.getParameter("age")%>
    <jsp:include page="index.jsp"/>
</body>
</html>