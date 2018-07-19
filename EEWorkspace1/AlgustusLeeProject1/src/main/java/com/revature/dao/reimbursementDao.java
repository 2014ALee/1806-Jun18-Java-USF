package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface reimbursementDao {
	Reimbursement newReimbursement(User u, Reimbursement r);
	void removeReimbursement(User u, Reimbursement r);
	ArrayList<Reimbursement> getReimbursements(User u);
	ArrayList<Reimbursement> getPastReimbursements(User u);
	void updateStatus(User u, long code, Reimbursement r);
	void updateType(User u, Reimbursement r);
	ArrayList<Reimbursement> getEditReimbursements(User u);
	ArrayList<Reimbursement> getAllReimbursements(User u);
}
