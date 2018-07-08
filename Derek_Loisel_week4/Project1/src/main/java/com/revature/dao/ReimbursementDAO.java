package com.revature.dao;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO {
	
	public Reimbursement addReimbursement(Reimbursement newReimbursement);
	
	public boolean updateReimbursementByReimbursementID(Reimbursement updatedReimbursement);
	
}
