package com.wap.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String questionContent;
	private String bestAnswer;
	private List<String> lstPossibleAnswer = new ArrayList<String>();
	private String userAnswer = "";
	
	public Question(String questionContent, String bestAnswer, List<String> lstPossibleAnswer) {
		this.questionContent = questionContent;
		this.bestAnswer = bestAnswer;
		this.lstPossibleAnswer = lstPossibleAnswer;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getBestAnswer() {
		return bestAnswer;
	}

	public void setBestAnswer(String bestAnswer) {
		this.bestAnswer = bestAnswer;
	}

	public List<String> getLstPossibleAnswer() {
		return lstPossibleAnswer;
	}

	public void addPossibleAnswer(String possibleAnswer) {
		this.lstPossibleAnswer.add(possibleAnswer);
	}
	
	public void removePossibleAnswer(String possibleAnswer) {
		int indexAn = this.lstPossibleAnswer.indexOf(possibleAnswer);
		this.lstPossibleAnswer.remove(indexAn);
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
}
