<%--
  User: Morn
  Date: 13-10-8
  Time: 下午8:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<f:view>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
    <h1><h:outputText value="Add Book"/></h1>
    <h:form>
        Name:<h:inputText label="Name" value="#{bookBean.name}"/><br/>
        ISBN:<h:inputText label="Isbn" value="#{bookBean.isbn}"/><br/>
        Desc:<h:inputTextarea rows="4" cols="50" label="Desc" value="#{bookBean.desc}"/><br/>
        Price:<h:inputText binding="#{bookBean.price}"/>
        <h:commandButton value="Add Book" action="#{bookBean.addBook}"/><br/>
    </h:form>
</body>
</html>
</f:view>