<%--
  Created by IntelliJ IDEA.
  User: vanns
  Date: 24.06.2019
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<h2>User</h2>

    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input value="Logout" type="submit">
    </form>

<%--<h2>Add</h2>--%>
<%--<c:url value = "/add" var="add"/>--%>
<%--<a href ="${add}">Add new users</a>--%>
</body>
</html>
