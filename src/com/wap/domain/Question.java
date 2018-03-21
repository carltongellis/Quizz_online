package com.wap.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The Question class
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 2018-03-18
 */
public class Question {
	private int id;// added by C.Ellis
	private String questionContent;
	private int courseid; // added by C.Ellis
	private List<QuestionOption> lstPossibleAnswer = new ArrayList<QuestionOption>();
	private int selectedAnswer;

	public Question(String questionContent, List<QuestionOption> lstPossibleAnswer) {
		this.questionContent = questionContent;
		this.lstPossibleAnswer = lstPossibleAnswer;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public List<QuestionOption> getLstPossibleAnswer() {
		return lstPossibleAnswer;
	}

	public void addPossibleAnswer(QuestionOption possibleAnswer) {
		this.lstPossibleAnswer.add(possibleAnswer);
	}

	public void setLstPossibleAnswer(List<QuestionOption> lstPossibleAnswer) {
		this.lstPossibleAnswer = lstPossibleAnswer;
	}
	
	public void removePossibleAnswer(QuestionOption possibleAnswer) {
		int indexAn = this.lstPossibleAnswer.indexOf(possibleAnswer);
		this.lstPossibleAnswer.remove(indexAn);
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSelectedAnswer(int selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public int getSlectedAnswer() {
		return selectedAnswer;
	}

}
