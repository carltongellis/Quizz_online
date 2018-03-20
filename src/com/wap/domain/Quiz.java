package com.wap.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The Quiz class
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 2018-03-18
 * 
 *        Updated By Carlton Ellis on 2018-03-20
 */
public class Quiz {
	private int id;
	private int userid;
	private int courseid;
	private String dateTaken;
	private String timeStart;
	private String timeEnd;
	private float score; // percentage score
	private List<Question> lstQuestions = new ArrayList<Question>();

	public Quiz() {

	}

	public Quiz(int userid, int courseid, String dateTaken, String timeStart) {
		this.userid = userid;
		this.courseid = courseid;
		this.dateTaken = dateTaken;
		this.timeStart = timeStart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(String dateTaken) {
		this.dateTaken = dateTaken;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public List<Question> getLstQuestions() {
		return lstQuestions;
	}

	public void setLstQuestions(List<Question> lstQuestions) {
		this.lstQuestions = lstQuestions;
	}

}
