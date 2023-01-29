<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.01.2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Admin</title>
</head>
<body>
<table>
    <tbody>
    <form action="${pageContext.request.contextPath}/user/create" method="post">
        <tr>
            <td><input type="text" name="login" placeholder="Enter Login"></td>
            <td><input type="text" name="password" placeholder="Enter Password"></td>
            <td><input type="text" name="firstname" placeholder="Enter Name"></td>
            <td><input type="text" name="secondname" placeholder="Enter Surname"></td>
            <td><input type="text" name="age" placeholder="Enter Age"></td>
            <td><input type="text" name="userType" placeholder="Enter userType"></td>
            <td><input type="submit" value="CREATE"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
