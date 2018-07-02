package com.revature.models;

public class Transaction {

	private int transactionId;
	private int userId;
	private int transferId;
	private double amount;
	private String dateOf;
	
	public Transaction() {
		
	}

	public Transaction(int transactionId, int userId, int transferId, double amount, String dateOf) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.transferId = transferId;
		this.amount = amount;
		this.dateOf = dateOf;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTransferId() {
		return transferId;
	}

	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDateOf() {
		return dateOf;
	}

	public void setDateOf(String dateOf) {
		this.dateOf = dateOf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateOf == null) ? 0 : dateOf.hashCode());
		result = prime * result + transactionId;
		result = prime * result + transferId;
		result = prime * result + userId;
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (dateOf == null) {
			if (other.dateOf != null)
				return false;
		} else if (!dateOf.equals(other.dateOf))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transferId != other.transferId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", transferId=" + transferId
				+ ", amount=" + amount + ", dateOf=" + dateOf + "]";
	}
	
}
