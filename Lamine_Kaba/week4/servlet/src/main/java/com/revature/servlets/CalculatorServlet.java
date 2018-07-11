package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("[LOG) - Request received by CalculatorService.doGet()");
		PrintWriter pw = resp.getWriter();
		RequestDispatcher rd = req.getRequestDispatcher("calculator.html");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("[LOG) - Request received by CalculatorService.doPost()");
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("operation");
		String answer = "";
		
		try {
			double operand1 = Double.parseDouble(n1);
			double operand2 = Double.parseDouble(n2);
			
			switch(op) {
			case "add":
				answer = " " +(operand1 + operand2);
				break;
			case "subtract":
				answer =  " " +(operand1 - operand2);
				break;
			case "multiply":
				answer =  " " +(operand1 * operand2);
				break;
			case "divide":
				answer =  " " +(operand1 / operand2);
				break;
			default:
				answer =  " " +(operand1 + operand2);
			}
			
			req.setAttribute("answer", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answer");
			rd.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace( );
		}
	}


}
