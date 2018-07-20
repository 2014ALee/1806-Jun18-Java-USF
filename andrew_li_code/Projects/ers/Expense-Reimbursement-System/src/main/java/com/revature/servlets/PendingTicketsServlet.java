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
import com.revature.models.ERSUser;
import com.revature.models.UserRole;
import com.revature.service.GetPendingTickets;
import com.revature.util.SessionCheck;

@WebServlet("/pendingtickets")
public class PendingTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		ERSUser ersUser = SessionCheck.checkSession(session);
		if (ersUser == null) {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("application/json");
			pw.write("error:Not Logged In!!");
			return;
		}
		if (ersUser.getRole() == UserRole.REGULAR) {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("application/json");
			pw.write("error:Insufficient permission!");
		} else if (ersUser.getRole() == UserRole.FINANCE_MANAGER) {
			PrintWriter pw = resp.getWriter();
			resp.setContentType("application/json");
			pw.write((new ObjectMapper().writeValueAsString(GetPendingTickets.getPendingTickets())));
		}
	}

}
