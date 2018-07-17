package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	private int acctId;
	private String acctType;
	private double balance;

	public Account() { }

	public Account(int acctId, String acctType, double balance) {
		super();
		this.acctId = acctId;
		this.acctType = acctType;
		this.balance = balance;
	}

	public int getAcctId() {
		return acctId;
	}

	public void setAcctId(int acctId) {
		this.acctId = acctId;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acctId;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Account other = (Account) obj;
		if (acctId != other.acctId)
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", acctType=" + acctType + ", balance=" + balance + "]";
	}

}
