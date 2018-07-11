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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");

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
		String userNameOrEmail = userInfo[0];
		String passWord = userInfo[1];

		ERSUser temp = new ERSUser();
		
		temp = service.logInUser(userNameOrEmail, passWord);

		if (temp.equals(new ERSUser())) {
			System.out.println("[LOG] - Variable 'temp' in loginServlet did not exist in database");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);		// persist this user to the session
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(temp);

		pw.write(userJSON);
	}
}
