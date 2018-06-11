<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Anketa</title>
</head>
<body>
    <c:when test="${loggedIn == false}">
        <a href = "/login">Login</a>
    </c:when>
    <c:otherwise>
        <h1>You are logged in as: ${loginName}</h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
    </c:otherwise>

    <a href = "/poll">Go to poll</a>
</body>
</html>