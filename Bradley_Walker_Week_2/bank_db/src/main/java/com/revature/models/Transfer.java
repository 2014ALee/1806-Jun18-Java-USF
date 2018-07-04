package com.revature.models;

import java.sql.Timestamp;

public class Transfer implements Timestamped{
	
	private int transferID;
	private int fromUserID;
	private int toUserID;
	private int fromAccountID;
	private int toAccountID;
	private double amount;
	private Timestamp timestamp;
	
	public Transfer() {}

	public Transfer(int transferID, int fromUserID, int toUserID, int fromAccountID, int toAccountID, double amount,
			Timestamp timestamp) {
		super();
		this.transferID = transferID;
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
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

	public int getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(int fromUserID) {
		this.fromUserID = fromUserID;
	}

	public int getToUserID() {
		return toUserID;
	}

	public void setToUserID(int toUserID) {
		this.toUserID = toUserID;
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
		result = prime * result + fromUserID;
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + toAccountID;
		result = prime * result + toUserID;
		result = prime * result + transferID;
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
		if (fromUserID != other.fromUserID)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (toAccountID != other.toAccountID)
			return false;
		if (toUserID != other.toUserID)
			return false;
		if (transferID != other.transferID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("User #%d transferred $%.2f to User #%d on %tc", fromUserID, amount, toUserID, timestamp);
	}
}
