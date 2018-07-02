package com.revature.dao;

import java.util.ArrayList;

import com.revature.models.Loan;

public interface LoanDAO {
	
	// Create
	public boolean addLoan(Loan loan);
	
	// Read
	public ArrayList<Loan> getAllLoans();
	public ArrayList<Loan> getLoansForUser(int id);
	
	// Update
	public boolean updateLoan(Loan loan);

}
