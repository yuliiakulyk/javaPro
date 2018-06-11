<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body>
<p>Logged in: ${loggedIn}</p>
    <c:choose>
        <c:when test="${loggedIn == false}">
            <p>Your answer to question 1: ${answer1}</p>
            <p>Your answer to question 2: ${answer2}</p>
        </c:when>

        <c:otherwise>
            <p>Your answer to question 1: ${answer1}</p>
            <p>Your answer to question 2: ${answer2}</p>
            <br>
            <br>
            <p>All recorded answers:</p>
            <p><b>Question 1:</b></p>

            <c:forEach items="${answersQ1}" var="response">
                <p>${response.answer}: ${response.count}</p>
            </c:forEach>
            <br>
            <p><b>Question 2:</b></p>
            <c:forEach items="${answersQ2}" var="response">
                <p>${response.answer}: ${response.count}</p>
            </c:forEach>
        </c:otherwise>

    </c:choose>

</body>
</html>
