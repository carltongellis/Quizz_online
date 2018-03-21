
package com.wap.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wap.dao.UserDao;
import com.wap.domain.User;

/**
 * Servlet implementation class Login Controller
 * @author vynguyen
 * @date 2018-03-18
 */
@WebServlet(description = "Login controller", urlPatterns = { "/Login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * Added By Carlton Retrieve use and validate password
		 */
		HttpSession session = null;
		UserDao userDao = new UserDao();
		User user = userDao.getUserByUsername(request.getParameter("username"));

		// validate user
		if (user != null && user.getPassword().equals(request.getParameter("password"))) {
			session = request.getSession(true);
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(86400); // 2 days

			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("error",
					"Your username or password was incorrect, enter correct credentials and try again!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
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
