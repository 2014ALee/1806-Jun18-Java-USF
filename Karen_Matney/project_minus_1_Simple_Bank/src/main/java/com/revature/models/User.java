/*
 * Karen Matney
 * June 24, 2018
 * User.java
 * Project -1 Revature Training
 * A class for a user used in the SimpleBank class.
 */
package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {
	// Required by the Serializable interface
	private static final long serialVersionUID = 1L;
	
	// transient used below because I don't want unneeded values to be serialized
	private String username;
	private String password; // will need to access password for validation
	private transient String firstName;
	private transient String lastName;
	private transient String eMail;
	private Account account; // will need to access account
	
	public User() { }

	public User(String username, String password, String firstName, String lastName, String eMail) {
		// accounts will always be created separately, therefore not in the contructor
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail
				+ "]";
	}
}
