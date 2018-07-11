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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.BankService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LOG  Request sent to loginServlet.doPost()");
		
		BankService service = new BankService();
		
		// 1) Get received json data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		//2) initiate the jackson object mapper (allow for conversion to and from java objects to json)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received json to string array
		String[] userInfo = mapper.readValue(json,  String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = (service.getUserByUsername(username).getId() != 0 ? service.getUserByUsername(username) : null);
		
		if(temp == null) {
			System.out.println("LOG  variable 'temp' in loginServlet is null");
		}else if(!temp.getPassword().equals(password)) {
			temp.setId(0);
			temp.setFirstName(null);
			temp.setLastName(null);
			temp.setEmailAddress(null);
			temp.setUsername(null);
			temp.setPassword(null);
		}else {
			HttpSession session = req.getSession();
			
			session.setAttribute("user", temp);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userjson = mapper.writeValueAsString(temp);
		pw.write(userjson);
	}
}






















