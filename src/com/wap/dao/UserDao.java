package com.wap.dao;

import java.sql.Connection;

import com.wap.utils.DBConnection;

public class UserDao {
	Connection con;

	public UserDao() {
		con = DBConnection.getConnection();
	}

	User getUser() {
		return new User();
	}

	// delete inner class after real call updated
	class User {

	}

}
