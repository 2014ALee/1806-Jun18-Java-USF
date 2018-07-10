package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request Received by AnswerServlet.doGet()");
		PrintWriter pw = resp.getWriter();
		String answer = (String) req.getAttribute("answer");
		pw.write("<p>Our Answer is: " + answer + "</p>");
		pw.write("<br/><a href=\"calculator.html\">Calculate Again</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request Received by AnswerServlet.doPost()");
		doGet(req, resp);
	}

}
