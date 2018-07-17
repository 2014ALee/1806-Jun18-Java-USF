package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("[LOG] - Get request recieved");
		PrintWriter pw = res.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("calculator.html");
		rd.forward(req, res);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("[LOG] - Post request recieved");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("operation");
		String answer = "";
		
		try {
			double op1 = Double.parseDouble(n1);
			double op2 = Double.parseDouble(n2);
			
			switch(op) {
			case "add":
				answer = "" + (op1 + op2);
				break;
			case "subtract":
				answer = "" + (op1 - op2);
				break;
			case "multiply":
				answer = "" + (op1 * op2);
				break;
			case "divide":
				answer = "" + (op1 / op2);
				break;
			default:
				answer = "" + (op1 + op2);
			}
			
			req.setAttribute("answer", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answer");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
