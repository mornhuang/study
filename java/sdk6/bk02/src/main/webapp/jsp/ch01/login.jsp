<%--
  User: Morn
  Date: 13-10-7
  Time: 8:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<f:loadBundle var="msg" basename="messages"/>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <f:view>
        <h3><h:outputText value="#{msg.loginHeader}"/></h3>
        <b><h:outputText value="#{login.err}"/></b>
        <h:form id="loginForm">
            <h:outputText value="#{msg.namePrompt}"/>
            <h:inputText value="#{login.name}"/> <br/>
            <h:outputText value="#{msg.passPrompt}"/>
            <h:inputText id="pass" value="#{login.pass}"/><br/>
            <h:commandButton action="#{login.valid}" value="#{msg.buttonTitle}"/>
        </h:form>
    </f:view>
</body>
</html>