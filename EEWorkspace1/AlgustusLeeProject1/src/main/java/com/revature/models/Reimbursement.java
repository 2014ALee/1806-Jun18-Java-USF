package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
	private long reimbId;
	private double amount;
	private Timestamp submitTime;
	private Timestamp resolveTime;
	private String description;
	private String action;
	private long authorId;
	private long resolverId;
	private long statusId;
	private long typeId;
	
	public Reimbursement() {}

	public Reimbursement(long reimbId, double amount, Timestamp submitTime, Timestamp resolveTime, String description,
			String action, long authorId, long resolverId, long statusId, long typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.action = action;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitTime=" + submitTime
				+ ", resolveTime=" + resolveTime + ", description=" + description + ", action=" + action + ", authorId="
				+ authorId + ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId=" + typeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (authorId ^ (authorId >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (reimbId ^ (reimbId >>> 32));
		result = prime * result + ((resolveTime == null) ? 0 : resolveTime.hashCode());
		result = prime * result + (int) (resolverId ^ (resolverId >>> 32));
		result = prime * result + (int) (statusId ^ (statusId >>> 32));
		result = prime * result + ((submitTime == null) ? 0 : submitTime.hashCode());
		result = prime * result + (int) (typeId ^ (typeId >>> 32));
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
		Reimbursement other = (Reimbursement) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (authorId != other.authorId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (resolveTime == null) {
			if (other.resolveTime != null)
				return false;
		} else if (!resolveTime.equals(other.resolveTime))
			return false;
		if (resolverId != other.resolverId)
			return false;
		if (statusId != other.statusId)
			return false;
		if (submitTime == null) {
			if (other.submitTime != null)
				return false;
		} else if (!submitTime.equals(other.submitTime))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	public long getReimbId() {
		return reimbId;
	}

	public void setReimbId(long reimbId) {
		this.reimbId = reimbId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Timestamp resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getResolverId() {
		return resolverId;
	}

	public void setResolverId(long resolverId) {
		this.resolverId = resolverId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	
}
