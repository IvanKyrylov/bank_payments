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

<h2>Credit Account</h2>
    <table>
    <tr>
        <th>Account number</th>
        <th>Credit</th>
        <th>Percent rate</th>
        <th>Date of receiving</th>
        <th>Return time</th>
        <th>Credit limit</th>
        <th>Action</th>
    </tr>
<c:forEach var="account" items="${accountList}">
    <c:if test="${account.type.equals('Credit')}">
    <tr>
        <td>${account.num}</td>
        <td>${account.credit}</td>
        <td>${account.percent}</td>
        <td>${account.createTime}</td>
        <td>${account.returnTime}</td>
        <td>${account.creditLimit}</td>
        <td>
            <a href="/take/${account.id}">Take credit</a>
            <a href="/repay/${account.id}">Repay</a>
        </td>
    </tr>
    </c:if>

</c:forEach>
</table>

<h2>Deposit Account</h2>
<table>
    <tr>
        <th>Account number</th>
        <th>Cash</th>
        <th>Deposit rate</th>
        <th>Date of receiving</th>
        <th>Accrual date</th>
    </tr>
    <c:forEach var="account" items="${accountList}">
        <c:if test="${account.type.equals('Deposit')}">
    <tr>
        <td>${account.num}</td>
        <td>${account.cash}</td>
        <td>${account.deposit_rate}</td>
        <td>${account.createTime}</td>
        <td>${account.returnTime}</td>
        <td><a href="/take/${account.id}">Take cash</a></td>
        <td><a href="/repay/${account.id}">Replenish</a></td>
    </tr>

        </c:if>
    </c:forEach>
</table>

<form action="/add" method="post">
    <select name="type">
        <option value="Credit">Credit</option>
        <option value="Deposit">Deposit</option>
    </select>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}">
    <input value="add" type="submit">
</form>

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
