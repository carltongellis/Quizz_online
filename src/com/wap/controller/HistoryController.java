package com.wap.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.CourseDao;
import com.wap.dao.QuizDao;
import com.wap.domain.Course;
import com.wap.domain.Quiz;
import com.wap.domain.User;

/**
 * Servlet implementation class Course
 * @author vynguyen
 * @date 2018-03-20
 */
@WebServlet(description = "History Page", urlPatterns = { "/History" })
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Load quiz from database
		User user = (User)request.getSession().getAttribute("user");
		
		// Load list course from database
		CourseDao cd = new CourseDao();
		List<Course> lstCourses = cd.getCourseList();
		
		// Get all quiz in all course that user had taken with results inside
		QuizDao qd = new QuizDao();
		HashMap<Course, List<Quiz>> mapCourseQuiz = new HashMap<Course, List<Quiz>>();
		for (Course course : lstCourses) {
			List<Quiz> lstQuiz = qd.getQuizTakenByCourseList(user.getId(), course.getId());
			mapCourseQuiz.put(course, lstQuiz);
		}
		
		request.setAttribute("mapCourseQuiz", mapCourseQuiz);
		
		RequestDispatcher rq = request.getRequestDispatcher("history.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
