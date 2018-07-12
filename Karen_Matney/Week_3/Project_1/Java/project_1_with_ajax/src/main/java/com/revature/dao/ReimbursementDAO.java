package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO {	
	public Reimbursement addRequest(Reimbursement reimb);
	
	public ArrayList<Reimbursement> viewAll(User u);
	
	// public ArrayList<Reimbursement> viewRequestsById(int uid);
	
	public ArrayList<Reimbursement> viewRequestsByStatus(int status);
	
	public Reimbursement saveRequest(Reimbursement reimb);
}
