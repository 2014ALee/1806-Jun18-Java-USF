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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User temp;
		UserService userService = new UserService();

		if(req.getInputStream() != null) {
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(req.getInputStream(), String[].class);
		
		if(userInfo.length == 5) {
			temp = userService.addUser(userInfo);

			if(temp != null) {
				temp.setPassword("****");
				HttpSession session = req.getSession();
				session.setAttribute("user", temp);
			}
		} else {
			temp = null;
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		pw.write(mapper.writeValueAsString(temp));
		}
	}
}
