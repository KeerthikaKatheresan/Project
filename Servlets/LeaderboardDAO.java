package com.quizportal.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.quizportal.model.LeaderboardEntry;
import com.quizportal.util.DBConnection;



//dao/LeaderboardDAO.java
public class LeaderboardDAO {
 public List<LeaderboardEntry> getLeaderboard(int quizId) throws SQLException {
     List<LeaderboardEntry> list = new ArrayList<>();
     try (Connection con = DBConnection.getConnection()) {
         PreparedStatement ps = con.prepareStatement(
             "SELECT u.username, a.score, a.attempted_at " +
             "FROM attempts a JOIN users u ON a.user_id = u.user_id " +
             "WHERE a.quiz_id = ? ORDER BY a.score DESC, a.attempted_at ASC"
         );
         ps.setInt(1, quizId);
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
             list.add(new LeaderboardEntry(
                 rs.getString("username"),
                 rs.getInt("score"),
                 rs.getTimestamp("attempted_at")
             ));
         }
     }
     return list;
 }
}

