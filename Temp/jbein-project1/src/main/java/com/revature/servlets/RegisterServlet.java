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
import com.revature.service.ErsService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to Register servlet");
		
		ErsService service = new ErsService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the JAXSON Object Mapper (This allows conversion between Java objects and JSON objects)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert from JSON to string array
		User temp = mapper.readValue(json, User.class);
		temp = service.createNewUser(temp);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
							
}

}
