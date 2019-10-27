<%--
  Created by IntelliJ IDEA.
  User: vanns
  Date: 02.08.2019
  Time: 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bank</title>
</head>
<body>

<h1>Registration</h1>
<p>${message}</p>

<c:url value="/registration" var="registrationUrl"/>
<form action="${registrationUrl}" method="post">
    <c:if test="${param.error != null}">
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>
            You have been logged out.
        </p>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="User name"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password"/>
    </p>
    <p>
        <label for="email">email</label>
        <input type="email" id="email" name="email" placeholder="Email">
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Registration</button>
</form>
<br/>
</body>
</html>