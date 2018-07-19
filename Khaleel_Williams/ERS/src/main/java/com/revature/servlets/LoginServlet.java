package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.BankDaoServices;
import com.revature.util.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
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
		
		String[] user = mapper.readValue(json, String[].class);
		String username = user[0];
		String password = user[1];
	
		
		CredentialsHelper checkC = new CredentialsHelper();
		
		Users temp = checkC.checkCredentials(username, password);
		
		if(temp == null) {
			System.out.println("LOG - username or password is incorrect");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		//System.out.println("userJSON = " + userJSON );
		pw.write(userJSON);
	}

	
}
