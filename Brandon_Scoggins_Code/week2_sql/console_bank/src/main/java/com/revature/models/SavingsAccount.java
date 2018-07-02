package com.revature.models;

public class SavingsAccount {

	private int savingsId;
	private double savingsBalance;
	
	public SavingsAccount() {
		
	}

	public SavingsAccount(int savingsId, double savingsBalance) {
		super();
		this.savingsId = savingsId;
		this.savingsBalance = savingsBalance;
	}

	public int getSavingsId() {
		return savingsId;
	}

	public void setSavingsId(int savingsId) {
		this.savingsId = savingsId;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(savingsBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + savingsId;
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
		SavingsAccount other = (SavingsAccount) obj;
		if (Double.doubleToLongBits(savingsBalance) != Double.doubleToLongBits(other.savingsBalance))
			return false;
		if (savingsId != other.savingsId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SavingsAccount [savingsId=" + savingsId + ", savingsBalance=" + savingsBalance + "]";
	}
	
}
