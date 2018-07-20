package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserReimbursements;
import com.revature.service.ErsService;

@WebServlet("/update")
public class UpdateReimbursementServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("[LOG] - Request sent to loginServlet ");
		
		ErsService service = new ErsService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		System.out.println("json object" + json);
		
		// 2) Initiate the Jaxson object mapper (allow conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received json to String array
		Reimbursement currentReimb = mapper.readValue(json, Reimbursement.class);
		
		HttpSession session = req.getSession();
		User sessionUser = (User) session.getAttribute("user");
		
		Reimbursement reimb = service.getReimbursementById(currentReimb.getReimb_id());
		reimb.setReimb_status_id(currentReimb.getReimb_status_id());
		
		service.updateType(sessionUser, reimb);
	}
}