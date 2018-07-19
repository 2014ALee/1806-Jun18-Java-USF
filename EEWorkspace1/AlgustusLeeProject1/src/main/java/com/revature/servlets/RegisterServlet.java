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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.ErsService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("Register servlet post method called");
		ErsService eservice = new ErsService();
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
		int returnCode = 0;
		String json = "";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		String fn = userInfo[0];
		String ln = userInfo[1];
		String un = userInfo[2];
		String pw = userInfo[3];
		String email = userInfo[4];
		if(eservice.checkUsername(un)) {
			if(eservice.checkEmail(email))
			{
				eservice.registerUser(un, pw, fn, ln, email);
			}
			else {
				System.out.println("Create user failure, email taken");
				returnCode = 2;
			}
		}
		else {
			System.out.println("Create user failure, username taken");
			returnCode = 1;
		}

		PrintWriter pw1 = res.getWriter();
		res.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(returnCode);
		pw1.write(userJSON);
		scan.close();
	}

}
