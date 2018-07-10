package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.Users;

public interface ReimbursementDAO {
	
	public Reimbursement getReimb(int id);
	public ArrayList<Reimbursement> getAllReimbByAuth(Users u);
	public ArrayList<Reimbursement> getAllReimbByRslvr(Users u);
	public ArrayList<Reimbursement> getAllReimbursements();
	public ArrayList<Reimbursement> getReimbsByStatus(int stat);
	
	public Reimbursement addReimb(Reimbursement r);
	public Reimbursement updateReimb(Reimbursement r);

}
