package com.revature.models.interfaces;

import java.sql.Blob;
import java.sql.Timestamp;

public interface ReimbursementInterface {

	public int getReimbursementID();
	public int getReimbursementAmount();
	public void setReimbursementID(int reimbursementID);
	public Timestamp getDateSubmitted();
	public Timestamp getDateResolved();
	public String getDescription();
	public Blob getReceipt();
	public int getAuthorID();
	public int getResolverID();
	public int getStatusID();
	public int getTypeID();
	
	public void setReimbursementAmount(int reimbursementAmount);
	public void setDateSubmitted(Timestamp dateSubmitted);
	public void setDateResolved(Timestamp dateResolved);
	public void setDescription(String description);
	public void setReceipt(Blob receipt);
	public void setAuthorID(int authorID);
	public void setResolverID(int resolverID);
	public void setStatusID(int statusID);
	public void setTypeID(int typeID);	
	
}
