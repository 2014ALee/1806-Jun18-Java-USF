package com.revature.models;

import java.io.Serializable;

import com.revature.models.interfaces.UserInterface;

public class User implements UserInterface, Serializable{

	private static final long serialVersionUID = 1L;
	private BankAccount bankAccount;
	private String firstName;
	private String lastName;

	public User(String firstName, String lastName, String userName, String password) {

		this.firstName = firstName;
		this.lastName = lastName;

		registerAccount(userName, password);		
	}

	public void registerAccount(String userName, String password) {
		this.bankAccount = new BankAccount(userName, password);
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}


