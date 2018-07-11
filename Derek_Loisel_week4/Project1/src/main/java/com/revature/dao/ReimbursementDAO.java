package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO {
	
	public ArrayList<User> getAllReimbursements();
	
	public ArrayList<Reimbursement> getReimbursementsByStatusID(int statusID);
	
	public ArrayList<Reimbursement> getReimbursementsByUserID(int userID);
	
	public Reimbursement addReimbursement(Reimbursement newReimbursement);
	
	public boolean updateReimbursementByReimbursementID(Reimbursement updatedReimbursement);
	
	//public ArrayList<Reimbursement> getReimbursementsByType();
}
