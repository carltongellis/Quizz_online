package com.wap.domain;

/**
 * The QuestionOption class
 *
 * @author Carlton Ellis
 * @version 1.0
 * @since 2018-03-20
 */

public class QuestionOption {
	int id;
	int questionid;
	String text;
	int isAnswer;

	public QuestionOption(String text, int isAnswer) {
		super();
		this.text = text;
		this.isAnswer = isAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(int isAnswer) {
		this.isAnswer = isAnswer;
	}
}
