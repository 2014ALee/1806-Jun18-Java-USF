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

//this does the equivalent of everything we did in the web.mxl from the first servlet intro demo
@WebServlet("/login")

//when user submits login we will process it here
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		BankService service = new BankService();
		
		//1. get received json data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		//2. initiate the jackson object mapper (allow for conversion to and from java objects to json)
		ObjectMapper mapper = new ObjectMapper();
		
		//3. convert received json to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
				User temp = new User();
				if(service.getUserByUsername(username).getId() == 0) {
					temp = service.getUserByUsername(username);
				}else {
					temp = null;
				}
				
				if(temp == null) {
					System.out.println("[LOG] - variable 'temp' in login servlet is null");
				}else if (!temp.getPassword().equals(password)) {
					temp.setId(0);
					temp.setFirstName(null);
					temp.setLastName(null);
					temp.setEmailAddress(null);
					temp.setUsername(null);
					temp.setPassword(null);					
				}else {
					//now that user has given us correct username and password, establish a session so the user object can be accessed for the whole login
					HttpSession session = req.getSession();
					session.setAttribute("user", temp);
				}
				
				PrintWriter pw = resp.getWriter();
				resp.setContentType("application/json");
				
				String userJSON = mapper.writeValueAsString(temp);
				pw.write(userJSON);
	}
}
