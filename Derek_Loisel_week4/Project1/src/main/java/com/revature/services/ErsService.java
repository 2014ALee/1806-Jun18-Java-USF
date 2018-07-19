package com.revature.services;

import java.util.ArrayList;
import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImpl;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ErsService {

	
	UserDAO userDAO = new UserDAOImpl();
	ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
	
	
	//userDAO
	public ArrayList<User> getAllUsers(){		
		ArrayList<User> userList = userDAO.getAllUsers();
		return userList;
	}
	
	public User getUserByUsername(String username) {
		User u = userDAO.getUserByUsername(username);
		return u;
	}
	
	public User getUserByUsernameCallable(String username) {
		User u = userDAO.getUserByUsernameCallable(username);
		return u;
	} 
	
	public User addUser(User newUser) {
		User u = userDAO.addUser(newUser);
		return u; 
	} 
	
	public boolean isUsernameAvailable(String username) {	
		ArrayList<User> userList = userDAO.getAllUsers();
		
		for (User u : userList) {
			if(u.getUsername().equalsIgnoreCase(username)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isEmailAvailable(String email) {	
		ArrayList<User> userList = userDAO.getAllUsers();
		
		for (User u : userList) {
			if(u.getEmail().equalsIgnoreCase(email)) {
				return false;
			}
		}
		return true;
	}
	
	//reimbursementDAO
	public ArrayList<Reimbursement> getAllReimbursements(){
		ArrayList<Reimbursement> reimbList = reimbursementDAO.getAllReimbursements();
		return reimbList;
	}
	
	public ArrayList<Reimbursement> getReimbursementsByStatusID(int statusID){
		ArrayList<Reimbursement> reimbList = reimbursementDAO.getReimbursementsByStatusID(statusID);
		return reimbList;
	}
	
	public ArrayList<Reimbursement> getReimbursementsByUserID(int userID){
		ArrayList<Reimbursement> reimbList = reimbursementDAO.getReimbursementsByUserID(userID);
		return reimbList;
	}
	
	public Reimbursement addReimbursement(Reimbursement newReimbursement) {
		Reimbursement r = reimbursementDAO.addReimbursement(newReimbursement);
		return r;
	}
	
	public boolean updateReimbursementByReimbursementID(Reimbursement updatedReimbursement) {
		boolean b = reimbursementDAO.updateReimbursementByReimbursementID(updatedReimbursement);
		return b;
	} 
	
	public boolean updateReimbursementsByAuthor(Reimbursement updatedReimbursement) {
		boolean b = reimbursementDAO.updateReimbursementsByAuthor(updatedReimbursement);
		return b;
	} 
	
	
}
