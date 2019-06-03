<%@ page import="vo.userInfo" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/3 0003
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>username</td>
        <td>password</td>

    </tr>

    <%
        List<userInfo> userList= (List<userInfo>) request.getSession().getAttribute("userListKey");

        for(userInfo item:userList){



    %>
    <tr>
        <td><%=item.getName()%></td>
        <td><%=item.getPassword()%></td>

    </tr>
    <%}%>


</table>
</body>
</html>
