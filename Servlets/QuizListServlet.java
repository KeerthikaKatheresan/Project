package com.quizportal.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.quizportal.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/QuizListServlet")
public class QuizListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT quiz_id, quiz_name FROM quizzes");
             ResultSet rs = ps.executeQuery()) {

            List<Map<String, Object>> quizzes = new ArrayList<>();
            while (rs.next()) {
                Map<String, Object> quiz = new HashMap<>();
                quiz.put("id", rs.getInt("quiz_id"));
                quiz.put("name", rs.getString("quiz_name"));
                quizzes.add(quiz);
            }

            request.setAttribute("quizzes", quizzes);
            request.getRequestDispatcher("views/welcome.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
