<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<s:form action="Login">
	<s:textfield name="username" label="用户名" />
	<s:textfield name="password" label="密    码" />
	<s:submit value="提交" />
	<s:reset value="重置" />
	</s:form>
</body>
</html>