package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.Scanner;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ImplementReimbursement;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.BankDaoServices;
import com.revature.util.*;

@WebServlet("/reimb")
public class AddReimbServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		BankDaoServices bankService = new BankDaoServices();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		
		String[] reimb = mapper.readValue(json, String[].class);
		double amount = Double.parseDouble(reimb[0]);
		String description = reimb[1];
		String type = (reimb[2]);
	
		
		HttpSession session = req.getSession();
		Users currentUser = (Users) session.getAttribute("user");
		Reimbursement addReimb = new Reimbursement();
		
		
		addReimb.setAmount(amount);
		addReimb.setDescription(description);
		addReimb.setSubmitted(new Timestamp(System.currentTimeMillis()));
		System.out.println("userId = " + currentUser.getUserId());
		addReimb.setAuthor(currentUser.getUserId());
		addReimb.setStatusId(1);
		addReimb.setResolver(1);
		switch(type.toLowerCase()) {
		case "lodging":
			addReimb.setTypeId(1);
			break;
		case "travel":
			addReimb.setTypeId(2);
			break;
		case "food":
			addReimb.setTypeId(3);
			break;
		case "other":
			addReimb.setTypeId(4);
			break;
		default:
			System.out.println("Something went horribly wrong! seek help");
		}

		
		boolean check = bankService.addReimb(addReimb);
		int sendMe=0;
		if (check) {
			sendMe=1;
			System.out.println("sendMe = " + sendMe);
		} else {
			sendMe=2;
			System.out.println("sendMe = " + sendMe);
		}
		System.out.println("print added reimbursement" + reimb);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String Json = mapper.writeValueAsString(sendMe);
		//System.out.println("userJSON = " + userJSON );
		pw.write(Json);
	}

	
}
