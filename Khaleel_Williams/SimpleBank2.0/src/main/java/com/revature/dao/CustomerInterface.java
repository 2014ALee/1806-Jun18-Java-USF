package com.revature.dao;

import java.util.ArrayList;

import com.revature.model.Customers;

public interface CustomerInterface {
	
	public boolean addCustomer(Customers newCustomer);
	public Customers getCustomerByUsername(String username);
	public boolean updateBalance(Customers updatedCustomer);
	public ArrayList<Customers> getAllCustomers();
	
	
	//public boolean removeCustomer(Customers customerForRemoval);---implement maybe
	
}
