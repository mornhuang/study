<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>MyEclipse Sample Report Access Webpage</title>
</head>

<body>
  <ul>
    <li>
      <a href="<%=path + "/frameset?__report=reports/test.rptdesign&__format=HTML"%>" target="_top">
                  测试报表(reports/test.rptdesign)
      </a>
    </li>
<%--
    <li>
      <a href="<%=path + "/frameset?__report=reports/statics_work_hazard.rptdesign&__format=HTML"%>">
                  重大危险源报表(reports/statics_work_hazard.rptdesign)
      </a>
    <li>
      <a href="<%=path + "/frameset?__report=reports/statics/work/hazard.rptdesign&__format=HTML"%>">
                 重大危险源报表(reports/statics/work/hazard.rptdesign)
      </a>
    </li>
--%>
    <li>
      <a href="#" onclick='showModalDialog("<%=path + "/frameset?__report=reports/test.rptdesign&__format=HTML"%>", window,"dialogWidth=800px;dialogHeight=600px")'>模态窗口</a>
    </li>
  </ul>
</body>
</html>