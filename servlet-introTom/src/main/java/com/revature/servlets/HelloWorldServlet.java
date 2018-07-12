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

	//sends request to the service method by converting request and response objects into servlet objects
	// content length, type, length, param names and values, header info, attributes, etc
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("hello world service called");
		
		PrintWriter pw = res.getWriter();
		pw.println("<h1>Hello, servlets!</h1>");
		
	}
	
	public void destroy() {
		System.out.println("destroy was called");
	}
	
	
	//caled when servlet is created,so it is called once during the servlet lifecycle
	@Override
	public void init(ServletConfig config) {
		System.out.println("hello world init called");
		
	}
	

	
	
	
	
	
}
