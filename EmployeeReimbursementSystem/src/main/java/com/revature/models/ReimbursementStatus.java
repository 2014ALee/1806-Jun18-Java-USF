package com.revature.models;

import com.revature.models.interfaces.ReimbursementStatusInterface;

public class ReimbursementStatus implements ReimbursementStatusInterface {

	private int statusID;
	private String statusName;
	
	
	public ReimbursementStatus(int statusID, String statusName) {
		this.statusID = statusID;
		this.statusName = statusName;
	}

	public boolean setStatusID(int id) {
		this.statusID = id;
		return true;
	}

	public boolean setStatusName(String status) {
		this.statusName = status;
		return true;
	}

	public int getStatusID() {
		return this.statusID;
	}

	public String getStatusName() {
		return this.statusName;
	}

}
