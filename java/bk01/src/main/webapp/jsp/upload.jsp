<%--
  User: Morn
  Date: 13-9-22
  Time: 下午8:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Simple File Upload</title>
</head>
<body>
   <s:form action="Upload" enctype="multipart/form-data">
       <s:textfield name="title" label="Title"/><br/>
       <s:file name="upload" label="Select File"/><br/>
       <s:submit value="Submit"/>
   </s:form>
</body>
</html>