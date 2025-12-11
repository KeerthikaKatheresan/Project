<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Result</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/result.css">
</head>
<body>

<div class="result-container">
    <div class="result-card">
        <h1>Quiz Completed 🎉</h1>

        <p class="info"><strong>Quiz:</strong> <%= request.getAttribute("quizName") %></p>
        <p class="info"><strong>User:</strong> <%= session.getAttribute("user") %></p>
        <p class="info score"><strong>Score:</strong> <%= request.getAttribute("score") %></p>

        <form action="/QuizPortal/LeaderboardServlet" method="get">
            <input type="hidden" name="quizId" value="<%= request.getAttribute("quizId") %>">
            <button class="leader-btn" type="submit">View Leaderboard</button>
        </form>
    </div>
</div>

</body>
</html>
