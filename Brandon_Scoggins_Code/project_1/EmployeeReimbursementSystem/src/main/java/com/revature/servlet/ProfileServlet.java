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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ERSUser;
import com.revature.services.ERSService;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to RegisterServlet.doPost()");

		ERSService service = new ERSService();

		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";

		if (br != null) {	
			json = br.readLine();
		}

		// 2) Initiate the Jackson object mapper which will allow conversion to and from java objects to JSON
		ObjectMapper mapper = new ObjectMapper();

		// 3) Convert received JSON to String array 
		String[] userInfo = mapper.readValue(json, String[].class);
		String firstName = userInfo[0];
		String lastName = userInfo[1];
		String email = userInfo[2];
		String username = userInfo[3];
		String password = userInfo[4];
		String userRoleId = userInfo[5];

		HttpSession session = req.getSession();
		ERSUser sessionUser = (ERSUser) session.getAttribute("user");
		
		ERSUser temp = new ERSUser(sessionUser.getUserId(), username, password, firstName, lastName, email, Integer.parseInt(userRoleId));
		
		String[] success = service.updateUser(temp, sessionUser);

		if (Boolean.parseBoolean(success[0])) {
			System.out.println("[LOG] - New user created in ProfileServlet");
			session.setAttribute("user", temp);
		} else {
			System.out.println("[LOG] - User already exist (ProfileServlet)");
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(success);

		pw.write(userJSON);
	}
}
