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
import com.revature.models.EmployeeReimbursementSystem;
import com.revature.models.Reimbursement;
import com.revature.models.User;


@WebServlet("/updateReimb")
public class UpdateReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		EmployeeReimbursementSystem ERS = new EmployeeReimbursementSystem();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = "";
		if(br != null) {
			json = br.readLine();
		}

		System.out.println("OUR JSON STRING IS " + json);
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();

		// 3) Convert received JSON to String array
		String[] reimbInfo = mapper.readValue(json, String[].class);

		int reimbID = Integer.parseInt(reimbInfo[0]);
		int newTypeID = Integer.parseInt(reimbInfo[1]);
		
		//this persists the update
		ERS.updateReimb(reimbID, newTypeID);
				
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		//we write boolean of true or false
		String userJSON = mapper.writeValueAsString("placeholder");
		
		pw.write(userJSON);
	}
}
