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
 * Servlet implementation class createQuizServlet
 */
@WebServlet("/CreateQuizServlet")
public class CreateQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quizName = request.getParameter("quizName");
        String[] questionIds = request.getParameterValues("questionIds");

        try (Connection con = DBConnection.getConnection()) {

            // 1. Insert into quiz table
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO quizzes (quiz_name) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, quizName);
            ps.executeUpdate();

            // Get generated quiz_id
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int quizId = rs.getInt(1);

            // 2. Insert into quiz_questions table
            PreparedStatement ps2 = con.prepareStatement(
                "INSERT INTO quiz_questions (quiz_id, question_id) VALUES (?, ?)");

            for (String qid : questionIds) {
                ps2.setInt(1, quizId);
                ps2.setInt(2, Integer.parseInt(qid));
                ps2.addBatch();
            }
            ps2.executeBatch();

            response.sendRedirect("views/adminDashboard.jsp");

        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
	}

}