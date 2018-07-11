package com.revature.models;

import java.io.Serializable;

public class ERSReimbursement implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int reimId;
	private double reimAmount;
	private String reimSubmitted;
	private String reimResolved;
	private String reimDescription;
	private int reimAuthor;
	private int reimResolver;
	private int reimStatusId;
	private int reimTypeId;
	
	public ERSReimbursement () {
		
	}

	public ERSReimbursement(int reimId, double reimAmount, String reimSubmitted, String reimResolved,
			String reimDescription, int reimAuthor, int reimResolver, int reimStatusId, int reimTypeId) {
		super();
		this.reimId = reimId;
		this.reimAmount = reimAmount;
		this.reimSubmitted = reimSubmitted;
		this.reimResolved = reimResolved;
		this.reimDescription = reimDescription;
		this.reimAuthor = reimAuthor;
		this.reimResolver = reimResolver;
		this.reimStatusId = reimStatusId;
		this.reimTypeId = reimTypeId;
	}

	public int getReimId() {
		return reimId;
	}

	public void setReimId(int reimId) {
		this.reimId = reimId;
	}

	public double getReimAmount() {
		return reimAmount;
	}

	public void setReimAmount(double reimAmount) {
		this.reimAmount = reimAmount;
	}

	public String getReimSubmitted() {
		return reimSubmitted;
	}

	public void setReimSubmitted(String reimSubmitted) {
		this.reimSubmitted = reimSubmitted;
	}

	public String getReimResolved() {
		return reimResolved;
	}

	public void setReimResolved(String reimResolved) {
		this.reimResolved = reimResolved;
	}

	public String getReimDescription() {
		return reimDescription;
	}

	public void setReimDescription(String reimDescription) {
		this.reimDescription = reimDescription;
	}

	public int getReimAuthor() {
		return reimAuthor;
	}

	public void setReimAuthor(int reimAuthor) {
		this.reimAuthor = reimAuthor;
	}

	public int getReimResolver() {
		return reimResolver;
	}

	public void setReimResolver(int reimResolver) {
		this.reimResolver = reimResolver;
	}

	public int getReimStatusId() {
		return reimStatusId;
	}

	public void setReimStatusId(int reimStatusId) {
		this.reimStatusId = reimStatusId;
	}

	public int getReimTypeId() {
		return reimTypeId;
	}

	public void setReimTypeId(int reimTypeId) {
		this.reimTypeId = reimTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(reimAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimAuthor;
		result = prime * result + ((reimDescription == null) ? 0 : reimDescription.hashCode());
		result = prime * result + reimId;
		result = prime * result + ((reimResolved == null) ? 0 : reimResolved.hashCode());
		result = prime * result + reimResolver;
		result = prime * result + reimStatusId;
		result = prime * result + ((reimSubmitted == null) ? 0 : reimSubmitted.hashCode());
		result = prime * result + reimTypeId;
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
		ERSReimbursement other = (ERSReimbursement) obj;
		if (Double.doubleToLongBits(reimAmount) != Double.doubleToLongBits(other.reimAmount))
			return false;
		if (reimAuthor != other.reimAuthor)
			return false;
		if (reimDescription == null) {
			if (other.reimDescription != null)
				return false;
		} else if (!reimDescription.equals(other.reimDescription))
			return false;
		if (reimId != other.reimId)
			return false;
		if (reimResolved == null) {
			if (other.reimResolved != null)
				return false;
		} else if (!reimResolved.equals(other.reimResolved))
			return false;
		if (reimResolver != other.reimResolver)
			return false;
		if (reimStatusId != other.reimStatusId)
			return false;
		if (reimSubmitted == null) {
			if (other.reimSubmitted != null)
				return false;
		} else if (!reimSubmitted.equals(other.reimSubmitted))
			return false;
		if (reimTypeId != other.reimTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERSReimbursement [reimId=" + reimId + ", reimAmount=" + reimAmount + ", reimSubmitted=" + reimSubmitted
				+ ", reimResolved=" + reimResolved + ", reimDescription=" + reimDescription + ", reimAuthor="
				+ reimAuthor + ", reimResolver=" + reimResolver + ", reimStatusId=" + reimStatusId + ", reimTypeId="
				+ reimTypeId + "]";
	}
	
	
}
