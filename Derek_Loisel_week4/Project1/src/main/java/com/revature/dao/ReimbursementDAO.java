package com.revature.dao;

import java.util.ArrayList;
import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public ArrayList<Reimbursement> getAllReimbursements();
	
	public ArrayList<Reimbursement> getReimbursementsByStatusID(int statusID);
	
	public ArrayList<Reimbursement> getReimbursementsByUserID(int userID);
	
	public Reimbursement addReimbursement(Reimbursement newReimbursement);
	
	public boolean updateReimbursementByReimbursementID(Reimbursement updatedReimbursement);
	
	//public ArrayList<Reimbursement> getReimbursementsByType();
}
