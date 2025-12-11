package com.quizportal.servlet;

import com.quizportal.dao.LeaderboardDAO;
import com.quizportal.model.LeaderboardEntry;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/LeaderboardServlet")
public class LeaderboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int quizId = Integer.parseInt(request.getParameter("quizId"));

        try {
            LeaderboardDAO dao = new LeaderboardDAO();
            List<LeaderboardEntry> leaderboard = dao.getLeaderboard(quizId);

            // Pass DTO list to JSP
            request.setAttribute("leaderboard", leaderboard);
            request.getRequestDispatcher("views/leaderboard.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
