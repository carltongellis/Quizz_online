package com.wap.domain;

import java.time.LocalDate;
import java.util.HashMap;

public class User {
	private Integer id;
	private String username;
	private String email;
	private String password;
	private HashMap<String, Quiz> mapQuizTaken = new HashMap<String, Quiz>();

	public User() {

	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void addQuizTaken(String courseName, Quiz quiz) {
		this.mapQuizTaken.put(courseName, quiz);
	}

	// --- Functions --- //

	/*
	 * This function is used for starting quiz after user choose the course
	 */
	public Quiz takeQuiz(Course course, LocalDate dateTaken) {
		course.createQuiz(dateTaken);

		// Add to map
		this.mapQuizTaken.put(course.getName(), course.getQuiz());

		return course.getQuiz();
	}

	/*
	 * This function is used for choosing the course testing
	 */
	public Course chooseCourse(String courseName) {
		return null;
	}

	public void setUsername(String username) {
		this.username = username;

	}
}
