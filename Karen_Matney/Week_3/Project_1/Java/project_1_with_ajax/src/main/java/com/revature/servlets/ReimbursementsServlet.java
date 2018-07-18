package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;

@WebServlet("/getReimbursements")
public class ReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementService reimbursementService = new ReimbursementService();
		ArrayList<Reimbursement> allReimbursements = new ArrayList<>();
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("user");
		ObjectMapper mapper = new ObjectMapper();
		
		
		if(req.getInputStream() != null) {
			String version = mapper.readValue(req.getInputStream(), String.class);
			
			switch(version){
	 		case "pending":
	 			allReimbursements = reimbursementService.getReimbursementsByStatus(u, 1);
	 			break;
	 		case "approved":
	 			allReimbursements = reimbursementService.getReimbursementsByStatus(u, 2);
	 			break;
	 		case "denied":
	 			allReimbursements = reimbursementService.getReimbursementsByStatus(u, 3);
	 			break;
	 		default:
	 			allReimbursements = reimbursementService.getAllReimbursements(u);
	 			break;
	 		}
		} else {
			allReimbursements = reimbursementService.getAllReimbursements(u);
		}
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");
		
		pw.write(mapper.writeValueAsString(allReimbursements));
	}
}
