package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.BankDaoServices;

@WebServlet("/showReimb")
public class PastReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");
		
		BankDaoServices bankService = new BankDaoServices();
		
		HttpSession session = req.getSession();
		Users currentUser = (Users) session.getAttribute("user");
		Reimbursement addReimb = new Reimbursement();
		
		ObjectMapper mapper = new ObjectMapper();
		
		 bankService.getUsersReimb(currentUser);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(currentUser);
		pw.write(userJSON);
	}

}