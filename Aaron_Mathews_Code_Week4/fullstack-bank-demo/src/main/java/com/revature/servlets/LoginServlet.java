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
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost();");
		
		BankService service = new BankService();
		
		//Get received json data from request
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if (br != null) {
			json = br.readLine();
		}
		
		//Initiate jackson object mapper. Will allow for conversion to and from java objects to json
		ObjectMapper mapper = new ObjectMapper();
		
		//Convert recieved json to string array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String pw = userInfo[1];
		
		User temp = (service.getUserByUsername(username).getId() != 0) ? service.getUserByUsername(username) : null;
		if (temp == null) {
			System.out.println("[LOG] - Variable 'temp' in LoginServlet is null");
		} else if (!temp.getPassword().equals(pw)) {
			temp.setId(0);
			temp.setFirstName(null);
			temp.setLastName(null);
			temp.setEmailAddress(null);
			temp.setPassword(null);
			temp.setUsername(null);
		} else {
			//Credentials are valid. Establish a session
			HttpSession session = req.getSession();
			session.setAttribute("user", temp); //Persists this user to the session
		}
		
		PrintWriter writer = res.getWriter();
		res.setContentType("applicatoin/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		writer.write(userJSON);
	}
	

}
