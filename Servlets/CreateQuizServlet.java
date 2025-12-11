package com.quizportal.servlet;

import com.quizportal.util.DBConnection;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/CreateQuizServlet")
public class CreateQuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizName = request.getParameter("quizName");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        int userId = (Integer) request.getSession().getAttribute("userId");

        String[] questions = request.getParameterValues("questionText[]");
        String[] optionA = request.getParameterValues("optionA[]");
        String[] optionB = request.getParameterValues("optionB[]");
        String[] optionC = request.getParameterValues("optionC[]");
        String[] optionD = request.getParameterValues("optionD[]");
        String[] correctOption = request.getParameterValues("correctOption[]");

        try (Connection con = DBConnection.getConnection()) {
            // insert quiz
            PreparedStatement psQuiz = con.prepareStatement(
                "INSERT INTO quizzes (quiz_name, description, category, total_questions, created_by) VALUES (?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
            psQuiz.setString(1, quizName);
            psQuiz.setString(2, description);
            psQuiz.setString(3, category);
            psQuiz.setInt(4, questions.length);
            psQuiz.setInt(5, userId);
            psQuiz.executeUpdate();

            ResultSet rs = psQuiz.getGeneratedKeys();
            int quizId = 0;
            if(rs.next()) quizId = rs.getInt(1);

            // insert questions and map to quiz
            for(int i=0; i<questions.length; i++) {
                PreparedStatement psQ = con.prepareStatement(
                    "INSERT INTO questions (question_text, option_a, option_b, option_c, option_d, correct_option, created_by) VALUES (?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS
                );
                psQ.setString(1, questions[i]);
                psQ.setString(2, optionA[i]);
                psQ.setString(3, optionB[i]);
                psQ.setString(4, optionC[i]);
                psQ.setString(5, optionD[i]);
                psQ.setString(6, correctOption[i]);
                psQ.setInt(7, userId);
                psQ.executeUpdate();

                ResultSet rsQ = psQ.getGeneratedKeys();
                int qid = 0;
                if(rsQ.next()) qid = rsQ.getInt(1);

                PreparedStatement psMap = con.prepareStatement(
                    "INSERT INTO quiz_questions (quiz_id, question_id, question_order) VALUES (?,?,?)"
                );
                psMap.setInt(1, quizId);
                psMap.setInt(2, qid);
                psMap.setInt(3, i+1);
                psMap.executeUpdate();
            }

            response.sendRedirect("views/dashboard.jsp?msg=QuizCreated");

        } catch(Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
