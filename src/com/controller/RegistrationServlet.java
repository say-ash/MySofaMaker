package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EncryptPassword;
import com.dao.RegistrationJdbc;
import com.model.Login;
import com.model.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EncryptPassword ep = new EncryptPassword();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = ep.hashPassword(request.getParameter("password"));
		long contact_no = Long.parseLong(request.getParameter("contact_no"));
		
		Login l = new Login();
		Registration r = new Registration(l);
		
		r.setEmail(email);
		r.setFirstname(firstname);
		r.setLastname(lastname);
		r.setPassword(password);
		r.setContact_no(contact_no);

		List<Registration> lst = new ArrayList<Registration>();
		lst.add(r);
		
		RegistrationJdbc rj = new RegistrationJdbc();
		int i = rj.saveData(lst);
		if(i>0) {
			
			out.write("<script language='javascript'>window.alert('You have successfully registered yourself -- Login to continue');window.location='login-signup.html';</script>");
			
			/*response.sendRedirect("Login.jsp");*/
			
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
			request.setAttribute("user", username);
			request.setAttribute("message", "You have successfully registered yourself and we have made you login here..." );
			dispatcher.forward(request, response);*/
		}
		else {
			
			request.setAttribute("message", "Data not inserted for some reason -- Please try again");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("RegistrationErrorServlet");
			dispatcher1.forward(request, response);
		}

	}

}
