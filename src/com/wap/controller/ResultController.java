package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.wap.dao.QuestionDao;
import com.wap.dao.QuizDao;
import com.wap.domain.QuestionOption;
import com.wap.domain.Quiz;
import com.wap.domain.User;

/**
 * Servlet implementation class Result
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
		
		PrintWriter out = response.getWriter();
		
		// Init response text/html
		response.setContentType("application/json");
		
		// Get parameters
		String date = request.getParameter("date");
		String startTime = request.getParameter("startTime");
		String courseID = request.getParameter("courseID");
		String answer = request.getParameter("answer");
		Long timeEnd = System.nanoTime() / 1000000000 ;
		Long timeStart = Long.valueOf(startTime) / 1000000000;
		
		System.out.println("start time " + timeStart);
		System.out.println("end time " + timeEnd);
		
		// Convert to JSON object
		JSONParser parser = new JSONParser();
		JSONObject jsonob = new JSONObject();
		System.out.println("answer " + answer);
		try {
			jsonob = (JSONObject)parser.parse(answer);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Calculate total time
		Long totalTime = timeEnd - timeStart;
		
		// Get list question from database
		QuestionDao qd = new QuestionDao();
		Set<String> keys = jsonob.entrySet();
		int grade = 0;
		for (String key : keys) {
			// Get list question possible with one of them is the corrected answer
			List<QuestionOption> lstQuestionOption = qd.getQuestion(Integer.valueOf(key)).getLstPossibleAnswer();
			for (QuestionOption qo : lstQuestionOption) {
				if (qo.getIsAnswer() == 1 
						&& qo.getText().equals((String)jsonob.get(key))) { // compare user answer with database
					grade++;
					break;
				}
			}
		}
		
		// Create quiz and insert to database
		User user = (User)request.getSession().getAttribute("user");
		Quiz q = new Quiz(user.getId(), Integer.valueOf(courseID), date, timeStart.toString());
		q.setTimeEnd(timeEnd.toString());
		q.setScore(grade);
		QuizDao quizDB = new QuizDao();
		int quizID = quizDB.insertQuizDetails(q);
		
		// Data send back to client
		JSONObject dataResult = new JSONObject();
		
		dataResult.put("date", q.getDateTaken());
		dataResult.put("time_duration", totalTime);
		dataResult.put("score", grade);
		
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
