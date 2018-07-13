package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		UserService service = new UserService();
		
		// JSON
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = (service.validateUser(username, password).getUserId() != 0) ? service.validateUser(username, password) : null;
		
		if(temp == null) {
			System.out.println("[LOG] - temp null. Login servlet.");
		}
	}
}
