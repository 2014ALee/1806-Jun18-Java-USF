package com.revature.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.ERSReimbursementDAO;
import com.revature.dao.ERSReimbursementDAOImplementation;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;
import com.revature.util.JSONifier;

public class GetEmployeesRequests {
	public static String[] getPersonalRequests(ERSUser employee) {
		ERSReimbursementDAO reimbursementDAO = new ERSReimbursementDAOImplementation();
		ArrayList<ReimbursementRequest> personal = reimbursementDAO.getEmployeeRequests(employee);
		String[] requests = new String[personal.size()];
		for (int i = 0; i < requests.length; i++) {
			try {
				requests[i] = JSONifier.reimbursementToJSON(personal.get(i));
			} catch (JsonProcessingException e) {}
		}
		return requests;
	}
}
