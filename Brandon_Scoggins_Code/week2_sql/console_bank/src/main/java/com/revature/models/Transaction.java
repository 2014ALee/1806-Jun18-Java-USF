package com.revature.models;

public class Transaction {

	private int transactionId;
	private int userId;
	private double amount;
	private int originAccountID;
	private String originType;
	private int targetAccountId;
	private String targetType;
	private String dateOf;
	
	public Transaction() {
		
	}

	public Transaction(int transactionId, int userId, double amount, int originAccountID, String originType,
			int targetAccountId, String targetType, String dateOf) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.amount = amount;
		this.originAccountID = originAccountID;
		this.originType = originType;
		this.targetAccountId = targetAccountId;
		this.targetType = targetType;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getOriginAccountID() {
		return originAccountID;
	}

	public void setOriginAccountID(int originAccountID) {
		this.originAccountID = originAccountID;
	}

	public String getOriginType() {
		return originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	public int getTargetAccountId() {
		return targetAccountId;
	}

	public void setTargetAccountId(int targetAccountId) {
		this.targetAccountId = targetAccountId;
	}

	public String getTargetType() {
		return targetType;
	}

	public void setTargetType(String targetType) {
		this.targetType = targetType;
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
		result = prime * result + originAccountID;
		result = prime * result + ((originType == null) ? 0 : originType.hashCode());
		result = prime * result + targetAccountId;
		result = prime * result + ((targetType == null) ? 0 : targetType.hashCode());
		result = prime * result + transactionId;
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
		if (originAccountID != other.originAccountID)
			return false;
		if (originType == null) {
			if (other.originType != null)
				return false;
		} else if (!originType.equals(other.originType))
			return false;
		if (targetAccountId != other.targetAccountId)
			return false;
		if (targetType == null) {
			if (other.targetType != null)
				return false;
		} else if (!targetType.equals(other.targetType))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", userId=" + userId + ", amount=" + amount
				+ ", originAccountID=" + originAccountID + ", originType=" + originType + ", targetAccountId="
				+ targetAccountId + ", targetType=" + targetType + ", dateOf=" + dateOf + "]";
	}
	
}
