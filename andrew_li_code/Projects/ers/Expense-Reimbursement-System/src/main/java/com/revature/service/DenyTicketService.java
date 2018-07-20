package com.revature.service;

import javax.servlet.http.HttpSession;

import com.revature.dao.ERSReimbursementDAO;
import com.revature.dao.ERSReimbursementDAOImplementation;
import com.revature.models.ERSUser;
import com.revature.models.UserRole;
import com.revature.util.SessionCheck;

public class DenyTicketService {
	public static void denyTicket(String ticketId, HttpSession session) {
		int ticketID = 0;
		try {
			ticketID = Integer.parseInt(ticketId.trim());
		} catch (NumberFormatException e) {
			return;
		}
		ERSUser ersUser = SessionCheck.checkSession(session);
		if (ersUser == null) {
			return;
		}
		if (ersUser.getRole() != UserRole.FINANCE_MANAGER) {
			return;
		}
		ERSReimbursementDAO ersDAO = new ERSReimbursementDAOImplementation();
		ersDAO.resolveRequest(ersUser, false, ticketID);
	}
}
