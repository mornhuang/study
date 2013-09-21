<%--
  User: Morn
  Date: 13-9-20
  Time: 下午5:16
  Description: Struts 学习
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Struts 学习</title>
</head>
<body>
<!-- struts iterator test -->
<table border="1" width="200">
    <s:iterator value="{'a', 'b', 'c'}" status="st" id="name">
        <tr>
            <td><s:property value="#st.count"/>
                <%--<s:property value="name"/>--%>
            </td>
        </tr>
    </s:iterator>
</table>

<!-- struts debut label test -->
<s:debug/>

</body>
</html>