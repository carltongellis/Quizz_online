package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

import com.wap.dao.UserDao;
import com.wap.domain.User;

/**
 * Servlet implementation class SignUp
 * @author vynguyen
 * @date 2018-03-19
 */
@WebServlet(description = "Sign Up Page", urlPatterns = { "/SignUp" })
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		
		// Get parameters value
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPass");
		String userEmail = request.getParameter("userEmail");
		
		// Regular expression
		String userNameRegx = "^[a-zA-Z0-9._-]{6,}$";
		String userEmailRegx = "^[a-zA-Z0-9._+%-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$";
		
		// Init JSON object
		JSONObject jsob = new JSONObject();
		jsob.put("result", "failed");
		HashMap<String, String> failedMessage = new HashMap<String, String>();
		
		// Get message if any field is not matched
		boolean isFailed = false;
		if (userName.isEmpty()) {
			failedMessage.put("userName", "User name is empty.");
			isFailed = true;
		}
		
		if (userPassword.isEmpty()) {
			failedMessage.put("userPassword", "User password is empty.");
			isFailed = true;
		}
		
		if (userEmail.isEmpty()) {
			failedMessage.put("userEmail", "User email is empty.");
			isFailed = true;
		}
		
		if (!userName.matches(userNameRegx)) {
			failedMessage.put("userNameRegx", "User name is less than 6 charactors and is not match charactors.");
			isFailed = true;
		}
		
		if (!userEmail.matches(userEmailRegx)) {
			failedMessage.put("userEmailRegx", "User email is not matched.");
			isFailed = true;
		}
		
		if (userPassword.length() < 6) {
			failedMessage.put("userPasswordLength", "User password is less than 6 charactors.");
			isFailed = true;
		}
		
		if (isFailed) { // Verify any field is failed
			jsob.put("message", failedMessage);
				
			out.print(jsob);
			out.flush();	
			
		} else { // Pass case
			// Create user
			UserDao userDao = new UserDao();
			userDao.insertUsert(new User(userName, userEmail, userPassword));
			
			// Go to Login page
			RequestDispatcher rq =  request.getRequestDispatcher("Login.jsp");
			rq.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
