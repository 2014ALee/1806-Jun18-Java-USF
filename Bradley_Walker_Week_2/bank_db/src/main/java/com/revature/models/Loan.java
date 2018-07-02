package com.revature.models;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class Loan {
	
	private int loanID;
	private int userID;
	private double amountLoaned;
	private double amountRepaid;
	private Timestamp payBy;
	private Timestamp timestamp;
	
	public Loan() {}

	public Loan(int loanID, int userID, double amountLoaned, double amountRepaid, Timestamp payBy,
			Timestamp timestamp) {
		super();
		this.loanID = loanID;
		this.userID = userID;
		this.amountLoaned = amountLoaned;
		this.amountRepaid = amountRepaid;
		this.payBy = payBy;
		this.timestamp = timestamp;
	}

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getAmountLoaned() {
		return amountLoaned;
	}

	public void setAmountLoaned(double amountLoaned) {
		this.amountLoaned = amountLoaned;
	}

	public double getAmountRepaid() {
		return amountRepaid;
	}

	public void setAmountRepaid(double amountRepaid) {
		this.amountRepaid = amountRepaid;
	}

	public Timestamp getPayBy() {
		return payBy;
	}

	public void setPayBy(Timestamp payBy) {
		this.payBy = payBy;
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
		temp = Double.doubleToLongBits(amountLoaned);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountRepaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + loanID;
		result = prime * result + ((payBy == null) ? 0 : payBy.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Loan other = (Loan) obj;
		if (Double.doubleToLongBits(amountLoaned) != Double.doubleToLongBits(other.amountLoaned))
			return false;
		if (Double.doubleToLongBits(amountRepaid) != Double.doubleToLongBits(other.amountRepaid))
			return false;
		if (loanID != other.loanID)
			return false;
		if (payBy == null) {
			if (other.payBy != null)
				return false;
		} else if (!payBy.equals(other.payBy))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Loan [loanID=" + loanID + ", userID=" + userID + ", amountLoaned=" + amountLoaned + ", amountRepaid="
				+ amountRepaid + ", payBy=" + payBy + ", timestamp=" + timestamp + "]";
	}

	
}
