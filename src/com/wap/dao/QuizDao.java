package com.wap.dao;
/**
 * Question Dao
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

	QuizDao() {
		con = DBConnection.getConnection();
	}

	public void insertQuizDetails(Quiz quiz) { // Save quiz record and quiz answers to database
		try {
			// insert quiz record
			String qry = "insert into quiz(userid, courseid, date, timestart, timeend, score) values(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(qry, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, quiz.getUserid());
			pst.setInt(2, quiz.getCourseid());
			pst.setString(3, quiz.getDateTaken().toString());
			pst.setString(4, quiz.getTimeStart().toString());
			pst.setString(5, quiz.getTimeEnd());
			pst.setFloat(6, quiz.getScore());
			pst.execute();

			ResultSet rs = pst.getGeneratedKeys();
			int quizId = 0;
			if (rs.next()) {
				quizId = rs.getInt(1);
			}
			System.out.println("Inserted quiz record's ID: " + quizId);

			// insert quiz answers
			qry = "insert into quizanswers(quizid, questionid, questionoptionid) values(?,?,?)";
			for (Question question : quiz.getLstQuestions()) {

				PreparedStatement pstqo = con.prepareStatement(qry);
				pstqo.setInt(1, quizId);
				pstqo.setInt(2, question.getId());
				pstqo.setInt(3, question.getSlectedAnswer());
				pstqo.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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
}