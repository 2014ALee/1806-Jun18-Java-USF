package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestViewHelper;

@WebServlet("*.view")
public class LoadViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		System.out.println("LOG  reuest sent to fromt controller, loadViewServlet.doGet()");
		
		String nexView = new RequestViewHelper().process(req, resp);
		System.out.println(nexView);
		
		req.getRequestDispatcher(nexView).forward(req, resp);
	}
}
