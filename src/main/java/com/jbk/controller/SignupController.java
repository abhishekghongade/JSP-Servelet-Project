package com.jbk.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jbk.service.Service;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/signuppage")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("username1");
		String pass = request.getParameter("password1");
		String cpass = request.getParameter("confirmpass");
		String email = request.getParameter("email");
		String fname = request.getParameter("fullname");

		

		Service service = new Service();
		int isInserted = 0;
		if (pass.equals(cpass)) {
			 isInserted = service.insertInfo(uname, pass, cpass,email,fname);
		}

		if (isInserted == 1 && pass.equals(cpass)) {
			request.setAttribute("inserted", "Signup Successful...!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("msg1", "Password and Confirm password doesnt match");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
