package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationErrorServlet
 */
@WebServlet("/RegistrationErrorServlet")
public class RegistrationErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String message = (String) request.getAttribute("message");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3 style='color:red'>"+message+"</h3>");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login-signup.html");
		dispatcher.include(request, response);
	}

}
