<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Anketa</title>
</head>
<body>
    <form action="/login" method="post">
        <label for="login"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="login">
        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password">
        <button type="submit">Login</button>
    </form>
</body>