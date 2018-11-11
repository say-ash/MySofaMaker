package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationJdbc;

/**
 * Servlet implementation class uploadProductServlet
 */
@WebServlet("/uploadProductServlet")
public class uploadProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RegistrationJdbc rj = new RegistrationJdbc();
		String type = request.getParameter("type");
		String file = request.getParameter("file");
		int i = rj.saveProduct(type,file);
		if(i>0) {
			out.println("Successfully inserted");
		}
		else {
			out.print("not inserted..");
		}
	}

}
