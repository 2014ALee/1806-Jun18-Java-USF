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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.BankDaoServices;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");
		
		BankDaoServices service = new BankDaoServices();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		Users temp = new Users();
		String[] s = mapper.readValue(json, String[].class);
		
//		for (String d: s) {
//			System.out.println("user input info = " + d);
//		}
		
		temp.setFirstName(s[0]);
		temp.setLastName(s[1]);
		temp.setEmail(s[2]);
		temp.setUsername(s[3]);
		temp.setPassword(s[4]);
		temp.setRoleId(2);
		
		
		boolean bool = service.addUser(temp);
		System.out.println("bool = " + bool);
	
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(bool);
		pw.write(userJSON);
	}

}