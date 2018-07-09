package com.revature.models;

import java.sql.Timestamp;

import com.revature.models.interfaces.ReimbursementInterface;

public class Reimbursement implements ReimbursementInterface{

	private int reimbursementID;
	private double reimbursementAmount;
	private Timestamp dateSubmitted;
	private Timestamp dateResolved;
	private String description;
	private int authorID;
	private int resolverID;
	
	private ReimbursementStatus status;
	private ReimbursementType type;


//we get ID's from database, but the userID and resoverID can be set initially to the own users ones
public Reimbursement(double reimbursementAmount, Timestamp dateSubmitted, Timestamp dateResolved, String description
		, int authorID, int resolverID, ReimbursementStatus status, ReimbursementType type) {
		this.reimbursementAmount = reimbursementAmount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.authorID = authorID;
		this.resolverID = resolverID;
		this.status = status;
		this.type = type;
	}

	public Reimbursement() {
		
	}


	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	public ReimbursementType getType() {
		return type;
	}

	public void setType(ReimbursementType type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", dateSubmitted=" + dateSubmitted + ", dateResolved=" + dateResolved + ", description=" + description
				+ ", authorID=" + authorID + ", resolverID=" + resolverID + ", status=" + status + ", type=" + type
				+ "]";
	}

	
	
	}




