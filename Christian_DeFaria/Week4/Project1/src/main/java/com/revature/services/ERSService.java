package com.revature.services;

import java.util.ArrayList;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class ERSService {
	
	static ReimbursementDAO reimbDao = new ReimbursementDAOImpl();
	static UserDAO userDao = new UserDAOImpl();
	
	public Users getUserByUsername(String username) {
		Users u = userDao.getUserByName(username);
		return u;
	}
	
	public Users getUserById(int id) {
		Users u = userDao.getUser(id);
		return u;
	}

	public boolean isEmailAvailable(String email) {
		Users u = userDao.getUserByEmail(email);
		if(u == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isUsernameAvailable(String username) {
		Users u = userDao.getUserByName(username);
		if(u == null) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Reimbursement> getReimbursements(Users sessionUser) {
		return reimbDao.getAllReimbByAuth(sessionUser);
	}

	public Users createNewUser(Users temp) {
		return userDao.addUser(temp);
	}
	
	public ArrayList<Reimbursement> getAllReimbursements() {
		return reimbDao.getAllReimbursements();
	}
	
	public Reimbursement getReimbursementById(int id) {
		return reimbDao.getReimb(id);
	}
	
	public boolean updateReimb(Reimbursement r) {
		return reimbDao.updateReimb(r);
		
	}
	
	public Reimbursement addReimb(Reimbursement r) {
		return reimbDao.addReimb(r);
	}

}
