<%@ page import="java.util.List, com.quizportal.model.LeaderboardEntry, java.text.SimpleDateFormat" %>
<%
    List<LeaderboardEntry> leaderboard = (List<LeaderboardEntry>) request.getAttribute("leaderboard");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Leaderboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/leaderboard.css">
</head>
<body>

<div class="leaderboard-container">
    <h1>Leaderboard</h1>

    <table class="leaderboard-table">
        <thead>
            <tr>
                <th>Rank</th>
                <th>User</th>
                <th>Score</th>
                <th>Attempted At</th>
            </tr>
        </thead>
        <tbody>
        <%
            int rank = 1;
            for (LeaderboardEntry entry : leaderboard) {
        %>
            <tr>
                <td><%= rank++ %></td>
                <td><%= entry.getUsername() %></td>
                <td><%= entry.getScore() %></td>
                <td><%= sdf.format(entry.getAttemptedAt()) %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
