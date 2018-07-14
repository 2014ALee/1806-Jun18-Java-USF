package com.revature.DAO;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbDao {

	//used by employee, shows all past
	public ArrayList<Reimbursement> getReimbursements(User newUser);
	
	//used by managers
	public ArrayList<Reimbursement> filterReimbByStatus(ArrayList<Reimbursement> reimbursements, String status);
	
	public boolean approveOrDenyReimb(Reimbursement newReimb, String approveOrDeny);
	
	public boolean addReimbursement(Reimbursement newReimb, User user);
	
	ArrayList<Reimbursement> getAllReimbursements();
	
}
