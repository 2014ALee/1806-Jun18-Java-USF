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

	private int statusID;
	private String statusName;

	private int typeID;
	private String typeName;

	//we get ID's from database, but the userID and resoverID can be set initially to the own users ones
	public Reimbursement(int reimbID, double reimbursementAmount, Timestamp dateSubmitted, Timestamp dateResolved, String description
			, int authorID, int resolverID, String status, String type) {
		this.reimbursementID = reimbID;
		this.reimbursementAmount = reimbursementAmount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.authorID = authorID;
		this.resolverID = resolverID;
		this.statusName = status;
		this.typeName = type;
		setStatusID(statusName);
		setTypeID(typeName);
	}

	public Reimbursement(int reimbID, double reimbursementAmount, Timestamp dateSubmitted, Timestamp dateResolved, String description
			, int authorID, int resolverID, int statusID, int typeID) {
		this.reimbursementID = reimbID;
		this.reimbursementAmount = reimbursementAmount;
		this.dateSubmitted = dateSubmitted;
		this.dateResolved = dateResolved;
		this.description = description;
		this.authorID = authorID;
		this.resolverID = resolverID;
		this.statusID = statusID;
		this.typeID = typeID;
		setStatusName(statusID);
		setTypeName(typeID);
	}

	
	public void setTypeID(String type) {
		if(type == "lodging") {
			this.typeID = 1;;
		} else if(type == "travel") {
			this.typeID = 2;
		} else if(type == "food") {
			this.typeID = 3;
		} else {
			this.typeID = 4;
		}
	}

	public void setStatusID(String status) {
		if(status == "pending") {
			this.statusID = 1;
		} else if(status == "approved") {
			this.statusID = 2;
		} else if(status  == "denied") {
			this.statusID = 3;
		}
	}

	public void setTypeName(int typeID) {
		if(typeID == 1) {
			this.typeName = "lodging";
		} else if(typeID == 2) {
			this.typeName = "travel";
		} else if(typeID == 3) {
			this.typeName = "food";
		} else if(typeID == 4) {
			this.typeName = "other";
		}
	}

	public void setStatusName(int statusID) {
		if(statusID == 1) {
			this.statusName = "pending";
		} else if(statusID == 2) {
			this.statusName = "approved";
		} else if(statusID  == 3) {
			this.statusName = "denied";
		}	}

	public Reimbursement() {

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

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", reimbursementAmount=" + reimbursementAmount
				+ ", dateSubmitted=" + dateSubmitted + ", dateResolved=" + dateResolved + ", description=" + description
				+ ", authorID=" + authorID + ", resolverID=" + resolverID + ", statusID=" + statusID + ", statusName="
				+ statusName + ", typeID=" + typeID + ", typeName=" + typeName + "]";
	}

}




