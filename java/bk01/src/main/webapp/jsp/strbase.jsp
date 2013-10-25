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
    <s:iterator value="{'a', 'b', 'c'}" status="st" id="test1">
        <tr>
            <td><s:property value="#st.count"/></td>
            <td><s:property value="#test1"/></td>
        </tr>
    </s:iterator>
</table>

<s:append var="newList">
    <s:param value="{'aa', 'bb', 'cc'}"/>
    <s:param value="{'dd', 'ee'}"/>
</s:append>
<table>
    <s:iterator value="#newList" status="st" id="list">
        <tr>
            <td>
                <s:property value="#st.count"/>
            </td>
            <td>
                <s:property value="#list"/>
            </td>
        </tr>
    </s:iterator>
</table>

<s:checkboxlist name="a" list="{'a1', 'a2', 'a3'}" label="CheckBox"/>

<!-- struts debut label test -->
<s:debug/>

</body>
</html>