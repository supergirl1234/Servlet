<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/30 0030
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="#" method="post">
        <table border="1" width="100%">
            <tr>
                <td>id</td>
                <td>name</td>
                <td>price</td>
                <td>detail</td>
                <td>pic</td>
                <td>createtime</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${itemslistKey}" var="items">
                <tr>
                    <td>${items.id}</td>
                    <td>${items.name}</td>
                    <td>${items.price}</td>
                    <td>${items.detail}</td>
                    <td>${items.pic}</td>
                    <td><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td><a href="#">modify</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

</body>
</html>
