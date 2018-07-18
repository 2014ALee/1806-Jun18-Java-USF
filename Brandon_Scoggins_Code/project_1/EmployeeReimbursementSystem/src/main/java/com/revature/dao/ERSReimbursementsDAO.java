package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.ERSReimbursement;
import com.revature.models.ERSUser;

public interface ERSReimbursementsDAO {

	public boolean createReimbursement(ERSReimbursement newReim);
	
	public boolean cancelReimbursement(ERSReimbursement reimToCancel);
	
	public boolean approveReimbursement(ERSReimbursement approvedReim, ERSUser currentUser);
	
	public boolean denyReimbursement(ERSReimbursement deniedReim, ERSUser currentUser);
	
	public boolean viewReimbursement(ERSReimbursement viewedReim, ERSUser currentUser);
	
	public ERSReimbursement getReimbursementByReimId(int reimId);
	
	public ArrayList<ERSReimbursement> getAllReimbursements();
	
	public ArrayList<ERSReimbursement> getAllReimbursementsByStatus(String reimStatus);

	public ArrayList<ERSReimbursement> getAllReimbursementsByType(String reimType);

	public ArrayList<ERSReimbursement> getAllReimbursementsByUserId(int userId);

	public ArrayList<ERSReimbursement> getAllReimbursementsByUserNameOrEmail(String userNameOrEmail);

	public ArrayList<ERSReimbursement> getAllReimbursementsByRole(int roleId);
}
