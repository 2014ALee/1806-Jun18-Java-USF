package com.revature.models;

import java.util.ArrayList;

import com.revature.models.interfaces.UserInterface;

public class User implements UserInterface {

	private int userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	//this is where they see all past tickets
	private ArrayList<Reimbursement> ReimbList = new ArrayList<>();
	
	public User(String userName, String password, String firstName,
			String lastName, String email, UserRole role) {
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public User() {
		
	}
	
	public boolean setUserID(int userID) {
		return true;
	}

	public boolean setUserName(String userName) {
		this.userName = userName;
		return true;
	}

	public boolean setPassword(String password) {
		this.password = password;
		return true;
	}

	public boolean setFirstName(String firstName) {
		this.firstName = firstName;
		return true;
	}

	public boolean setLastName(String lastName) {
		this.lastName = lastName;
		return true;
	}

	public boolean setEmailName(String email) {
		this.email = email;
		return true;
	}

	public boolean setUserRole(UserRole role) {
		this.role = role;
		return true;
	}

	public int getUserID() {		
		return this.userID;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmailName() {
		return this.email;
	}

	public UserRole getUserRole() {
		return this.role;
	}

}
