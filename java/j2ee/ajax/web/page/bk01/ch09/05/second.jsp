<%--
  Date: 2013-10-20 20:25
--%>

<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String fruit = request.getParameter("favorite");
    if ("apple".startsWith(fruit)) {
        out.println("apple");
    } else if ("banana".startsWith(fruit)) {
        out.println("banana");
    } else if ("peach".startsWith(fruit)) {
        out.println("peach");
    } else {
        out.println("other fruit");
    }
%>