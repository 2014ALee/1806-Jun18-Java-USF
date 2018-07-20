package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.DenyTicketService;

@WebServlet("/deny")
public class DenyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DoPost");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
	    String userObject = "";
	    if(reader != null) {
		    userObject = reader.readLine();
	    }
	    System.out.println("On the Deny Ticket Servlet");
	    DenyTicketService.denyTicket(userObject, req.getSession());
	}
	
}
