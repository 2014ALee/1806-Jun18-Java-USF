package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	
	public ArrayList<Reimbursement> getAllReimbursements();
	public Reimbursement getReimbursementById(int ind);
	public Reimbursement getReimbursementByName(String name);
	
	public Reimbursement addReimbursement(Reimbursement newReimbursement);
	public boolean updateReimbursement(Reimbursement updatedReimbursement);
	public boolean removeReimbursementById(Reimbursement reimbursementForRemoval);
	public boolean removeReimbursementByName(String reimbursementName);

}
