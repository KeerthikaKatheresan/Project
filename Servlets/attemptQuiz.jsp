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

<!DOCTYPE html>
<html>
<head>
    <title>Attempt Quiz</title>
    <link rel="stylesheet" href="../css/attemptQuiz.css">
</head>
<body>

<div class="header">
    <h2>Quiz Attempt</h2>
</div>

<form action="/QuizPortal/SubmitQuizServlet" method="post" class="quiz-form">
    <input type="hidden" name="quizId" value="<%= quizId %>">

    <%
        int qno = 1;
        while (rs.next()) {
            int qid = rs.getInt("question_id");
    %>

    <div class="question-card">
        <h3>Question <%= qno++ %></h3>
        <p class="q-text"><%= rs.getString("question_text") %></p>

        <label><input type="radio" name="q<%= qid %>" value="A" required> <%= rs.getString("option_a") %></label><br>
        <label><input type="radio" name="q<%= qid %>" value="B"> <%= rs.getString("option_b") %></label><br>
        <label><input type="radio" name="q<%= qid %>" value="C"> <%= rs.getString("option_c") %></label><br>
        <label><input type="radio" name="q<%= qid %>" value="D"> <%= rs.getString("option_d") %></label><br>
    </div>

    <%
        }
        rs.close();
        ps.close();
        con.close();
    %>

    <button type="submit" class="end-test-btn">SUBMIT QUIZ</button>
</form>

</body>
</html>
