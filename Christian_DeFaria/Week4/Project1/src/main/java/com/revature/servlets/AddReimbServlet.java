package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

@WebServlet("/add")
public class AddReimbServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - Request sent to AddReimbServlet.doPost()");
		
		ERSService service = new ERSService();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		
		if(br != null) {
			json = br.readLine();
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String[] userInfo = mapper.readValue(json, String[].class);
		String userId = userInfo[0];
		String amount = userInfo[1];
		String description = userInfo[2];
		String type_id = userInfo[3];
		Reimbursement r = new Reimbursement();
		Users u = service.getUserById(Integer.parseInt(userId));
		r.setAmount(Integer.parseInt(amount));
		r.setSubmitted(Date.valueOf(LocalDate.now()));
		r.setResolved(null);
		r.setDescription(description);
		r.setReceipt(null);
		r.setAuthor(u.getUser_id());
		r.setResolver(1);
		r.setStatus_id(1);
		r.setType_id(Integer.parseInt(type_id));
		r = service.addReimb(r);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		String userJSON = mapper.writeValueAsString(r);
		pw.write(userJSON);
	}

}
