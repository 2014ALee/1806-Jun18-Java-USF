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
import com.revature.models.Users;
import com.revature.services.ERSService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		ERSService service = new ERSService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		Users temp = service.getUserByUsername(username);
		
		if(temp == null) {
			System.out.println("[LOG] - Variable 'temp' in LoginServlet is null");
			resp.sendRedirect("/Project1/");
			return;
		} else if(!temp.getPassword().equals(password)) {
			temp.setUser_id(0);
			temp.setFirstname(null);
			temp.setLastname(null);
			temp.setEmail(null);
			temp.setUsername(null);
			temp.setPassword(null);
			resp.sendRedirect("/Project1/");
			return;
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp); // persists this user to the session
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		System.out.println(mapper.writeValueAsString(temp));
		pw.write(userJSON);
	}

}
