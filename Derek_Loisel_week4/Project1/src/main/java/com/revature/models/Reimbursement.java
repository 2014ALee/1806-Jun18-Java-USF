package com.revature.models;

import java.sql.Blob;
import java.sql.Date;

public class Reimbursement{
	
	private int reimbursementID;
	private double reimbursementAmount;
	private Date reimbursementSubmitted;
	private Date reimbursementResolved;
	private String reimbursementDescription;
	private Blob reimbursementReceipt;
	private int reimbursementAuthor;
	private int reimbursementResolver;
	private int reimbursementStatusID;
	private int reimbursementTypeID;
	private int reimbursementStatus;
	private int reimbursementType;
	
	public Reimbursement() {}
	
	public Reimbursement(int reimbursementID, double reimbursementAmount, Date reimbursementSubmitted,
			Date reimbursementResolved, String reimbursementDescription, Blob reimbursementReceipt,
			int reimbursementAuthor, int reimbursementResolver, int reimbursementStatusID, int reimbursementTypeID,
			int reimbursementStatus, int reimbursementType) {
		super();
		this.reimbursementID = reimbursementID;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementSubmitted = reimbursementSubmitted;
		this.reimbursementResolved = reimbursementResolved;
		this.reimbursementDescription = reimbursementDescription;
		this.reimbursementReceipt = reimbursementReceipt;
		this.reimbursementAuthor = reimbursementAuthor;
		this.reimbursementResolver = reimbursementResolver;
		this.reimbursementStatusID = reimbursementStatusID;
		this.reimbursementTypeID = reimbursementTypeID;
		this.reimbursementStatus = reimbursementStatus;
		this.reimbursementType = reimbursementType;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public double getReimbursementAmount() {
		return reimbursementAmount;
	}

	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}

	public Date getReimbursementSubmitted() {
		return reimbursementSubmitted;
	}

	public void setReimbursementSubmitted(Date reimbursementSubmitted) {
		this.reimbursementSubmitted = reimbursementSubmitted;
	}

	public Date getReimbursementResolved() {
		return reimbursementResolved;
	}

	public void setReimbursementResolved(Date reimbursementResolved) {
		this.reimbursementResolved = reimbursementResolved;
	}

	public String getReimbursementDescription() {
		return reimbursementDescription;
	}

	public void setReimbursementDescription(String reimbursementDescription) {
		this.reimbursementDescription = reimbursementDescription;
	}

	public Blob getReimbursementReceipt() {
		return reimbursementReceipt;
	}

	public void setReimbursementReceipt(Blob reimbursementReciept) {
		this.reimbursementReceipt = reimbursementReciept;
	}

	public int getReimbursementAuthor() {
		return reimbursementAuthor;
	}

	public void setReimbursementAuthor(int reimbursementAuthor) {
		this.reimbursementAuthor = reimbursementAuthor;
	}

	public int getReimbursementResolver() {
		return reimbursementResolver;
	}

	public void setReimbursementResolver(int reimbursementResolver) {
		this.reimbursementResolver = reimbursementResolver;
	}

	public int getReimbursementStatusID() {
		return reimbursementStatusID;
	}

	public void setReimbursementStatusID(int reimbursementStatusID) {
		this.reimbursementStatusID = reimbursementStatusID;
	}

	public int getReimbursementTypeID() {
		return reimbursementTypeID;
	}

	public void setReimbursementTypeID(int reimbursementTypeID) {
		this.reimbursementTypeID = reimbursementTypeID;
	}

	public int getReimbursementStatus() {
		return reimbursementStatus;
	}

	public void setReimbursementStatus(int reimbursementStatus) {
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(int reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbursementAuthor;
		result = prime * result + ((reimbursementDescription == null) ? 0 : reimbursementDescription.hashCode());
		result = prime * result + reimbursementID;
		result = prime * result + ((reimbursementReceipt == null) ? 0 : reimbursementReceipt.hashCode());
		result = prime * result + ((reimbursementResolved == null) ? 0 : reimbursementResolved.hashCode());
		result = prime * result + reimbursementResolver;
		result = prime * result + reimbursementStatus;
		result = prime * result + reimbursementStatusID;
		result = prime * result + ((reimbursementSubmitted == null) ? 0 : reimbursementSubmitted.hashCode());
		result = prime * result + reimbursementType;
		result = prime * result + reimbursementTypeID;
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
		if (Double.doubleToLongBits(reimbursementAmount) != Double.doubleToLongBits(other.reimbursementAmount))
			return false;
		if (reimbursementAuthor != other.reimbursementAuthor)
			return false;
		if (reimbursementDescription == null) {
			if (other.reimbursementDescription != null)
				return false;
		} else if (!reimbursementDescription.equals(other.reimbursementDescription))
			return false;
		if (reimbursementID != other.reimbursementID)
			return false;
		if (reimbursementReceipt == null) {
			if (other.reimbursementReceipt != null)
				return false;
		} else if (!reimbursementReceipt.equals(other.reimbursementReceipt))
			return false;
		if (reimbursementResolved == null) {
			if (other.reimbursementResolved != null)
				return false;
		} else if (!reimbursementResolved.equals(other.reimbursementResolved))
			return false;
		if (reimbursementResolver != other.reimbursementResolver)
			return false;
		if (reimbursementStatus != other.reimbursementStatus)
			return false;
		if (reimbursementStatusID != other.reimbursementStatusID)
			return false;
		if (reimbursementSubmitted == null) {
			if (other.reimbursementSubmitted != null)
				return false;
		} else if (!reimbursementSubmitted.equals(other.reimbursementSubmitted))
			return false;
		if (reimbursementType != other.reimbursementType)
			return false;
		if (reimbursementTypeID != other.reimbursementTypeID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementSubmitted=" + reimbursementSubmitted + ", reimbursementResolved="
				+ reimbursementResolved + ", reimbursementDescription=" + reimbursementDescription
				+ ", reimbursementReciept=" + reimbursementReceipt + ", reimbursementAuthor=" + reimbursementAuthor
				+ ", reimbursementResolver=" + reimbursementResolver + ", reimbursementStatusID="
				+ reimbursementStatusID + ", reimbursementTypeID=" + reimbursementTypeID + ", reimbursementStatus="
				+ reimbursementStatus + ", reimbursementType=" + reimbursementType + "]";
	}
}
