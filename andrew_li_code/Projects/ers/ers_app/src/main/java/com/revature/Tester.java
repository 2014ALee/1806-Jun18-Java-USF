package com.revature;

import java.util.ArrayList;

import com.revature.dao.*;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;

public class Tester {

	public static void main(String[] args) {
		ERSReimbursementDAO reimDAO = new ERSReimbursementDAOImplementation();
		ERSUserDAO usrDAO = new ERSUserDAOImplementation();
		ERSUser andrew = usrDAO.getERSUserByUsername("Andrew");
		System.out.println(andrew);
		System.out.println("Requests");
		for (ReimbursementRequest r : reimDAO.getPendingRequests()) {
			System.out.println(r);
		}
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		System.out.println("Check requests again.");
		ArrayList<ReimbursementRequest> pendings = reimDAO.getPendingRequests();
		for (ReimbursementRequest r : pendings) {
			System.out.println(r);
		}
		ERSUser wezley = usrDAO.getERSUserByUsername("Wezley");
		System.out.println(wezley);
		for (ReimbursementRequest r: pendings) {
			reimDAO.resolveRequest(wezley, false, r.getReimbursementId());
		}
		System.out.println("Andrew\'s requests!");
		for (ReimbursementRequest r : reimDAO.getEmployeeRequests(andrew)) {
			System.out.println(r);
		}
	}

}
