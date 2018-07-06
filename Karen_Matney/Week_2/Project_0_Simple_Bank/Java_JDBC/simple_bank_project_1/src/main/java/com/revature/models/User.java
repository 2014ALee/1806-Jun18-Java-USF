/*
 * Karen Matney
 * July 2, 2018
 * User.java
 * Project -1 Revature Training
 * A class for a user used in the SimpleBank class.
 */
package com.revature.models;

public class User {
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String eMail;
	private Account account;
	
	public User() { }

	public User(String username, String password, String firstName, String lastName, String eMail) {
		// accounts will always be created separately, therefore not in the constructor
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userid) {
		this.userId = userid;
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
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", eMail=" + eMail + ", account=" + account + "]";
	}
}