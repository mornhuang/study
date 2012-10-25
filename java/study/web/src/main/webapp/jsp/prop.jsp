<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性测试</title>
</head>
<body>
<%
	InputStream is = request.getInputStream();
	BufferedReader br = new BufferedReader(new InputStreamReader(is));
	String buf = null;
	while( (buf = br.readLine()) != null) {
		out.println(buf + "<br>");
	}
%>
</body>
</html>