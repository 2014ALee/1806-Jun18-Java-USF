package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.util.LoadReimbsHelper;

@WebServlet("*.loadReimbs")
public class LoadReimbsServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("get Request in th reimbs servlet");
		Object reimbs = new LoadReimbsHelper().process(req, res);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(reimbs);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		pw.write(json);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("Somehow calling post");
		doGet(req, res);
	}

}
