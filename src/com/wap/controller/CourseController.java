package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
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
import com.wap.domain.Quiz;
import com.wap.domain.User;

/**
 * Servlet implementation class Course
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
		PrintWriter out = response.getWriter();
		
		// Init response text/html
		//response.setContentType("application/json");
		
		// Get parameter
		String buttonCourseID = request.getParameter("bCourse");
		//request.setAttribute("courseName", buttonCourse);
		
		// Get course from database
		CourseDao cd = new CourseDao();
		Course course = cd.getCourse(Integer.valueOf(buttonCourseID));
		
		// Create quiz
		Long startTime = System.nanoTime() / 1000000000;
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("user id" + user.getId());
		course.createQuiz(user.getId(), LocalDate.now().toString(), startTime.toString());
		
		Quiz q = course.getQuiz();
		
		// Random questions
		QuestionDao questionDao = new QuestionDao();
		List<Question> lstQuestion = questionDao.getRandomQuizQuestionList(course.getId(), 10);
		
		// Send to UI
		request.setAttribute("questions", lstQuestion);
		
		// Convert quiz to JSON object
		// set json object to request attribute
		
		// Go to Quiz page
		RequestDispatcher rq =  request.getRequestDispatcher("quiz.jsp");
		rq.forward(request, response);
		
		// Send JSON object
		//out.print("Take" + buttonCourse + "quiz");
		//out.flush();
		//out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
