package com.wap.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.dao.CourseDao;
import com.wap.dao.QuestionDao;
import com.wap.domain.Course;
import com.wap.domain.Question;
import com.wap.domain.User;

/**
 * Servlet implementation class Course controller
 * @author vynguyen
 * @date 2018-03-19
 */
@WebServlet(description = "Course Page", urlPatterns = { "/Course" })
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
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
		
		// Check user login or not
		User user = (User)request.getSession().getAttribute("user"); 
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		// Get parameter
		String buttonCourseID = request.getParameter("bCourse");
		
		// Get course from database
		CourseDao cd = new CourseDao();
		Course course = cd.getCourse(Integer.valueOf(buttonCourseID));
		
		// Init start time
		Long startTime = System.nanoTime();
		
		// Random questions
		QuestionDao questionDao = new QuestionDao();
		List<Question> lstQuestion = questionDao.getRandomQuizQuestionList(course.getId(), 10);
		
		// Get date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
		LocalDateTime date = LocalDateTime.now();
		String formatDateTime = date.format(formatter);
		
		// Send to UI
		request.setAttribute("courseName", course.getName());
		request.setAttribute("questions", lstQuestion);
		request.setAttribute("date", formatDateTime);
		request.setAttribute("startTime", startTime.toString());
		request.setAttribute("courseID", buttonCourseID);
		
		// Go to Quiz page
		RequestDispatcher rq =  request.getRequestDispatcher("quiz.jsp");
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
