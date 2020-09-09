<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 24.08.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JM Task 2.3.1</title>
</head>
<body>

<h2>users</h2>
<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>email</th>
        <th>action</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>



<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new user</a>
</body>
</html>

