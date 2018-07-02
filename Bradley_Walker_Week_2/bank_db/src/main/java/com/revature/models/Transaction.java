package com.revature.models;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Transaction {
	
	private int transactionID;
	private int userID;
	private int accountID;
	private double amount;
	private Timestamp timestamp;
	
	public Transaction() {}

	public Transaction(int transactionID, int userID, int accountID, double amount, Timestamp timestamp) {
		super();
		this.transactionID = transactionID;
		this.userID = userID;
		this.accountID = accountID;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountID;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + transactionID;
		result = prime * result + userID;
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
		Transaction other = (Transaction) obj;
		if (accountID != other.accountID)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (transactionID != other.transactionID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", userID=" + userID + ", accountID=" + accountID
				+ ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}

	

}
