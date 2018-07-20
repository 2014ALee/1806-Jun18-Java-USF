package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;

public interface ERSReimbursementDAO {
	public abstract void makeRequest(ERSUser employee, int amount, String description, int type);
	public abstract boolean resolveRequest(ERSUser manager, boolean approve, int reimbursementId);
	public abstract ArrayList<ReimbursementRequest> getPendingRequests();
	public abstract ArrayList<ReimbursementRequest> getEmployeeRequests(ERSUser employee);
	public abstract ArrayList<ReimbursementRequest> getManagerResolves(ERSUser manager);
}
