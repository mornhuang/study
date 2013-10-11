<%--
  User: Morn
  Date: 2013-10-08 20:52
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Show adding book</title>
</head>
<body>
    Name:<h:outputText value="#{bookBean.name}"/><br/>
    Isbn:<h:outputText value="#{bookBean.isbn}"/><br/>
    Desc:<h:outputText value="#{bookBean.desc}"/><br/>
</body>
</html>
</f:view>