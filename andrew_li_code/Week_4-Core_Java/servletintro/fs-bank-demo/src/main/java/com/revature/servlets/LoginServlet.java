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
import com.revature.models.User;
import com.revature.services.BankService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		
		BankService service = new BankService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if (br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects ot JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		String[] userInfo = mapper.readValue(json,  String[].class);
		String username = userInfo[0];
		String password = userInfo[1];
		
		User temp = (service.getUserByUsername(username).getId() != 0) ? service.getUserByUsername(username) : null;
		
		if (temp == null) {
			System.out.println();
		} else if (!temp.getPassword().equals(password)) {
			temp.setId(0);
			temp.setFirstName(null);
			temp.setLastName(null);
			temp.setEmailAddress(null);
			temp.setUsername(null);
			temp.setPassword(null);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", temp);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(temp);
		pw.write(userJSON);
	}

}
