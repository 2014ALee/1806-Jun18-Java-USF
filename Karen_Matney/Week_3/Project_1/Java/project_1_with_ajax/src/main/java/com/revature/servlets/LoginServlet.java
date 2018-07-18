package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		UserService userService = new UserService();

		if(req.getInputStream() != null) {
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(req.getInputStream(), String[].class);
		
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = userService.validateUser(username, password);
		
		if(temp != null) {
			temp.setPassword("****");
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		pw.write(mapper.writeValueAsString(temp));
		}
	}
}
