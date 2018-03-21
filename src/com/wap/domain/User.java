package com.wap.domain;

import java.util.HashMap;

/**
* The User class
*
* @author  Vy Nguyen
* @version 1.0
* @since   2018-03-18 
*/
public class User {
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String fName;
	private String lName;
	private HashMap<String, Quiz> mapQuizTaken = new HashMap<String, Quiz>();

	public User(String username, String fName, String lName, String email, String password) {
		this.username = username;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
