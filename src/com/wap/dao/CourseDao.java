package com.wap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wap.domain.Course;
import com.wap.domain.User;
import com.wap.utils.DBConnection;

/**
 * Course Dao
 * 
 * @author Carlton Ellis
 * @date 2018-03-19
 */
public class CourseDao {

	Connection con;

	public CourseDao() {
		// Initialize database connection
		con = DBConnection.getConnection();
	}

	public void insertCourse(Course course) { // Save new course to database
		try {
			String qry = "insert into course(name, description) values(?,?)";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, course.getName());
			pst.setString(2, course.getDescription());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Course getCourse(int id) {// retrieve a course details from database based on id
		try {
			String qry = "Select * from course where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getString("name"));
				course.setDescription(rs.getString("description"));
				course.setId(rs.getInt("id"));
				return course;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Function get course by course name
	 * @author vynguyen
	 * @date: 2018-03-20
	 * */
	public Course getCourseByCoursename(String courseName) {// retrieve a course from database based on coursename
		try {
			String qry = "Select * from course where name=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setString(1, courseName);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getString("name"));
				course.setDescription(rs.getString("description"));
				course.setId(rs.getInt("id"));
				return course;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Course> getCourseList() {// retrieve all Courses from database
		try {
			List<Course> courseList = new ArrayList<Course>();
			String qry = "select * from course";
			PreparedStatement pst = con.prepareStatement(qry);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Course course = new Course(rs.getString("name"));
				course.setDescription(rs.getString("description"));
				course.setId(rs.getInt("id"));

				courseList.add(course);
			}
			return courseList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
