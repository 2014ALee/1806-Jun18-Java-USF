package com.revature.models;

public class CheckingAccount {

	private int checkingId;
	private double checkingBalance;
	
	public CheckingAccount() {
		
	}

	public CheckingAccount(int checkingId, double checkingBalance) {
		super();
		this.checkingId = checkingId;
		this.checkingBalance = checkingBalance;
	}

	public int getCheckingId() {
		return checkingId;
	}

	public void setCheckingId(int checkingId) {
		this.checkingId = checkingId;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(checkingBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + checkingId;
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
		CheckingAccount other = (CheckingAccount) obj;
		if (Double.doubleToLongBits(checkingBalance) != Double.doubleToLongBits(other.checkingBalance))
			return false;
		if (checkingId != other.checkingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CheckingAccount [checkingId=" + checkingId + ", checkingBalance=" + checkingBalance + "]";
	}
	
}
