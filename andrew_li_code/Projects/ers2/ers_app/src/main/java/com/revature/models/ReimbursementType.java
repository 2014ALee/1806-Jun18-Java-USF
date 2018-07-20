package com.revature.models;

public enum ReimbursementType {
	// Types
	LODGING(1), TRAVEL(2), FOOD(3), OTHER(4);
	// Definition
	private int id;
	public int getId() {
		return id;
	}	
	private ReimbursementType(int id) {
		this.id = id;
	}

}
