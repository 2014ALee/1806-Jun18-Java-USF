package com.revature.DAOInterfaces;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbDao {

	//used by employee, shows all past
	public ArrayList<Reimbursement> getReimbursements(User newUser);
	
	//used by employee, add it to list in database, and add to the list
	public boolean addReimbursement (Reimbursement newReimb);
	
	//used by managers
	public ArrayList<Reimbursement> getAllReimbursements(User newUser);
	public ArrayList<Reimbursement> filterReimbByStatus(ArrayList<Reimbursement> reimbursements, String status);
	public boolean approveOrDenyReimb(Reimbursement newReimb, String approveOrDeny);
	
}
