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

	/*
	 * Called when the servlet is created by the servlet container, so it is called once during the servlet
	 * lifecycle. This method can be sued to load properties or create necessary objects to be used by
	 * subsequent calls to this servlet.
	 */
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("HelloWorldServlet.init() called.");
	}
	
	/*
	 * Dispatches the request to the service method by converting the request and response objects into
	 * servlet objects.
	 * 
	 * An object of ServletRequest is used to provide the client information to a servlet, such as:
	 * content type, content length, parameter names and values, header information, attributes, etc..
	 * 
	 * an object of ServletResponse is used to assist a servlet in sending a response to the client. The
	 * servlet container creates a ServletResponse object and passes it as  an argument to the method.
	 */
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		System.out.println("HelloWorldServlet.service() called.");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>Hello, Servlets!</h1>");
	}
	/*
	 * Called when the servlet is destroyed by the servlet container, which is usually when the entire
	 * container is shutting down or when the servlet container is reloading the servlet context (when
	 * we make changes to the Java files while the server is running)
	*/
	
	@Override
	public void destroy() {
		System.out.println("HelloWorldServlet.destroy() called.");
	}

}
