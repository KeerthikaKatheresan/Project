package com.quizportal.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.quizportal.util.DBConnection;

/**
 * Servlet implementation class submitQuizServlet
 */
@WebServlet("/SubmitQuizServlet")
public class SubmitQuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        int userId = (Integer) request.getSession().getAttribute("userId"); // store user ID in session
        int score = 0;

        try (Connection con = DBConnection.getConnection()) {
            // Get all questions for this quiz
            PreparedStatement ps = con.prepareStatement(
                "SELECT q.question_id, q.correct_option FROM questions q JOIN quiz_questions qq ON q.question_id = qq.question_id WHERE qq.quiz_id = ?"
            );
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int qid = rs.getInt("question_id");
                String correctOption = rs.getString("correct_option");
                String userAnswer = request.getParameter("q" + qid);

                if (correctOption.equals(userAnswer)) {
                    score++;
                }
            }

            // Insert into attempts table
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO attempts (user_id, quiz_id, score) VALUES (?, ?, ?)"
            );
            ps2.setInt(1, userId);
            ps2.setInt(2, quizId);
            ps2.setInt(3, score);
            ps2.executeUpdate();

         // After inserting into attempts table
            request.setAttribute("score", score);
            request.setAttribute("quizId", quizId);

            // Forward to result.jsp
            request.getRequestDispatcher("views/result.jsp").forward(request, response);


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
