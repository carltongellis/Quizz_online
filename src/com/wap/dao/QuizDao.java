package com.wap.dao;
/**
 * QuestionDao
 * 
 * @author Carlton Ellis
 * @date 2018-03-20
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wap.domain.Question;
import com.wap.domain.Quiz;
import com.wap.utils.DBConnection;

public class QuizDao {

	Connection con;

	public QuizDao() {
		con = DBConnection.getConnection();
	}

	public int insertQuizDetails(Quiz quiz) { // Save quiz record and quiz answers to database

		int quizId = 0;
		try {
			// insert quiz record
			String qry = "insert into quiz(userid, courseid, date, timestart, timeend, score) values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, quiz.getUserid());
			pst.setInt(2, quiz.getCourseid());
			pst.setString(3, quiz.getDateTaken());
			pst.setString(4, quiz.getTimeStart());
			pst.setString(5, quiz.getTimeEnd());
			pst.setFloat(6, quiz.getScore());
			pst.execute();

			ResultSet rs = pst.getGeneratedKeys();
			if (rs.next()) {
				quizId = rs.getInt(1);
			}
			System.out.println("Inserted quiz record's ID: " + quizId);

			// insert quiz answers

		} catch (Exception e) {
			e.printStackTrace();
		}

		return quizId;
	}

	public Quiz getQuizAnswers(int quizId) {// retrieve quiz details and answers for a user from database based on quiz
											// id
		QuestionDao questionDao = new QuestionDao();
		List<Question> lstQues = new ArrayList<Question>();
		try {
			String qry = "Select * from quizanswers where quizid=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, quizId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int qid = rs.getInt("questionid");
				int qoid = rs.getInt("questionoptionid");

				Question ques = questionDao.getQuestion(qid);
				ques.setSelectedAnswer(qoid);
				lstQues.add(ques);
			}
			Quiz quiz = new Quiz();
			quiz.setId(quizId);
			quiz.setLstQuestions(lstQues);
			return quiz;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Quiz> getQuizTakenByCourseList(int userid, int courseid) {// return all quiz taken based on course id
																			// and user id
		List<Quiz> quizTaken = new ArrayList<Quiz>();

		try {
			String qry = "Select * from quiz where userid=? and courseid=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, userid);
			pst.setInt(2, courseid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Course course = new Course(rs.getString("name"), rs.getString("code"));
				// course.setId(rs.getInt("id"));

				Quiz quiz = new Quiz(rs.getInt("userid"), rs.getInt("courseid"), rs.getString("date"),
						rs.getString("timestart"));

				quiz.setScore(rs.getFloat("score"));
				quiz.setId(rs.getInt("id"));
				quiz.setTimeEnd(rs.getString("timeend"));
				quizTaken.add(quiz);
			}
			return quizTaken;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Vy Nguyen modifiled - 2018-03-21
	 * */
	public void saveResults(int quizId, int questionId, int userAnswerId) {

		try {
			String qry = "insert into quizanswers(quizid, questionid, questionoptionid) values(?,?,?)";
			PreparedStatement pstqo = con.prepareStatement(qry);
			pstqo.setInt(1, quizId);
			pstqo.setInt(2, questionId);
			pstqo.setInt(3, userAnswerId);
			pstqo.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Quiz getQuizTakenById(int id) {// return a quiz taken based on quiz id
		try {
			String qry = "Select * from quiz where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Quiz quiz = new Quiz(rs.getInt("userid"), rs.getInt("courseid"), rs.getString("date"),
						rs.getString("timestart"));

				quiz.setScore(rs.getFloat("score"));
				quiz.setId(rs.getInt("id"));
				quiz.setTimeEnd(rs.getString("timeend"));
				return quiz;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
