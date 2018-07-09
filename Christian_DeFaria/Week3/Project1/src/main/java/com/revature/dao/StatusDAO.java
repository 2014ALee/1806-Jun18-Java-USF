package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Status;

public interface StatusDAO {
	
	public Status getStatus(int id);
	public Status getStatus(String stat);
	public ArrayList<Status> getAllStatuses();

	public Status addStatus(Status s);
	
}
