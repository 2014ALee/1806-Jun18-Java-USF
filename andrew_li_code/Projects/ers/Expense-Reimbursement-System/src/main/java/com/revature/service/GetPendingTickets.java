package com.revature.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.ERSReimbursementDAO;
import com.revature.dao.ERSReimbursementDAOImplementation;
import com.revature.models.ReimbursementRequest;
import com.revature.util.JSONifier;

public class GetPendingTickets {
	public static String[] getPendingTickets() {
		ERSReimbursementDAO reimbursementDAO = new ERSReimbursementDAOImplementation();
		ArrayList<ReimbursementRequest> pending = reimbursementDAO.getPendingRequests();
		String[] requests = new String[pending.size()];
		for (int i = 0; i < requests.length; i++) {
			try {
				requests[i] = JSONifier.reimbursementToJSON(pending.get(i));
			} catch (JsonProcessingException e) {}
		}
		return requests;
	}

}
