package com.revature;

import java.util.ArrayList;

import com.revature.dao.*;
import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;
import com.revature.service.LoginService;
import com.revature.util.BasicHelpers;

public class Tester {

	public static void main(String[] args) {
		System.out.println(BasicHelpers.hash("password"));
		ERSReimbursementDAO reimDAO = new ERSReimbursementDAOImplementation();
		ERSUserDAO usrDAO = new ERSUserDAOImplementation();
		System.out.println("Andrew/password: " + usrDAO.getERSUserByNameAndPassword("andrew", BasicHelpers.hash("password")));
		System.out.println("Andrew/Password: " + usrDAO.getERSUserByNameAndPassword("andrew", BasicHelpers.hash("Password")));
		ERSUser andrew = usrDAO.getERSUserByUsername("Andrew");
		System.out.println(andrew);
		System.out.println("Looking for pending requests (should be empty in the beginning...");
		for (ReimbursementRequest r : reimDAO.getPendingRequests()) {
			System.out.println(r);
		}
		System.out.println("Reimbursement ticket from Andrew.");
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		System.out.println("Reimbursement ticket from Andrew.");
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		System.out.println("Reimbursement ticket from Andrew.");
		reimDAO.makeRequest(andrew, 100000000, "Jewelery", 4);
		System.out.println("Looking for pending requests again (this time there should be three)...");
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
