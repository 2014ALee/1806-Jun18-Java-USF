package com.revature.models.interfaces;

public interface ReimbursementStatusInterface {

	public boolean setStatusID(int id);
	public boolean setStatusName(String status);	
	
	public int getStatusID();
	public String getStatusName();	
	
}
