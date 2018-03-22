package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.wap.dao.QuizDao;
import com.wap.domain.Quiz;
import com.wap.domain.User;

/**
 * Servlet implementation class Result controller
 * @author vynguyen
 * @date 2018-03-19
 */
@WebServlet(description = "Result after quiz page", urlPatterns = { "/Result" })
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
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
		
		// Avoid null parameter
		String date = "";
		String startTime = "";
		String courseID = "";
		String grade = "";
		String answer = "";
		
		// Check user login or not
		User user = (User)request.getSession().getAttribute("user"); 
		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
				
		// Generate printer writer
		PrintWriter out = response.getWriter();
		
		// Init response text/html
		response.setContentType("application/json");
		
		// Get parameters
		date = request.getParameter("date");
		startTime = request.getParameter("startTime");
		courseID = request.getParameter("courseID");
		grade = request.getParameter("score");
		answer = request.getParameter("listQuestionAnswered");
		Long timeEnd = System.nanoTime() / 1000000000 ;
		Long timeStart = Long.valueOf(startTime) / 1000000000;
		
		// Convert to JSON object
		JSONParser parser = new JSONParser();
		JSONObject jsonob = new JSONObject();
		try {
			jsonob = (JSONObject)parser.parse(answer);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Calculate total time
		Long totalTime = timeEnd - timeStart;
		
		// Create quiz and insert to database
		Quiz q = new Quiz(user.getId(), Integer.valueOf(courseID), date, timeStart.toString());
		q.setTimeEnd(timeEnd.toString());
		q.setScore(Float.valueOf(grade));
		QuizDao quizDB = new QuizDao();
		int quizID = quizDB.insertQuizDetails(q);
		
		// Insert quiz answer table
		for (Object key : jsonob.keySet()) {
			String newKey = (String)key;
			Object keyValue = jsonob.get(newKey);
			
			System.out.println("key " + newKey + " value "  + keyValue);
			quizDB.saveResults(quizID, Integer.valueOf(newKey.substring(4)), Integer.valueOf(keyValue.toString()));
		}
		
		// Data send back to client
		JSONObject dataResult = new JSONObject();
		
		dataResult.put("date", q.getDateTaken());
		dataResult.put("time_duration", totalTime);
		
		out.print(dataResult);
		out.flush();	
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
