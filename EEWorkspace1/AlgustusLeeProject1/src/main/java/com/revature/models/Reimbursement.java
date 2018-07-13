package com.revature.models;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement {
	private long reimbId;
	private double amount;
	private Date submitTime;
	private Date resolveTime;
	private String description;
	private Blob reciept;
	private long authorId;
	private long resolverId;
	private long statusId;
	private long typeId;
	
	public Reimbursement() {}

	public Reimbursement(long reimbId, double amount, Date submitTime, Date resolveTime, String description,
			Blob reciept, long authorId, long resolverId, long statusId, long typeId) {
		super();
		this.reimbId = reimbId;
		this.amount = amount;
		this.submitTime = submitTime;
		this.resolveTime = resolveTime;
		this.description = description;
		this.reciept = reciept;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.statusId = statusId;
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", amount=" + amount + ", submitTime=" + submitTime
				+ ", resolveTime=" + resolveTime + ", description=" + description + ", reciept=" + reciept
				+ ", authorId=" + authorId + ", resolverId=" + resolverId + ", statusId=" + statusId + ", typeId="
				+ typeId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Date resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getReciept() {
		return reciept;
	}

	public void setReciept(Blob reciept) {
		this.reciept = reciept;
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
