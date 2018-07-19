package com.revature;

import java.sql.Connection;
import java.util.ArrayList;

import com.revature.dao.ImplementReimbursement;
import com.revature.dao.ImplementUsers;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.util.MakeConnection;

public class ReimbursementDriver {
	

	public static void main(String[] args) {
		
		
		MakeConnection connectInst = MakeConnection.getConnectionInstance();
		Connection conn = connectInst.createConnection();
		
		System.out.println("ok");
		
//		Reimbursement user = new Reimbursement(9876, null, null, "not sure", null, 3, 1, 1, 3);
//		ImplementUsers use = new ImplementUsers();
//		ImplementReimbursement reimb = new ImplementReimbursement();
//		
//		//reimb.addReimbursement(user);
//		ArrayList<Reimbursement> r = new ArrayList<Reimbursement>();
//		
//		r = reimb.filterReimbursements(2);
//		for (Reimbursement i : r) {
//			System.out.println(i);
//		}
		//System.out.println(use.getUserByUsername("cry"));
	}

}
