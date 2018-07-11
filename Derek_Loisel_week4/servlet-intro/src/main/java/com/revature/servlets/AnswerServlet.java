package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		//get answer from calculator servlet so chain servlets together
		String answer = (String)req.getAttribute("answer"); //cast to the appropriate object like User or Reimbursement or whatever it is your sending
		//could bring to answer.html page but for shortness sake:
		pw.write("<p>Our answer is : " + answer + "</p>");
		pw.write("<br/><a href=\"calculator.html\">Calculate Again!</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//we get it here from the forward but we want to process it in doGet so we just call doGet
		//you could have the doGet code here to process it but for example sake you can do it this way
		doGet(req, resp);
	}
}
