package com.revature.servlets;

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
	
	/*
	 * (non-Javadoc) Called when the servlet is created by the servlet container, 
	 * so it is called once during the servlet lifecycle. This mothod can be used to laod
	 * properties or create necessary objects to be used by subsequent calls to this servlet.
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) {
		System.out.println("HelloWorldServlet.init() called");
	}

	/*
	 * Dispatches the request to the service method by converting the reuqest and response objects into
	 * serverlet objects.
	 * 
	 * An object of ServetRequest is used to provide the client informatoin to a servlet, such as:
	 * content type, content length, parameter names and values, header information, attributes, etc.
	 * 
	 *  An object of ServletResponse is used to assist a servlet in sending a response to the client.
	 *  The servlet container creates a ServletResponse object and passes it as an argument to this method.
	 * @see javax.servlet.GenericServlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloWorldServlet.service() called");
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hello, Servlets!</h1>");
		
	}

	/*
	 * Called when the servlet is destroyed by the servlet container, which is usually when the entire
	 * container is shitting down or when the servlet container is reloading the servlet context
	 * (when we make changes to the Java files while the server is running)
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("HelloWorldServlet.destroy() called");
	}
	
}
