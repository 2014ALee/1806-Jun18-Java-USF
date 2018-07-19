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
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.service.ErsService;

@WebServlet("/newReimb")
public class NewReimbursementServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("New Reimbursement Servlet Called");
		ErsService eservice = new ErsService();
		HttpSession session = req.getSession();
		Reimbursement temp = new Reimbursement();
		User u = (User)session.getAttribute("user");
		Scanner scan = new Scanner(new InputStreamReader(req.getInputStream()));
		int returnCode = 0;
		String json = "";
		if(scan != null) {
			json = scan.nextLine();
		}
		ObjectMapper mapper = new ObjectMapper();
		String[] reimbInfo = mapper.readValue(json, String[].class);
		String amountBase = reimbInfo[0];
		String desc = reimbInfo[1];
		String typeBase = reimbInfo[2];
		long type = 0;
		double amount = Double.parseDouble(amountBase);
		switch(typeBase) {
		case "Lodging":
			type = 1;
			break;
		case "Travel":
			type = 2;
			break;
		case "Food":
			type = 3;
			break;
		case "Other":
			type = 4;
			break;
		default:
			returnCode = 1;
			System.out.println("Error in newReimbursement");
		}
		System.out.println("Type Id: "+type);
		temp.setAmount(amount);
		temp.setDescription(desc);
		temp.setTypeId(type);
		
		if(returnCode == 0) {
			eservice.submitReimbursement(u, temp);
		}
		System.out.println("Return code for new reimbursement: "+returnCode);
		
		PrintWriter pw1 = res.getWriter();
		res.setContentType("application/json");
		String userJSON = mapper.writeValueAsString(returnCode);
		pw1.write(userJSON);
		scan.close();
	}

}
