<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Result</title>
</head>
<body>
    <h2>Your Score: <%= request.getAttribute("score") %></h2>

    <!-- Button to view leaderboard -->
    <form action="/QuizPortal/LeaderboardServlet" method="get">
        <input type="hidden" name="quizId" value="<%= request.getAttribute("quizId") %>">
        <button type="submit">View Leaderboard</button>
    </form>
</body>
</html>
