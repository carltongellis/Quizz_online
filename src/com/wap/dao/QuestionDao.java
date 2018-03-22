package com.wap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wap.domain.Question;
import com.wap.domain.QuestionOption;
import com.wap.utils.DBConnection;

/**
 * Question Dao
 * 
 * @author Carlton Ellis
 * @date 2018-03-20
 */
public class QuestionDao {

	Connection con;

	public QuestionDao() {
		// Initialize database connection
		con = DBConnection.getConnection();
	}

	public void insertQuestion(Question question) { // Save new question with answers to database
		try {
			String qry = "insert into question(courseid, text) values(?,?)";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, question.getCourseid());
			pst.setString(2, question.getQuestionContent());
			pst.execute();

			qry = "insert into questionoption(questionid, text, isAnswer) values(?,?,?)";
			for (QuestionOption qo : question.getLstPossibleAnswer()) {

				PreparedStatement pstqo = con.prepareStatement(qry);
				pstqo.setInt(1, qo.getQuestionid());
				pstqo.setString(2, qo.getText());
				pstqo.setInt(3, qo.getIsAnswer());
				pstqo.execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Question getQuestion(int id) {// retrieve question details from database based on id
		try {
			String qry = "Select * from question where id=?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int qid = rs.getInt("id");
				int cid = rs.getInt("courseid");
				String text = rs.getString("text");

				// get all options for a question
				List<QuestionOption> options = new ArrayList<QuestionOption>();
				qry = "Select * from questionoption where questionid=?";
				PreparedStatement pstqo = con.prepareStatement(qry);
				pstqo.setInt(1, qid);
				ResultSet rsqo = pstqo.executeQuery();
				while (rsqo.next()) {

					QuestionOption questionOption = new QuestionOption(rsqo.getString("text"), rsqo.getInt("isAnswer"));
					questionOption.setId(rsqo.getInt("id"));
					questionOption.setQuestionid(rsqo.getInt("questionid"));
					options.add(questionOption);
				}

				Question question = new Question(text, options);
				question.setId(qid);
				question.setCourseid(cid);
				return question;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Question> getRandomQuizQuestionList(int courseid) {
		// overload function to set amount of retrieve questions to 3
		return getRandomQuizQuestionList(courseid, 3);
	}

	public List<Question> getRandomQuizQuestionList(int courseid, int questionAmount) {
		// retrieve n amount of random questions from database based on course id
		try {
			List<Question> questionList = new ArrayList<Question>();
			String qry = "SELECT * FROM question where courseid=? ORDER BY RAND() LIMIT 0,?";
			PreparedStatement pst = con.prepareStatement(qry);
			pst.setInt(1, courseid);
			pst.setInt(2, questionAmount);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int qid = rs.getInt("id");
				int cid = rs.getInt("courseid");
				String text = rs.getString("text");

				// get all options for a question
				List<QuestionOption> options = new ArrayList<QuestionOption>();
				qry = "Select * from questionoption where questionid=? ORDER BY RAND()";
				PreparedStatement pstqo = con.prepareStatement(qry);
				pstqo.setInt(1, qid);
				ResultSet rsqo = pstqo.executeQuery();
				while (rsqo.next()) {

					QuestionOption questionOption = new QuestionOption(rsqo.getString("text"), rsqo.getInt("isAnswer"));
					questionOption.setId(rsqo.getInt("id"));
					questionOption.setQuestionid(rsqo.getInt("questionid"));
					options.add(questionOption);
				}

				Question question = new Question(text, options);
				question.setId(qid);
				question.setCourseid(cid);

				questionList.add(question);
			}
			return questionList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
