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
import jakarta.servlet.http.HttpSession;

import com.quizportal.util.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		try (Connection con = DBConnection.getConnection()) {
			String sql = "SELECT * FROM users WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String role = rs.getString("role");
				 int userId = rs.getInt("user_id"); 
				 String username = rs.getString("username");
				 HttpSession session = request.getSession();
				    session.setAttribute("userId", userId);   // store userId
				    session.setAttribute("user", username);
				    session.setAttribute("role", role);
				if ("ADMIN".equals(role)) {
					response.sendRedirect("views/adminDashboard.jsp");
				} else {
					
					response.sendRedirect("views/dashboard.jsp");
				}

			} else {
				response.getWriter().println("Invalid login!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}