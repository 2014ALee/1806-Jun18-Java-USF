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

@WebServlet("/checkEmail")
public class CheckEmailServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		//System.out.println("Check Email servlet post method called");
		ErsService eservice = new ErsService();
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
		int returnCode = 0;
		String json = "";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		String email = userInfo[0];
		if(!eservice.checkEmail(email)) {
			returnCode = 1;
		}
		PrintWriter pw1 = res.getWriter();
		res.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(returnCode);
		pw1.write(userJSON);
		scan.close();
	}

}