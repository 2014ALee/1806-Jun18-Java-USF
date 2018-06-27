package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private double checkingBalance;
	private double savingsBalance;
	private double jointBalance;
	private boolean hasCheckingAccount;
	private boolean hasSavingsAccount;
	private boolean hasJointAccount;
	//the username email and pass for the other person on the joint account
	private String jointFirstName;
	private String jointLastName;
	private String jointUsername;
	private String jointEmail;
	private String jointPassword;
	
	//no args constructor
	public User() {	}

	//constructor for user registration
	public User(String firstName, String lastName, String username, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double getJointBalance() {
		return jointBalance;
	}

	public void setJointBalance(double jointBalance) {
		this.jointBalance = jointBalance;
	}

	public boolean getHasCheckingAccount() {
		return hasCheckingAccount;
	}

	public void setHasCheckingAccount(boolean hasCheckingAccount) {
		this.hasCheckingAccount = hasCheckingAccount;
	}

	public boolean getHasSavingsAccount() {
		return hasSavingsAccount;
	}

	public void setHasSavingsAccount(boolean hasSavingsAccount) {
		this.hasSavingsAccount = hasSavingsAccount;
	}

	public boolean getHasJointAccount() {
		return hasJointAccount;
	}

	public void setHasJointAccount(boolean hasJointAccount) {
		this.hasJointAccount = hasJointAccount;
	}
	
	public String getJointFirstName() {
		return jointFirstName;
	}

	public void setJointFirstName(String jointFirstName) {
		this.jointFirstName = jointFirstName;
	}

	public String getJointLastName() {
		return jointLastName;
	}

	public void setJointLastName(String jointLastName) {
		this.jointLastName = jointLastName;
	}

	public String getJointUsername() {
		return jointUsername;
	}

	public void setJointUsername(String jointUsername) {
		this.jointUsername = jointUsername;
	}

	public String getJointEmail() {
		return jointEmail;
	}

	public void setJointEmail(String jointEmail) {
		this.jointEmail = jointEmail;
	}

	public String getJointPassword() {
		return jointPassword;
	}

	public void setJointPassword(String jointPassword) {
		this.jointPassword = jointPassword;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", email=" + email + "]";
	}

}