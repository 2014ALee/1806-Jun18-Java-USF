package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestNavHelper;

@WebServlet("*.nav")
public class LoadNavServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] Request sent to front controller, LoadNavServlet"
				+ ".doGet(HttpServletRequest, HttpServletResponse)");
		
		String nextView = new RequestNavHelper().process(req, resp);
		System.out.println("Loading Navigation Servlet!!");
		req.getRequestDispatcher(nextView).forward(req, resp);
	}

}
