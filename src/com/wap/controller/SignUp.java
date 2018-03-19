package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		// Init response text/html
		response.setContentType("application/json");
		
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPass");
		String userEmail = request.getParameter("userEmail");
		
		String userNameRegx = "^[a-zA-Z0-9._-]{6,}$";
		String userEmailRegx = "^[a-zA-Z0-9._+%-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$";
		if (userEmail.isEmpty() || userPassword.isEmpty() || userEmail.isEmpty() ||
				!userName.matches(userNameRegx) || userPassword.length() < 6 ||
				!userEmail.matches(userEmailRegx)) { // Verify any field is failed
			
			JSONObject jsob = new JSONObject();
			jsob.put("success", "false");
			jsob.put("message", "Your information is not corrected.");
				
			out.print(jsob);
			out.flush();	
			
		} else { // Pass case
			// Create user
			System.out.println("Pass");
			UserDao userDao = new UserDao();
			userDao.insertUsert(new User(userName, userEmail, userPassword));
			User user = userDao.getUser(1);
			
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
