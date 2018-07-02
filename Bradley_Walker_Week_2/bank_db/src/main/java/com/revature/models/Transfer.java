package com.revature.models;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Transfer {
	
	private int transferID;
	private int userID;
	private int fromAccountID;
	private int toAccountID;
	private double amount;
	private Timestamp timestamp;
	
	public Transfer() {}

	public Transfer(int transferID, int userID, int fromAccountID, int toAccountID, double amount,
			Timestamp timestamp) {
		super();
		this.transferID = transferID;
		this.userID = userID;
		this.fromAccountID = fromAccountID;
		this.toAccountID = toAccountID;
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public int getTransferID() {
		return transferID;
	}

	public void setTransferID(int transferID) {
		this.transferID = transferID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getFromAccountID() {
		return fromAccountID;
	}

	public void setFromAccountID(int fromAccountID) {
		this.fromAccountID = fromAccountID;
	}

	public int getToAccountID() {
		return toAccountID;
	}

	public void setToAccountID(int toAccountID) {
		this.toAccountID = toAccountID;
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
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + fromAccountID;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + toAccountID;
		result = prime * result + transferID;
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
		Transfer other = (Transfer) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (fromAccountID != other.fromAccountID)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (toAccountID != other.toAccountID)
			return false;
		if (transferID != other.transferID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transfer [transferID=" + transferID + ", userID=" + userID + ", fromAccountID=" + fromAccountID
				+ ", toAccountID=" + toAccountID + ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}

	
}
