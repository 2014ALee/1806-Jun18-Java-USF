package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		String answer = (String) req.getAttribute("answer");
		pw.write("<p>the answer is: "+answer+"</p>");
		pw.write("<br> <a href=\"calculator.html\"> Calculate again! </a>");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res); //NOTE: THE THINGS THAT THE SERVELT SENDS BACK GOES HERE!
	}
}
