package com.revature.models;

import com.revature.models.interfaces.UserRoleInterface;

public class UserRole implements UserRoleInterface{
	private int userRoleID;
	private String userRoleName;
	
	public UserRole(int userRoleID, String userRoleName) {
		this.userRoleID = userRoleID;
		this.userRoleName = userRoleName;
	}
	
	public UserRole() {
		
	}
	
	public boolean setUserRoleID(int id) {
		this.userRoleID = id;
		return true;
	}
	public boolean setUserRoleName(String role) {
		this.userRoleName = role;
		return true;
	}
	
	public int getUserRoleID() {
	return userRoleID;
	}
	
	public String getUserRoleName() {
		return userRoleName;
	}
	
	
	
	
}
