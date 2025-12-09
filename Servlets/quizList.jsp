<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.quizportal.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Quizzes</title>
</head>
<body>

<h2>Welcome <%= session.getAttribute("user") %></h2>

<h2>Available Quizzes</h2>

<%
try {
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement("SELECT * FROM quizzes");
    ResultSet rs = ps.executeQuery();

    while(rs.next()) {
%>
        <a href="<%= request.getContextPath() %>/views/attemptQuiz.jsp?quizId=<%= rs.getInt("quiz_id") %>">
    <%= rs.getString("quiz_name") %>
</a>

        <br>
<%
    }
    rs.close();
    ps.close();
    con.close();
} catch(Exception e) {
    out.println("Error: " + e.getMessage());
}
%>

</body>
</html>
