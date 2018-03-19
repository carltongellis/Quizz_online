package com.wap.domain;

public class UserProfile {
	private User user;
	
	public UserProfile(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}

	/*
	 * This function is used for showing user profile based
	 * on user information 
	*/
	public void showUserProfile() {
		// todo
	}
	
	// --- Functions --- //
	
	/*
	* This function is used for updating password
	*/
	public void updatePassword(String newPassword) {
		this.user.setPassword(newPassword);
	}
	
	/*
	* This function is used for updating email
	*/
	public void updateEmail(String newEmail) {
		this.user.setEmail(newEmail);
	}
}
