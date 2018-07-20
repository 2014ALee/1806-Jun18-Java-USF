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
	
	public boolean updateReimCase(int reimId, int reimStatusId, ERSUser currentUser) {
		
		if (reimStatusId == 2 && reimDao.getReimbursementByReimId(reimId).getReimStatusId() != 1) {
			return false;
		} else if (reimDao.getReimbursementByReimId(reimId).getReimStatusId() == reimStatusId) {
			return false;
		} else {
			switch(reimStatusId) {
			case 2:
				return reimDao.viewReimbursement(reimDao.getReimbursementByReimId(reimId), currentUser);
			case 3:
				return reimDao.approveReimbursement(reimDao.getReimbursementByReimId(reimId), currentUser);
			case 4:
				return reimDao.denyReimbursement(reimDao.getReimbursementByReimId(reimId), currentUser);
//			case 5:
//				return reimDao.cancelReimbursement(reimDao.getReimbursementByReimId(reimId), currentUser);
			default:
				return false;
			}
		}
	}
}
