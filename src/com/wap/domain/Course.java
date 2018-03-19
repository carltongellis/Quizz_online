package com.wap.domain;

import java.time.LocalDate;

public class Course {
	private String name;
	private String description;
	private Quiz quiz;
	
	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	// --- Functions --- //
	
	/*
	* This function is used for random creating quiz
	* for each user
	*/
	public void createQuiz(LocalDate date) {
		this.quiz = new Quiz(date);
		this.quiz.loadQuestion();
	}
}
