package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Transfer;

public interface TransferDAO {
	
	// Create
	public boolean addTransfer(Transfer transfer);
	
	// Read
	public ArrayList<Transfer> getTransfersForUser(int id);
	public ArrayList<Transfer> getTransfersForAccount(int id);
	
}
