package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/updaterequest")
public class updateRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[LOG] - request sent to doPost updateRequestServlet");
		ReimbursementService reimbService = new ReimbursementService();
		User u;
		HttpSession session = req.getSession();
		Reimbursement temp = new Reimbursement();
		ObjectMapper mapper = new ObjectMapper();

		u = (User) session.getAttribute("user");

		if(req.getInputStream() != null) {
			Object[] values = mapper.readValue(req.getInputStream(), Object[].class);
			
			temp = reimbService.updateRequest(values, u);
		}

		PrintWriter pw = resp.getWriter();
		resp.setContentType("application/json");

		pw.write(mapper.writeValueAsString(temp));
	}
}
