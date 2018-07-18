package com.revature.dao;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	public Reimbursement getReimbursement(int reimb_id);
	public Reimbursement addReimbursement(Reimbursement reimb);
	public Reimbursement updateReimbursement(Reimbursement reimb);

}
