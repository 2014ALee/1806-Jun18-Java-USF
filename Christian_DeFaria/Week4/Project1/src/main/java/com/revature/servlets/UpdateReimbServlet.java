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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ERSService;

@WebServlet("*.update")
public class UpdateReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to LoginServlet.doPost()");
		
		ERSService service = new ERSService();
		
		// 1) Get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		
		String json = "";
		if(br != null) {
			json = br.readLine();
		}
		
		// 2) Initiate the Jackson object mapper (allow for conversion to and from Java objects to JSON)
		ObjectMapper mapper = new ObjectMapper();
		
		// 3) Convert received JSON to String array
		String[] userInfo = mapper.readValue(json, String[].class);
		String userId = userInfo[0];
		String reimbId = userInfo[1];
		
		Users u = service.getUserById(Integer.parseInt(userId));
		Reimbursement r = service.getReimbursementById(Integer.parseInt(reimbId));
		
		if(u == null) {
			System.out.println("[LOG] - Invalid user ID");
		} else if(r == null) {
			System.out.println("[LOG] - Invaild reimbursement ID");
		} else {
			switch(req.getRequestURI()) {
				case "/Project1/approve.update":
					r.setResolver(u.getUser_id());
					r.setResolved(Date.valueOf(LocalDate.now()));
					r.setStatus_id(3);
					service.updateReimb(r);
					break;
				case "/Project1/deny.update":
					r.setResolver(u.getUser_id());
					r.setResolved(Date.valueOf(LocalDate.now()));
					r.setStatus_id(2);
					service.updateReimb(r);
					break;
				default:
					System.out.println("[LOG] - Invalid .update path");
					return;
			}
		}
	}

}
