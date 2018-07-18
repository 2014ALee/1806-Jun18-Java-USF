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
import com.revature.service.ErsService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to loginServlet ");
		
		ErsService service = new ErsService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the Jaxson object mapper (allow conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received json to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User currentUser = new User();
		currentUser.setErs_username(username);
		currentUser.setErs_password(password);
		
		//Create user with these credentials
		// check to see if the user exists then assign it to temp, otherwise just assign it null
		User temp = (service.getUserByUsername(currentUser).getErs_users_id() != 0) ? service.getUserByUsername(currentUser) : null;
		if(temp == null) {
			System.out.println("[LOG} - Variable 'temp' in LoginServlet is null");
			temp = null;
		} else if(!temp.getErs_password().equals(password)) {
			temp.setErs_users_id(0);
			temp.setUser_first_name(null);
			temp.setUser_last_name(null);
			temp.setUser_email(null);
			temp.setErs_username(null);
			temp.setErs_password(null);
		} else {
			System.out.println("Current User: " + temp.toString());    
			HttpSession session = req.getSession();
			session.setAttribute("user", temp); 		// persists this user to the session
			System.out.println("Session created");
		} 
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}
}
