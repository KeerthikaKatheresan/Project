package com.quizportal.model;

import java.sql.Timestamp;

public class LeaderboardEntry {

	private String username;
	 private int score;
	 private Timestamp attemptedAt;
	/**
	 * @param username
	 * @param score
	 * @param attemptedAt
	 */
	public LeaderboardEntry(String username, int score, Timestamp attemptedAt) {
		super();
		this.username = username;
		this.score = score;
		this.attemptedAt = attemptedAt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Timestamp getAttemptedAt() {
		return attemptedAt;
	}
	public void setAttemptedAt(Timestamp attemptedAt) {
		this.attemptedAt = attemptedAt;
	}
	@Override
	public String toString() {
		return "LeaderboardEntry [username=" + username + ", score=" + score + ", attemptedAt=" + attemptedAt + "]";
	}
	 
}
