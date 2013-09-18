<%--
  User: Morn
  Date: 13-9-18
  Time: 下午12:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <s:form action="/base/Login3">
        <s:textfield name="username" key="user" />
        <s:textfield name="password" key="pass" />
        <s:submit key="login" />
    </s:form>
</body>
</html>