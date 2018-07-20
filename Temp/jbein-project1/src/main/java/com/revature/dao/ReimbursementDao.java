package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDao {
	public Reimbursement getReimbursementById(int reimb_id);
	public boolean addReimbursement(Reimbursement reimb);
	public boolean updateReimbursement(Reimbursement reimb);
	ArrayList<Reimbursement> getReimbursementsById(int userID);
	public ArrayList<Reimbursement> getReimbursementsByUserID(int ers_users_id);
	public ArrayList<Reimbursement> getReimbursementsByAuthor(int authorId);
	public ArrayList<Reimbursement> getAllReimbursements();
	public ArrayList<Reimbursement> getAllReimbursementsByStatus(int statusID);
	public boolean updateReimb(Reimbursement r);
	public boolean updateType(User user, Reimbursement reimb);

}
