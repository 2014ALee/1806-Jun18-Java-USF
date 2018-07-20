package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[Log] - Request sent to controller, LoadInfoServlet.doGet(HttpServletRequest, "
				+ "HttpServletResponse)");
		Object info = new LoadInfoHelper().process(req, resp);
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(info);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(json);
	}
}
