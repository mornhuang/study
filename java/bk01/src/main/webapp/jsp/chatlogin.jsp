<%--
  User: Morn
  Date: 2013-10-10 16:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat Login</title>
</head>
<body>
    <table width="540" border="1" align="center" bgcolor="#dddddd">
        <tr>
            <td align="center">
                <form id="loginForm" method="post" action="/chatLogin.do">
                    <font color="red">
                        ${requestScope.error}
                    </font>
                    <hr/>
                    <table>
                        <tr>
                            <td colspan="2" align="center">
                                请输入用户名和密码登录
                            </td>
                        </tr>
                        <tr>
                            <td>用户名：</td>
                            <td><input id="name" type="text" name="name"/></td>
                        </tr>
                        <tr>
                            <td>密&nbsp;&nbsp;码：</td>
                            <td><input id="pass" type="text" name="pass"/></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="提交"/>
                                <input type="reset" value="重设"/>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <div align="center">
                        <a href="/jsp/chatreg.jsp">注册新用户</a>
                    </div>
                </form>
            </td>
        </tr>
    </table>
    <script>
        function check()
        {
            var name = document.getElementById("name");
            var pass = document.getElementById("pass");
            var errStr = "";
            if (name.value == "" || name.value == null)
            {
                errStr += "用户名不能为空\n";
            }
            if (pass.value == "" || pass.value == null)
            {
                errStr += "密码不能为空\n";
            }
            if (errStr == "" || errStr == null)
            {
                return true;
            }
            alert(errStr);
            return false;
        }
        document.getElementById("loginForm").onsubmit = check;
    </script>
</body>
</html>