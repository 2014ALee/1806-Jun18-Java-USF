package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestViewHelper;

//use this servlet so you dont need a servlet for every page to do every little thing
//any request that comes in with .view comes to this servlet
@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("[LOG] - Request sent to front controller, LoadViewServlet.doGet()");
		
		//create helper class to take some of the logic out of here (RequestViewHelper)
		
		String nextView = new RequestViewHelper().process(req, resp);
		System.out.println(nextView);
		
		req.getRequestDispatcher(nextView).forward(req, resp);
	}
}
