<%--
  User: Morn
  Date: 13-9-20
  Time: 下午6:44
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>J2EE学习</title>
    <style type="text/css">
        div#container {
            width: 800px
        }

        div#left {
            background-color: #ffff99;
            height: 400px;
            width: 400px;
            float: left;
        }

        div#right {
            background-color: #EEEEEE;
            height: 400px;
            width: 400px;
            float: left;
        }

        div#footer {
            background-color: #99bbbb;
            clear: both;
            text-align: center;
        }

        h1 {
            margin-bottom: 0;
        }

        h2 {
            margin-bottom: 0;
            font-size: 14px;
        }

        ul {
            margin: 0;
        }

        li {
            list-style: none;
        }
    </style>
</head>
<body>

<div id="container">
    <div id="left">
        <ol>
            <li><a href="/jsp/showJasper.jsp">查看iReport报表</a></li>
            <li><a href="/jsp/showBirt.jsp">查看Birt报表</a></li>
            <li><a href="/jsp/login1.jsp">login1.jsp</a></li>
            <li><a href="/jsp/login2.jsp">login2.jsp</a></li>
            <li><a href="/jsp/login3.jsp">login3.jsp</a></li>
            <li><a href="/jsp/base.jsp">JSP基础</a></li>
            <li><a href="/jsp/forindicator.jsp">Forward指令</a></li>
            <li><a href="/jsp/strbase.jsp">Struts 学习</a></li>
            <li><a href="<s:url action='Anno'/>">Struts Annotation Study</a></li>
        </ol>
    </div>

    <div id="right">
        <a href="<s:url action='login2.jsp'/>">login2.jsp</a>
    </div>

    <div id="footer">
        <img src="/jsp/img.jsp"/>
    </div>
</div>
</body>
</html>