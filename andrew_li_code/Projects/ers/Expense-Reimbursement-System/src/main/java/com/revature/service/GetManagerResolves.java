package com.revature.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.ERSReimbursementDAO;
import com.revature.dao.ERSReimbursementDAOImplementation;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;
import com.revature.util.JSONifier;

public class GetManagerResolves {

	public static String[] getResolves(ERSUser manager) {
		ERSReimbursementDAO reimbursementDAO = new ERSReimbursementDAOImplementation();
		ArrayList<ReimbursementRequest> personal = reimbursementDAO.getManagerResolves(manager);
		String[] requests = new String[personal.size()];
		for (int i = 0; i < requests.length; i++) {
			try {
				requests[i] = JSONifier.reimbursementToJSON(personal.get(i));
			} catch (JsonProcessingException e) {}
		}
		return requests;
	}
}
