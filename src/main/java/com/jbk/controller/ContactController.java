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
 * Servlet implementation class ContactController
 */
@WebServlet("/contactpage")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fname = request.getParameter("FirstName");
		String lname = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String phone = request.getParameter("PhoneNumber");
		String msg = request.getParameter("text");

		Service service = new Service();
		int check = service.insertCustDetails(fname, lname, email, phone, msg);
		
		if(check==1) {
			
			RequestDispatcher rd= request.getRequestDispatcher("contact.jsp");
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
