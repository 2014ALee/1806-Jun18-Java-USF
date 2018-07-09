package com.revature.models;

import java.sql.Blob;
import java.sql.Timestamp;

import com.revature.models.interfaces.ReimbursementInterface;

public class Reimbursement implements ReimbursementInterface{

	private int reimbursementID;
	private int reimbursementAmount;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String description;
	private Blob receipt;
	private int authorID;
	private int resolverID;
	
	private int statusID;
	private int typeID;
	
	private String status;
	private String type;


//we get ID's from database, but the userID and resoverID can be set initially to the own users ones
public Reimbursement(int reimbursementAmount, Timestamp dateSubmitted, Timestamp dateResolved, String description,
			Blob receipt, int authorID, int resolverID, String status, String type) {
		this.reimbursementAmount = reimbursementAmount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.receipt = receipt;
		this.authorID = authorID;
		this.resolverID = resolverID;
		this.status = status;
		this.type = type;
	}



	public Reimbursement() {
		
	}
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}
	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}
	public int getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
	public Timestamp getDateResolved() {
		return dateResolved;
	}
	public void setDateResolved(Timestamp dateResolved) {
		this.dateResolved = dateResolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getResolverID() {
		return resolverID;
	}
	public void setResolverID(int resolverID) {
		this.resolverID = resolverID;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", dateSubmitted=" + dateSubmitted + ", dateResolved=" + dateResolved + ", description=" + description
				+ ", receipt=" + receipt + ", authorID=" + authorID + ", resolverID=" + resolverID + ", statusID="
				+ statusID + ", typeID=" + typeID + ", status=" + status + ", type=" + type + "]";
	}


}

