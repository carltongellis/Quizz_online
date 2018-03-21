package com.wap.domain;

/**
 * The Course class
 *
 * @author Vy Nguyen
 * @version 1.0
 * @since 2018-03-18
 */
public class Course {
	private int id;// added by C.Ellis
	private String name;
	private String description = "";
	private Quiz quiz;

	public Course(String name) {
		this.name = name;
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

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
