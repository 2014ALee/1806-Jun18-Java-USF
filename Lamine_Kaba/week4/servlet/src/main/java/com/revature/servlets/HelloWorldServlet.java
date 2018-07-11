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
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("In HelloWorldServlet.init()");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("In HelloWorldServlet.service()");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hello, World</h1>");
		
	}
	
	@Override
	public void destroy() {
		System.out.println("In HelloWorldServlet.destroy()");
	}

}
