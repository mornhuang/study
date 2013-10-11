<%--
  User: Morn
  Date: 2013-10-10 17:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
    <table width="780" border="1" align="center">
        <tr>
            <td>
                <p align="center">聊天页面</p>
                <p align="center">
                    <textarea name="textarea" cols="100" rows="30" readonly="readonly">
                        ${requestScope.msg}</textarea>
                </p>
                <form name="chatForm" method="post" action="/chat.do" >
                    <div align="center">
                        <input name="chatMsg" type="text" size="90" onclick="document.chatForm.submit;"/>
                        <input type="submit" name="Submit" value="发送"/>
                    </div>
                </form>
                <p>&nbsp; </p>
            </td>
        </tr>
    </table>
    <script>
        var input = document.getElementById("chatMsg");
        input.focus();

        function check()
        {
            if (input.value == null || input.value == "")
            {
                alert("请输入聊天信息，不要发送空信息!");
                return false;
            }
        }

        function submitChat()
        {
            document.getElementById("chatForm").onsubmit();
        }

        document.getElementById("chatForm").onsubmit = check;
    </script>
</body>
</html>