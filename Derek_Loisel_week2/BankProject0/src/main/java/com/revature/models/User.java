package com.revature.models;

public class User {
	//User POJO
	
	private int userID;
	private int accountID;
	private int jointID;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	private double checkingBalance;
	private double savingsBalance;
	private double jointBalance;
	
	private boolean hasCheckingAccount;
	private boolean hasSavingsAccount;
	private boolean hasJointAccount;
	
	//no args constructor
	public User() {	}

	public User(String username, String password, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getJointID() {
		return jointID;
	}

	public void setJointID(int jointID) {
		this.jointID = jointID;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(checkingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (hasCheckingAccount ? 1231 : 1237);
		result = prime * result + (hasJointAccount ? 1231 : 1237);
		result = prime * result + (hasSavingsAccount ? 1231 : 1237);
		temp = Double.doubleToLongBits(jointBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + jointID;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		temp = Double.doubleToLongBits(savingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
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
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(checkingBalance) != Double.doubleToLongBits(other.checkingBalance))
			return false;
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
		if (hasCheckingAccount != other.hasCheckingAccount)
			return false;
		if (hasJointAccount != other.hasJointAccount)
			return false;
		if (hasSavingsAccount != other.hasSavingsAccount)
			return false;
		if (Double.doubleToLongBits(jointBalance) != Double.doubleToLongBits(other.jointBalance))
			return false;
		if (jointID != other.jointID)
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
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		if (userID != other.userID)
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
		return "User [userID=" + userID + ", accountID=" + accountID + ", jointID=" + jointID + ", username=" + username
				+ ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", checkingBalance=" + checkingBalance + ", savingsBalance=" + savingsBalance + ", jointBalance="
				+ jointBalance + ", hasCheckingAccount=" + hasCheckingAccount + ", hasSavingsAccount="
				+ hasSavingsAccount + ", hasJointAccount=" + hasJointAccount + "]";
	}

}