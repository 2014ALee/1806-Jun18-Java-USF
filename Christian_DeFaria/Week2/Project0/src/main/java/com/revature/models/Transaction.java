package com.revature.models;

public class Transaction {
	
	private int transactionId;
	private User user;
	private Account fromAccount;
	private Account toAccount;
	
	public Transaction() { }

	public Transaction(int transactionId, User user, Account fromAccount, Account toAccount) {
		super();
		this.transactionId = transactionId;
		this.user = user;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromAccount == null) ? 0 : fromAccount.hashCode());
		result = prime * result + ((toAccount == null) ? 0 : toAccount.hashCode());
		result = prime * result + transactionId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		if (fromAccount == null) {
			if (other.fromAccount != null)
				return false;
		} else if (!fromAccount.equals(other.fromAccount))
			return false;
		if (toAccount == null) {
			if (other.toAccount != null)
				return false;
		} else if (!toAccount.equals(other.toAccount))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", user=" + user + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + "]";
	}

}
