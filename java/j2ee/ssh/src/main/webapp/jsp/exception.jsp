<%--
  User: Morn
  Date: 13-9-19
  Time: 上午10:28
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
    This is Exception Page!<br/>
    <s:property value="exception.message"/>
    <s:property value="exceptionStack"/>
</body>
</html>