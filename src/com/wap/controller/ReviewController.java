package com.wap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.QuizDao;
import com.wap.domain.Quiz;

/**
 * Servlet implementation class Review
 * @author vynguyen
 * @date 2018-03-21
 */
@WebServlet(description = "Review Page", urlPatterns = { "/Review" })
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewController() {
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

		// Get parameter
		String quizID = request.getParameter("quizID");
		
		// Load from database
		QuizDao qd = new QuizDao();
		Quiz q = qd.getQuizWithAnswer(Integer.valueOf(quizID));
		
		request.setAttribute("questions", q.getLstQuestions());
		
		RequestDispatcher rq = request.getRequestDispatcher("review.jsp");
		rq.forward(request, response);
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
