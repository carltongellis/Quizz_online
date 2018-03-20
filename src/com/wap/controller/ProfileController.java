package com.wap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

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
 * Servlet implementation class Controller show profile
 * @author vynguyen
 * @date 2018-03-19
 */
@WebServlet(description = "Show profile page", urlPatterns = { "/Profile" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
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
		
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("email");
		String userNewPassword = request.getParameter("newPassword");
		String userConfirmNewPassword = request.getParameter("confirmNewPassword");
		
		// Regular expression
		String userEmailRegx = "^[a-zA-Z0-9._+%-]+@[a-zA-Z0-9.-]+.[a-z]{2,6}$";
		
		// Init JSON object
		JSONObject jsob = new JSONObject();
		jsob.put("result", "failed");
		LinkedList<String> failedMessage = new LinkedList<String>();
		
		// Get message if any field is not matched
		boolean isFailed = false;
		if (!userEmail.matches(userEmailRegx)) {
			failedMessage.add("User email is not matched.");
			isFailed = true;
		}
		
		if (userNewPassword.length() < 6) {
			failedMessage.add("User password is less than 6.");
			isFailed = true;
		}
		
		if (!userNewPassword.equals(userConfirmNewPassword)) {
			failedMessage.add("User new password is different with confirm new password.");
			isFailed = true;
		}
				
		// Check new password
		if (!isFailed) {
			UserDao ud = new UserDao();
			
			User us = ud.getUserByUsername(userName);
			us.setEmail(userEmail);
			us.setPassword(userNewPassword);
			
			// Update user
			ud.updateUser(us);
			
			// Go back to index page
			response.sendRedirect("index.jsp");
		} else {
			jsob.put("message", failedMessage);
			
			out.print(jsob);
			out.flush();	
			out.close();
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
