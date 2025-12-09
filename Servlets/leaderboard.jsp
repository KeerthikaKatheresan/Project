<%@ page import="java.util.List, com.quizportal.model.LeaderboardEntry" %>
<%
    List<LeaderboardEntry> leaderboard = (List<LeaderboardEntry>) request.getAttribute("leaderboard");
%>
<h2>Leaderboard</h2>
<table border="1">
    <tr>
        <th>Rank</th>
        <th>User</th>
        <th>Score</th>
        <th>Attempted At</th>
    </tr>
<%
    int rank = 1;
    for (LeaderboardEntry entry : leaderboard) {
%>
    <tr>
        <td><%= rank++ %></td>
        <td><%= entry.getUsername() %></td>
        <td><%= entry.getScore() %></td>
        <td><%= entry.getAttemptedAt() %></td>
    </tr>
<%
    }
%>
</table>