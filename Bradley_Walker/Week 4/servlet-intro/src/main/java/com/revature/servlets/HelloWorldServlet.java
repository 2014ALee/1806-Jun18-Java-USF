package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	// Called when the servlet is created by the web container.
	@Override
	public void init(ServletConfig config) {
		System.out.println("Ahhhh the beauty of life!");
	}

	// This method is called whenever a request is sent to the servlet.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("I hear ya bro");
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Hello, Servlets!</h1>(and world)");
	}

	// Called when the servlet is destroyed.
	@Override
	public void destroy() {
		System.out.println("NOOOOOOOOOOOOOOOO!!!!!! O GOD WHY?!?!?!?!?!?!?!?!? YOU HEARTLESS BASTARD!!!!");
	}

}
