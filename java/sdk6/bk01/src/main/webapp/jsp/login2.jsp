<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面2</title>
    <s:head/>
</head>
<body>
<s:form action="Login2" validate="true">
    <s:textfield name="username" label="用户名"/>
    <s:textfield name="password" label="密 码"/>
    <s:textfield name="users[0].name" label="First User Name"/>
    <s:textfield name="users[0].pass" label="First User Pass"/>
    <s:textfield name="users[1].name" label="Second User Name"/>
    <s:textfield name="users[1].pass" label="Second User Pass"/>
    <s:textfield name="user" label="User"/>
    <s:submit value="Commit"/>
</s:form>
</body>
</html>