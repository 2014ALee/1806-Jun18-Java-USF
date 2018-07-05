package com.revature.models.interfaces;
import java.util.TreeMap;

import com.revature.models.BankAccount;
import com.revature.models.User;

public interface DatabaseBackUpInterface {

	public TreeMap<String, User> getUsers(); //called by the bank driver at start of application
	public boolean registerAccount(User newUser, BankAccount newAccount); //called by the currentUser in the driver
	public boolean setBalance(double newBalance, User currentUser, BankAccount currentAccount); //called by currentAccount when withdrawal or deposit
	//get balance can be done internally
	//we only use database operations when we are changing the state of our data
	public double adminViewTotalBalance(); //this will do a print statement to the console, only admin can do it
}
