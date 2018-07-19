package com.revature.services;

import java.util.ArrayList;

import com.revature.dao.ImplementReimbursement;
import com.revature.dao.ImplementUsers;
import com.revature.models.Reimbursement;
import com.revature.models.Users;

public class BankDaoServices {

	public Users getUserByUsername(String username) {
		
		ImplementUsers daoUser = new ImplementUsers(); 
		
		return daoUser.getUserByUsername(username);
	}
	
	public boolean addUser(Users newUser) {
		ImplementUsers daoUser = new ImplementUsers(); 
		System.out.println("inside of bankdaoservice adduser method");
		return daoUser.addUser(newUser);
	}
	
	public boolean addReimb(Reimbursement reimb) {
		ImplementReimbursement add = new ImplementReimbursement();
		
		return add.addReimbursement(reimb);
	}

	public Users getUsersReimb(Users user) {
		ImplementReimbursement all = new ImplementReimbursement();
		ArrayList<Reimbursement> array = new ArrayList<Reimbursement>();
		
		array = all.getPastReimbById(user.getUserId());
		user.setMyReimb(array);
		
		return user;
	}
}
