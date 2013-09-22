<%--
file: index.jsp
desc: Test Jsp
--%>
<html>
<head>
    <title>
        Hello World -- test J2EE
    </title>
</head>
<body>
<%
    for (int i = 1; i < 5; i++) {
%>
<h<%=i%>>Hello Word</h<%=i%>>
<%
    }
%>
</body>
</html>

