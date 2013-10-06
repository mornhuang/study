<%--
  User: Morn
  Date: 13-9-18
  Time: 下午12:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Login Page3</title>
</head>

<!-- html 注释 -->
<body>
    <!-- struts 测试 -->
    <s:form action="Login3" namespace="/three">
        <s:textfield name="username" key="user" />
        <s:textfield name="password" key="pass" />
        <s:submit key="login" />
        <s:submit key="regist" method="regist" />
    </s:form>

</body>
</html>