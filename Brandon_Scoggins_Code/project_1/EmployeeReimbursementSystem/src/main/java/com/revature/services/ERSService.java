package com.revature.services;

import java.util.ArrayList;

import com.revature.dao.ERSReimbursementDAOImpl;
import com.revature.dao.ERSReimbursementsDAO;
import com.revature.dao.ERSUsersDAO;
import com.revature.dao.ERSUsersDAOImpl;
import com.revature.models.ERSReimbursement;
import com.revature.models.ERSUser;

public class ERSService {

	ERSUsersDAO usersDao = new ERSUsersDAOImpl();
	ERSReimbursementsDAO reimDao = new ERSReimbursementDAOImpl();
	
	public ERSUser logInUser(String userNameOrEmail, String passWord) {
		return usersDao.logInUser(userNameOrEmail, passWord);
	}

	public String[] registerUser(ERSUser user) {
		return usersDao.createUser(user);
	}
	
	public String[] updateUser(ERSUser updatedUser, ERSUser currentUser) {
		return usersDao.updateUser(updatedUser, currentUser);
	}

	public ArrayList<ERSReimbursement> getUserReimbursements(ERSUser user) {
		return reimDao.getAllReimbursementsByUserId(user.getUserId());
	}

	public ArrayList<ERSReimbursement> getAllReimbursements() {
		return reimDao.getAllReimbursements();
	}

	public boolean createReimbursement(int userId, double reimAmount, String reimDesc, int reimType) {
		ERSReimbursement newReim = new ERSReimbursement(0, reimAmount, "", "", reimDesc, userId, 0, 1, reimType);
		return reimDao.createReimbursement(newReim);
	}
}
