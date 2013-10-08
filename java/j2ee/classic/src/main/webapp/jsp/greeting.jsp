<%--
  User: Morn
  Date: 13-10-7
  Time: 下午9:03
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:loadBundle basename="messages" var="msg"/>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <f:view>
        <h3><h:outputText value="#{msg.greeting}"/></h3>
        <h:outputText value="#{msg.namePrompt}"/>
        <h:outputText value="#{login.name}"/><br/>
        <h:outputText value="#{msg.passPrompt}"/>
        <h:outputText value="#{login.pass}"/>
        <h:outputText value="#{msg.sign}"/>
    </f:view>
</body>
</html>