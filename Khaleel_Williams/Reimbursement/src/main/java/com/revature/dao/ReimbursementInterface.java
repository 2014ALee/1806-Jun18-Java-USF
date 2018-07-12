package com.revature.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementInterface {
	
	//employee add reimbursement request
	public boolean addReimbursement(Reimbursement newReimb);
	
	//view past tickets
	public ArrayList<Reimbursement> getPastReimbById(int userId);
	
	//approve/deny reimbursement, add timestamp and resolver.
	public boolean update(Timestamp resolvedTimestamp, int resolverId, int statusId);
	
	//view all reimbursements for all employees
	public ArrayList<Reimbursement> getAllReimbursements();
	
	//filter requests by status
	public ArrayList<Reimbursement> filterReimbursements(int status);
}
