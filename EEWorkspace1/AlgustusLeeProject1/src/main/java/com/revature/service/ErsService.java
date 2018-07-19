package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.reimbursementDao;
import com.revature.dao.reimbursementDaoImpl;
import com.revature.dao.usersDao;
import com.revature.dao.usersDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ErsService {
	static usersDao udao = new usersDaoImpl();
	static reimbursementDao rdao = new reimbursementDaoImpl();
	
	public boolean checkUsername(String u) {
		if(udao.checkForUser(u) == false) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean checkEmail(String e) {
		if(udao.checkForEmails(e)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean validLogin(String u, String p) {
		if(udao.login(u, p)) {
			return true;
		}
		else {
			return false;
		}
	}
	public User setUser(String u, User temp) {
		udao.setUser(u, temp);
		return temp;
	}
	public void registerUser(String un, String pw, String fn, String ln, String email) {
		udao.newUser(un, pw, fn, ln, email);
	}
	public void registerAdmin(String un, String pw, String fn, String ln, String email) {
		udao.newAdmin(un, pw, fn, ln, email);
	}
	public ArrayList<Reimbursement> getReimbursements(User u){
		ArrayList<Reimbursement> theList = rdao.getReimbursements(u);
		return theList;
	}
	public ArrayList<Reimbursement> getAllReimbursements(User u){
		ArrayList<Reimbursement> theWholeList = rdao.getAllReimbursements(u);
		return theWholeList;
	}
	public ArrayList<Reimbursement> getPastReimbursements(User u){
		ArrayList<Reimbursement> thePastList = rdao.getPastReimbursements(u);
		return thePastList;
	}
	public Reimbursement submitReimbursement(User u, Reimbursement temp) {
		temp = rdao.newReimbursement(u, temp);
		return temp;
		
	}
	public Reimbursement resolveReimbursement(User u, Reimbursement r, int code) {
		rdao.updateStatus(u, code, r);
		return r;
		
	}
	public ArrayList<Reimbursement> getEditReimbursements(User currentAdmin) {
		ArrayList<Reimbursement> theWholeList = rdao.getEditReimbursements(currentAdmin);
		return theWholeList;
	}

}
