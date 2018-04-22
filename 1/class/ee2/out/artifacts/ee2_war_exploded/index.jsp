<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog.kiev.ua</title>
  </head>
  <body>
    <% String login = (String)session.getAttribute("user_login"); %>
    <% String answeredPoll = (String) session.getAttribute("answeredPoll"); %>
    <% String answer1 = (String)session.getAttribute("answer1"); %>
    <% String answer2 = (String)session.getAttribute("answer2"); %>
    <% String q1a1 = (String)session.getAttribute("question1answer1"); %>
    <% String q1a2 = (String)session.getAttribute("question1answer2"); %>
    <% String q2a1 = (String)session.getAttribute("question2answer1"); %>
    <% String q2a2 = (String)session.getAttribute("question2answer2"); %>

    <% if (login == null || "".equals(login)) { //not logged in user%>
        <form action="/login" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" />
        </form>
    <% } else { //logged in user%>
        <h1>You are logged in as: <%= login %></h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
        <%if (answeredPoll!= null) { //who answered poll %>
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
        <%} else { //who didn't answer - show form %>
    <form action="/anketa" method="POST">
        <p>Question1</p>
        <input type="radio" name="q1" value="answer11">
        <label for="answer11">answer11</label><br>
        <input type="radio" name="q1"value="answer12">
        <label for="answer12">answer12</label><br>
        <p>Question2</p>
        <input type="radio" name="q2" value="answer21">
        <label for="answer21">answer21</label><br>
        <input type="radio" name="q2" value="answer22">
        <label for="answer22">answer22</label><br>
        <input type="submit">
    </form>
        <%}%>
    <% } %>
  </body>
</html>
