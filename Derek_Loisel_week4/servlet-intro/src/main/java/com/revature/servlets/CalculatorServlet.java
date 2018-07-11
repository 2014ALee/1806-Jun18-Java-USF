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

	//does 2 different things depending on if the http request was a get or a post

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		System.out.println("[LOG] - Request received by CalculatorServlet.doGet()");
		PrintWriter pw = resp.getWriter();

		//first we need to process request to get the page to them.  Not processing the input yet
		//could do pw.write and include link
		//or
		//going to dispatch our html file back to the client so it renders on their page.  can just include page file name as long as its nested in webapp folder
		RequestDispatcher rd = req.getRequestDispatcher("calculator.html"); 
		//now need to forward our request and response
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		System.out.println("[LOG] - Request received by CalculatorServlet.doPost()");
		//here we can get the info from the web page and do something with it
		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("operation");
		String answer = "";

		//can wrap in a try catch just incase there was bad input
		try {
			double operand1 = Double.parseDouble(n1);
			double operand2 = Double.parseDouble(n2);

			switch(op) {
			case "add":
				answer = "" + (operand1 + operand2);
				break;
			case "subtract":
				answer = "" + (operand1 - operand2);
				break;
			case "divide":
				answer = "" + (operand1 / operand2);
				break;
			case "multiply":
				answer = "" + (operand1 * operand2);
				break;
			default:
				answer = "" + (operand1 + operand2);							
			}
			
			System.out.println(answer);
			
			//call it answer and store the answer string you want to send 
			req.setAttribute("answer", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answer"); // this is the url path to the servlet (dont need to include the slash)
			rd.forward(req,  resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
