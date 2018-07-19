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
		System.out.println("[LOG] - Request sent to front controller LoadViewServlet.doGet(), URI = " + req.getRequestURI());

		String nextView = " ";

		switch(req.getRequestURI()) {
		
		case "/ERS/login.view":
			nextView = "partials/login.html";
			break;

		case "/ERS/register.view":
			nextView = "partials/register.html";
			break;

		case "/ERS/home.view":
			nextView = "partials/home.html";
			break;
			
		case "/ERS/viewReimb.view":
			nextView = "partials/addReimb.html";
			break;

		default:
			nextView = null;
			System.out.println("in default");
		}
		System.out.println(nextView);
		
		req.getRequestDispatcher(nextView).forward(req, resp);

	}

}