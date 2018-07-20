package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.LoginService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    String userObject = "";
	    if(reader != null) {
		    userObject = reader.readLine();
	    }

	    String responseString = LoginService.login(userObject, req.getSession());
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		pw.write(responseString);
	    
	}
}
