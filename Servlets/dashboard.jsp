<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.quizportal.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/dashboard.css">

</head>
<body>

<!-- Header -->
<div class="header">
    <div class="logo">Quiz Portal</div>
    <div class="username">Welcome, <%= session.getAttribute("user") %></div>
</div>

<!-- Main Container -->
<div class="container">
    <h2 class="section-title">Available Quizzes</h2>

    <table class="quiz-table">
        <tr>
            <th>ID</th>
            <th>Quiz Name</th>
            <th>Description</th>
            <th>Action</th>
        </tr>

        <%
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT quiz_id, quiz_name, description FROM quizzes");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("quiz_id") %></td>
            <td><%= rs.getString("quiz_name") %></td>
            <td><%= rs.getString("description") %></td>
            <td>
                <a class="start-btn" 
                   href="<%= request.getContextPath() %>/views/attemptQuiz.jsp?quizId=<%= rs.getInt("quiz_id") %>">
                    Start Test
                </a>
            </td>
        </tr>
        <%
            }
            rs.close();
            ps.close();
            con.close();
        } catch(Exception e) {
            out.println("<p class='error'>Error: " + e.getMessage() + "</p>");
        }
        %>

    </table>
</div>

</body>
</html>
