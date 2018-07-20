package com.revature.servlet;

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
import com.revature.models.ERSUser;
import com.revature.services.ERSService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		System.out.println("[LOG] - Request sent to RegisterServlet.doPost()");

		ERSService service = new ERSService();

		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";

		if (br != null) {	
			json = br.readLine();
		}

		ObjectMapper mapper = new ObjectMapper();

		String[] userInfo = mapper.readValue(json, String[].class);
		String firstName = userInfo[0];
		String lastName = userInfo[1];
		String email = userInfo[2];
		String username = userInfo[3];
		String password = userInfo[4];
		String userRoleId = userInfo[5];

		ERSUser temp = new ERSUser(0, username, password, firstName, lastName, email, Integer.parseInt(userRoleId));
		
		String[] success = service.registerUser(temp);

//		if (Boolean.parseBoolean(success[0])) {
//			System.out.println("[LOG] - New user created in RegisterServlet");
//		} else {
//			System.out.println("[LOG] - User already exist (RegisterServlet)");
//		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(success);

		pw.write(userJSON);
	}
}
