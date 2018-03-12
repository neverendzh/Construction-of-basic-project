<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/6
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table>

            <thead>
            <tr>
                <td>电影名称</td>
                <td>ID</td>
                <td>PASSWORD</td>
            </tr>

            </thead>
            <tbody>
                <c:forEach items="${Movie}" var="mv">
                    <tr>
                       <td>${mv.name}</td>
                        <td>${mv.id}</td>
                        <td>${mv.password}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>
