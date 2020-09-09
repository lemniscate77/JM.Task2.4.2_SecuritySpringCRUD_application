<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.09.2020
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org" xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<h1>Welcome!</h1>

<p>Click <a th:href="@{/hello}">here</a> to see a greeting.</p>
</body>
</html>
