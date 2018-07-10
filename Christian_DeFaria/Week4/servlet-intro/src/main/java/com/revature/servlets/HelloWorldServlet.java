package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Called once during the servlet lifecycle, when created by the servlet container
	 */
	@Override
	public void init(ServletConfig config) {
		System.out.println("HelloWorldServlet.init called");
		
	}

	/*
	 * Dispatches the request to the service method by converting the request and response objects into 
	 * servlet objects.
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("HelloWorldServlet.service called");
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Hello, World!</h1>");
		
	}
	
	/*
	 * Called when the servlet is destroyed by the servlet container, which is usually when the entire
	 * container is shutting down or the servlet container is reloading the servlet context (when
	 * we make changes to the Java files while the server is running)
	 */
	@Override
	public void destroy() {
		System.out.println("HelloWorldServlet.destroy called");
		
	}

}
