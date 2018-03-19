package com.wap.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
	private Integer numberQuestion = 10;
	private String result = "";
	private Integer grade = 0;
	private LocalDate dateTaken;
	private Integer totalTime = 0;
	private List<Question> lstQuestions = new ArrayList<Question>();
	
	public Quiz(LocalDate dateTaken) {
		this.dateTaken = dateTaken;
	}

	public Integer getNumberQuestion() {
		return numberQuestion;
	}

	public void setNumberQuestion(Integer numberQuestion) {
		this.numberQuestion = numberQuestion;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Integer getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}

	public List<Question> getLstQuestions() {
		return lstQuestions;
	}

	public void addQuestions(Question question) {
		this.lstQuestions.add(question);
	}

	public LocalDate getDateTaken() {
		return dateTaken;
	}
	
	// --- Functions --- //
	
	/*
	 * This function is used for random loading
	 * question from database
	*/
	public void loadQuestion() {
		
	}
	
}
