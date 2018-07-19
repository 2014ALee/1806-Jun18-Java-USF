package com.revature.servlets;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.service.ErsService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("LoginServlet doPost called");
		int responseCode =0;
		ErsService eservice = new ErsService();
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
//		Scanner scan = new Scanner(req.getInputStream());
		String json ="";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		String[] credentials = mapper.readValue(json, String[].class);
		String username = credentials[0];
		String password = credentials[1];
		System.out.println("Values read");
		User temp = new User();
		System.out.println("Right before the if statement");
		System.out.println("Checkusername says: "+eservice.checkUsername(username)+"(Should be false)");
		if(!eservice.checkUsername(username)) {
			System.out.println("Checkusername says: "+eservice.checkUsername(username)+"(Should be false)");
			if(eservice.validLogin(username, password)) {
				temp = eservice.setUser(username, temp);
				System.out.println("role id: "+temp.getUserRoleId());
				if(temp.getUserRoleId() == 2) {
					responseCode = 2;
				}
				else {
					responseCode = 1;
				}
			}
			else {
				System.out.println("invalid password");
				temp = null;
			}
		}
		else {
			System.out.println("Temp confirmed null");
			temp = null;
		}
		HttpSession session = req.getSession();
		session.setAttribute("user", temp);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(responseCode);
		pw.write(userJSON);
		System.out.println("What's being sent back? It's this: "+userJSON);
		scan.close();
	}

}
