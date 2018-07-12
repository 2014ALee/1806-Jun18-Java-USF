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
	private String roleName;
	private int roleID;

	//this is where they see all past tickets
	private ArrayList<Reimbursement> ReimbList = new ArrayList<>();
	
	public User(String userName, String password, String firstName,
			String lastName, String email, String roleName) {
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleName = roleName;
		this.roleID = roleID;
	}

	public User() {
		
	}
	
	public boolean setUserID(int userID) {
		this.userID = userID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public ArrayList<Reimbursement> getReimbList() {
		return ReimbList;
	}

	public void setReimbList(ArrayList<Reimbursement> reimbList) {
		ReimbList = reimbList;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", roleName=" + roleName + ", roleID="
				+ roleID + ", ReimbList=" + ReimbList + "]";
	}


	
}
