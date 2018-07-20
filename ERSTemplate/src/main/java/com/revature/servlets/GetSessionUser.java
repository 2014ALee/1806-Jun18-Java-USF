package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;


@WebServlet("/LoadUser")
public class GetSessionUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User sessionUser = (User) req.getSession().getAttribute("user");
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		// 3) Convert received JSON to String array

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		String userJSON = mapper.writeValueAsString(sessionUser);
		
		System.out.println("Our session user is " + userJSON);
		
		pw.write(userJSON);
	}
}