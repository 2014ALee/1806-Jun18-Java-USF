package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) {
		System.out.println("Called HelloWorldServlet.init()");
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Called HelloWorldServlet.service()");
		PrintWriter pw = res.getWriter();
		pw.println("<h1>o hai</h1>");
		
	}
	
	@Override
	public void destroy() {
		
	}

}
