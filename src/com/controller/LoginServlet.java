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
import javax.servlet.http.HttpSession;

import com.dao.EncryptPassword;
import com.dao.RegistrationJdbc;
import com.model.Login;
import com.model.Registration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		EncryptPassword ep = new EncryptPassword();
		
		String email = request.getParameter("email");
		String password = ep.hashPassword(request.getParameter("password"));
		Login l = new Login();
		Registration r = new Registration(l);
		r.setEmail(email);;
		r.setPassword(password);
		
		
		List<Registration> lst = new ArrayList<Registration>();
		lst.add(r);
		
		RegistrationJdbc rj = new RegistrationJdbc();
		boolean b = rj.validateData(lst);
		
		if(b) {
				HttpSession session = request.getSession(true); // reuse existing
				// session if exist
				// or create one
				session.setAttribute("user", r.getEmail());
				response.sendRedirect("home.jsp");
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
			request.setAttribute("user", r.getEmail());
			request.setAttribute("message", "You have successfully logged in:)" );
			dispatcher.forward(request, response);*/
		}
		else {
			request.setAttribute("message", "Invalid login details -- Please retry");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("LoginErrorServlet");
			dispatcher1.forward(request, response);
		}
		
	}

}
