package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.QuestionDao;
import com.wap.domain.Question;
import com.wap.domain.QuestionOption;

/**
 * Servlet implementation class QuizController
 */
@WebServlet("/TakeQuiz")
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuizController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		QuestionDao questionDao = new QuestionDao();
		List<Question> questions = questionDao.getRandomQuizQuestionList(1);

		StringBuffer sb = new StringBuffer();
		for (Question question : questions) {
			sb.append("<p>" + question.getQuestionContent() + "</p><ol style='list-stype-type: 'lower-latin';'>");
			for (QuestionOption questionOption : question.getLstPossibleAnswer()) {
				sb.append("<li>" + questionOption.getText() + "</li>");
			}
			sb.append("</ol>");
		}

		PrintWriter out = response.getWriter();
		out.print(sb);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
