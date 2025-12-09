<%@ page import="java.sql.*, com.quizportal.util.DBConnection" %>

<form action="<%= request.getContextPath() %>/CreateQuizServlet" method="post">

    Quiz Name: <input type="text" name="quizName" required><br>

    <h3>Select Questions:</h3>

    <%
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM questions");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
    %>
                <input type="checkbox" name="questionIds" value="<%= rs.getInt("question_id") %>">
                <%= rs.getString("question_text") %><br>
    <%
            }
        } catch (Exception e) {
            out.println("Error loading questions: " + e.getMessage());
        }
    %>

    <button type="submit">Create Quiz</button>
</form>
