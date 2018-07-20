package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.RegisterService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    String userObject = "";
	    if(reader != null) {
		    userObject = reader.readLine();
	    }

	    String responseString = RegisterService.register(userObject, req.getSession());
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(responseString);
	}
}
