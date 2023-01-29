<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.01.2023
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login_Mistake</title>
</head>
<body>
<table>
    <tbody>

    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    <form action="admin.jsp" method="post">
    </form>
    <pre>All for Administrators</pre>
    <form action="admin.jsp" method="post">
        <button><input type="submit" value="Watch"></button>
    </form>
    </tbody>
    <form action="user.jsp" method="post">
    </form>
    <pre>All for Users</pre>
    <form action="user.jsp" method="post">
        <button><input type="submit" value="Create"></button>
    </form>
</table>

</body>
</html>
