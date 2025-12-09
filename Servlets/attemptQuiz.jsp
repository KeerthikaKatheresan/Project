<%@ page import="java.sql.*, com.quizportal.util.DBConnection" %>
<%
    int quizId = Integer.parseInt(request.getParameter("quizId"));
    Connection con = DBConnection.getConnection();
    PreparedStatement ps = con.prepareStatement(
        "SELECT q.question_id, q.question_text, q.option_a, q.option_b, q.option_c, q.option_d " +
        "FROM questions q JOIN quiz_questions qq ON q.question_id = qq.question_id WHERE qq.quiz_id = ?"
    );
    ps.setInt(1, quizId);
    ResultSet rs = ps.executeQuery();
%>

<form action="/QuizPortal/SubmitQuizServlet" method="post">
    <input type="hidden" name="quizId" value="<%= quizId %>">

    <%
        while (rs.next()) {
            int qid = rs.getInt("question_id");
    %>
        <p><%= rs.getString("question_text") %></p>
        <input type="radio" name="q<%= qid %>" value="A"> <%= rs.getString("option_a") %><br>
        <input type="radio" name="q<%= qid %>" value="B"> <%= rs.getString("option_b") %><br>
        <input type="radio" name="q<%= qid %>" value="C"> <%= rs.getString("option_c") %><br>
        <input type="radio" name="q<%= qid %>" value="D"> <%= rs.getString("option_d") %><br>
        <hr>
    <%
        }
        rs.close();
        ps.close();
        con.close();
    %>

    <button type="submit">Submit Quiz</button>
</form>
