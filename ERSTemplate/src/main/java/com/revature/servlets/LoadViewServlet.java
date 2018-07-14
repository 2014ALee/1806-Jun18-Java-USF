package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to front controller, LoadViewServlet.doGet()");
		
		String nextView = processRequest(req);
		
		System.out.println(nextView+ " THIS IS OUR VIEW");
		System.out.println(req.getRequestURI());
		
		req.getRequestDispatcher(nextView).forward(req, resp);
		
	}
	
	public String processRequest(HttpServletRequest req) {
		System.out.println("[LOG] - Processing request with RequestViewHelper.process(): " + req.getRequestURI());
		String partial = choosePartial(req.getRequestURI());
		
		return partial;
	}

	public String choosePartial(String requestURI) {
		if(requestURI == "/ERSTemplate/Login.view") {	
			return "partials/Login.html";
	} else {
			return null;
		}	
	}

}
