package com.wap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wap.domain.User;
import com.wap.utils.DBConnection;

public class UserDao {
	Connection con;

	public UserDao() {
		// Initialize database connection
		con = DBConnection.getConnection();
	}

	public void insertUsert(User user) { // Save new user to database
		try {
			String qry = "insert into user(username, email, password) values(?,?,?)";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User getUser(int id) {// retrieve user a user from database based on user id
		try {
			String qry = "Select * from user where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getUserList() {// retrieve all users from database
		try {
			List<User> userList = new ArrayList<User>();
			String qry = "select * from user";
			PreparedStatement pst = con.prepareStatement(qry);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));

				userList.add(user);
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteUser(int id) {// delete a user from DB based on id
		try {
			String qry = "delete from user where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {// update a user in DB based on id
		try {
			String qry = "update user set username=?, email=?, password=? where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getEmail());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
