package com.wap.domain;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer numberUser = 0; // total number of user in web page
	private List<User> lstUser = new ArrayList<User>();
	private List<Course> lstCourse = new ArrayList<Course>();

	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNumberUser() {
		return numberUser;
	}

	public void setNumberUser(Integer numberUser) {
		this.numberUser = numberUser;
	}

	public void addUser(User user) {
		this.lstUser.add(user);
	}

	public void addCourse(Course course) {
		this.lstCourse.add(course);
	}

	// Functions

	/*
	 * This function is used for create new user when user sign up
	 */
	public void createUser(String userName, String email, String password) {
		User newUser = new User(userName, email, password);
		this.addUser(newUser);

		// Increase number of user
		this.numberUser++;
	}

	/* User login */
	public void login(User user) {

	}

	/* User logout */
	public void logout(User user) {

	}

	/*
	 * This function is used for loading course from database
	 */
	public void loadCourse() {

	}
}
