package com.revature.models;

public enum ReimbursementStatus {

	// Types
	PENDING(1), APPROVED(2), DENIED(3);
	// Definition
	private int id;
	public int getId() {
		return id;
	}	
	private ReimbursementStatus(int id) {
		this.id = id;
	}
}
