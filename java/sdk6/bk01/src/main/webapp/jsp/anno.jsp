<%--
  User: Morn
  Date: 13-9-21
  Time: 上午11:18
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Annotation Struts</title>
</head>
<body>
    Struts Get UserName:<h3><s:property value="username" /></h3><br/>
    JSP Expression Get Password:<h3>${requestScope.password}</h3><br/>
    JSP Script Get Password:<h3><%=request.getAttribute("password")%></h3><br/>
    <jsp:useBean id="anno" class="com.huang.j2ee.ch01.action.AnnoAction" scope="page"/>
    jsp:getProperty:<h3><jsp:getProperty name="anno" property="password" /></h3>
</body>
</html>