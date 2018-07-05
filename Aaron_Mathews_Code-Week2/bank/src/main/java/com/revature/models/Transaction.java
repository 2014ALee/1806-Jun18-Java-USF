package com.revature.models;

public class Transaction {
	private int transactionid;
	private int accountid;
	private double amount;
	
	public Transaction() { }

	public Transaction(int transactionid, int accountid, double amount) {
		super();
		this.transactionid = transactionid;
		this.accountid = accountid;
		this.amount = amount;
	}

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + transactionid;
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
		if (accountid != other.accountid)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (transactionid != other.transactionid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", accountid=" + accountid + ", amount=" + amount + "]";
	}
	
	
}
