package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/createReim")
public class createReimbServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	 
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("got to createReimbServlet");
		ErsService ersService = new ErsService();
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = req.getSession();
		
		if(req.getInputStream() != null) {
			
			System.out.println("got to createReimbServlet if " + session.getAttribute("user"));
			Reimbursement reim = mapper.readValue(req.getInputStream(), Reimbursement.class);
			reim.setReimb_submitted(new java.sql.Date(new Date().getTime()));
			
			System.out.println(reim.getReimb_submitted());
			boolean created = ersService.createReimb(reim, (User) session.getAttribute("user"));
			System.out.println("got to createReimbServlet boolean = " + created);
		
			if (created) {
				PrintWriter pw = resp.getWriter();
				resp.setContentType("application/json");
				String reimJSON = mapper.writeValueAsString(reim);
				System.out.println("got to regServlet" + reimJSON);
				System.out.println("got to createReimServlet " + reimJSON);
				pw.write(reimJSON);
			}
		}
		
		
	}

}