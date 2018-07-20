package com.revature.models;

public enum UserRole {
	// Types
	REGULAR(1), FINANCE_MANAGER(2);
	// Definition
	private int id;
	public int getId() {
		return id;
	}	
	private UserRole(int id) {
		this.id = id;
	}
}
