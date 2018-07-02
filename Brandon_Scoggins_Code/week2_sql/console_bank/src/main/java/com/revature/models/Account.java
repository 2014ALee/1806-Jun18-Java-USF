package com.revature.models;

public class Account {

	private int accountId;
	private int accountHolderId;
	private int checkingAccountId;
	private int savingsAccountId;
	
	public Account() {
		
	}

	public Account(int accountId, int accountHolderId, int checkingAccountId, int savingsAccountId) {
		super();
		this.accountId = accountId;
		this.accountHolderId = accountHolderId;
		this.checkingAccountId = checkingAccountId;
		this.savingsAccountId = savingsAccountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(int accountHolderId) {
		this.accountHolderId = accountHolderId;
	}

	public int getCheckingAccountId() {
		return checkingAccountId;
	}

	public void setCheckingAccountId(int checkingAccountId) {
		this.checkingAccountId = checkingAccountId;
	}

	public int getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(int savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountHolderId;
		result = prime * result + accountId;
		result = prime * result + checkingAccountId;
		result = prime * result + savingsAccountId;
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
		if (accountHolderId != other.accountHolderId)
			return false;
		if (accountId != other.accountId)
			return false;
		if (checkingAccountId != other.checkingAccountId)
			return false;
		if (savingsAccountId != other.savingsAccountId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountHolderId=" + accountHolderId + ", checkingAccountId="
				+ checkingAccountId + ", savingsAccountId=" + savingsAccountId + "]";
	}
	
}
