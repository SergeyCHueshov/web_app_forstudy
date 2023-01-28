<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.01.2023
  Time: 18:08
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

  <form action="/errors/loginmistake" method="filter">
  </form>
  <pre>Нам тебя и одного много!)</pre>
  <form action="/index.jsp" target="_blank">
  <button><input type="submit" value="Recreate"></button>
  </form>
  </tbody>
</table>

</body>
</html>