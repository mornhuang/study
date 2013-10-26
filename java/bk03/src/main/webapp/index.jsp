<%--
  User: Morn
  Date: 2013-10-12 08:30
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ page import="java.util.*" %>
<%!
    private Properties props;
    private String path;

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }
%>
<%
    // 获取WEB应用程序的绝对路径
    String path2 = application.getRealPath("/");
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Page Link</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="index.css">

    <%-- html5 backfoward support in IE --%>
    <!--[if gte IE 7]>
    <script type='text/javascript' src='js/excanvas.js'></script>
    <link rel="stylesheet" href="css/iefix.css" type="text/css" media="screen"/>
    <![endif]-->
</head>
<body>
<div id="wrapper">
    <div id="book">
        <div id="bk01">
            <table id="ch08">
                <caption>Chapter 08</caption>
                <tr>
                    <td>
                        <dl>
                            <dt>Sub 02</dt>
                            <dd><a href="page/ch08/02/first.xhtml">first.xhtml</a></dd>
                        </dl>
                        <dl>
                            <dt>Sub 04</dt>
                            <dd><a href="page/ch08/04/first.html">first.html</a></dd>
                            <dd><a href="page/ch08/04/first.xhtml">first.xhtml</a></dd>
                        </dl>
                    </td>
                </tr>
            </table>
        </div>
    </div>

    <div id="page">
        中文 <br/>
        <%
            setPath(request.getContextPath());
            out.println(getPath());
            out.println(path2);
        %>
    </div>

    <div id="image">
        <p>图片展示</p>
        <img src="page/ch08/02/img.jsp" alt="img"/>
    </div>
</div>
</body>
</html>