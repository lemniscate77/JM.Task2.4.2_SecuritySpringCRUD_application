<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.09.2020
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
<h1>Hello world!</h1>

<p>Click <a th:href="@{/login}">here</a> to login.</p>
</body>
</html>