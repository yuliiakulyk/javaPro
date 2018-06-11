<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body>
<% String login = (String)session.getAttribute("user_login"); %>

<% if (login == null || "".equals(login)) { //not logged in user%>
    <p>Your answer to question 1: <%= answer1 %></p>
    <p>Your answer to question 2: <%= answer2 %></p>
<% } else { //logged in user%>
    <h1>You are logged in as: <%= login %></h1>
    <br>Click this link to <a href="/login?a=exit">logout</a>

    <p>Your answer to question 1: <%= answer1 %></p>
    <p>Your answer to question 2: <%= answer2 %></p>
    <p></p>
    <p></p>
    <p>Other people's answers:</p>
    <p>Question 1:</p>
    <p>Answer 1 count: <%= q1a1 %></p>
    <p>Answer 2 count: <%= q1a2 %></p>
    <p></p>
    <p>Question 2:</p>
    <p>Answer 1 count: <%= q2a1 %></p>
    <p>Answer 2 count: <%= q2a2 %></p>

<%}%>

</body>
</html>
