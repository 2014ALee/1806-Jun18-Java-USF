package com.revature.models;

import com.revature.models.interfaces.ReimbursementTypeInterface;

public class ReimbursementType implements ReimbursementTypeInterface{

	public ReimbursementType(int typeID, String typeName) {
		this.typeID = typeID;
		this.typeName = typeName;
	}

	private int typeID;
	private String typeName;
	
	public boolean setTypeID(int id) {
		this.typeID = id;
		return true;
	}

	public boolean setTypeName(String status) {
		this.typeName = status;
		return true;
	}

	public int getTypeID() {
		return this.typeID;
	}

	public String getTypeName() {
		return this.typeName;
	}

}
