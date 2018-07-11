package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request received by Calclator.Servlet.doGet("
				+ "HttpServletRequest, HttpServletResponse)");
		RequestDispatcher rd = req.getRequestDispatcher("calculator.html");
		rd.forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request received by Calclator.Servlet.doPost("
				+ "HttpServletRequest, HttpServletResponse)");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("operation").toLowerCase();
		String answer = "";
		
		try {
			double operand1 = Double.parseDouble(n1);
			double operand2 = Double.parseDouble(n2);
			switch (op) {
			case "add":
				answer = "" + (operand1 + operand2);
			case "subtract":
				answer = "" + (operand1 - operand2);
			case "multiply":
				answer = "" + (operand1 * operand2);
			case "divide":
				answer = "" + (operand1 / operand2);
			default:
				answer = "" + (operand1 + operand2);
			}
			
			req.setAttribute("answer", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answer");
			rd.forward(req, resp);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("User submitted invalid operand");
		}
	}
}
