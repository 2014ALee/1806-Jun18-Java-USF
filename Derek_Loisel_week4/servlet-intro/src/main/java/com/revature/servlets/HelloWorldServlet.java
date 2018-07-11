package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet{

	//this class is going to extend the generic servlet
		//doesnt have much besides init service and destroy
	
	
	private static final long serialVersionUID = 1L;

	//init is like nice little setup method for servlet, if theres any setup you need to do you can do it here, like load properties or create necessary objects to be used by subsequent calls to this servlet. usually you dont need to.  only called once during the servlet lifecycle.
	@Override
	public void init(ServletConfig config) {
		
		System.out.println("HelloWorldServlet.init() called");
		
	}
	
	
	//dispatches the request to the service method by converting the request and response objects into servlet objects
	//an object of ServletRequest is used to provide the client info to a servlet, such as: content type, content length, parameter names and values.  gives us an object to get info in
	//an object of servletResponse is used to assist a servlet in sending a response to the client.  The servlet container creates a ServletResponse object and passes it as an arguemnt to this method.  gives us an object to send back
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("HellowWorldServlet.service() called");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>hello, servlets!</h1>");
	}

	//called when the servlet is destroyed by the servlet container, which is usually when the entire container is shutting down or when the servlet container is reloading the servlet context (when we make changes to the java files while the server is running)
	@Override
	public void destroy() {
		
		System.out.println("HellowWorldServlet.destroy() called");
	}
}
