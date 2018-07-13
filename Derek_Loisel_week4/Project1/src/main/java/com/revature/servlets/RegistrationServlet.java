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
import com.revature.models.User;
import com.revature.services.ErsService;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to RegistrationServlet.doPost()");
		
		ErsService service = new ErsService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		User temp = mapper.readValue(json, User.class);
		
		//here call service methods to check username and email availability
		boolean userAvail = service.isUsernameAvailable(temp.getUsername());
		boolean emailAvail = service.isEmailAvailable(temp.getEmail());
		
		//if statement here to either add user or set temp as null
		if(userAvail && emailAvail) {
			//add user to database
			temp = service.addUser(temp);
		}else {
			temp.setUserID(0);
			temp.setFirstname(null);
			temp.setLastname(null);
			temp.setEmail(null);
			temp.setUsername(null);
			temp.setPassword(null);
			temp.setUserRoleID(0);
		}
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}