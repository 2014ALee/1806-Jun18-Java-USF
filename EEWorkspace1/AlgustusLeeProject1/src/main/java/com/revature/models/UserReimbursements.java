package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;

public class UserReimbursements implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private User user;
	private ArrayList<Reimbursement> uReimbs;
	
	public UserReimbursements() {}

	public UserReimbursements(User user, ArrayList<Reimbursement> uReimbs) {
		super();
		this.user = user;
		this.uReimbs = uReimbs;
	}

	@Override
	public String toString() {
		return "UserReimbursements [user=" + user + ", uReimbs=" + uReimbs + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Reimbursement> getuReimbs() {
		return uReimbs;
	}

	public void setuReimbs(ArrayList<Reimbursement> uReimbs) {
		this.uReimbs = uReimbs;
	}
	
	
	
}
