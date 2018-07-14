package com.revature.models.interfaces;
import java.sql.Timestamp;

public interface ReimbursementInterface {

	public int getReimbursementID();
	public double getReimbursementAmount();
	public void setReimbursementID(int reimbursementID);
	public Timestamp getDateSubmitted();
	public Timestamp getDateResolved();
	public String getDescription();
	public int getAuthorID();
	public int getResolverID();

	
	public void setReimbursementAmount(double reimbursementAmount);
	public void setDateSubmitted(Timestamp dateSubmitted);
	public void setDateResolved(Timestamp dateResolved);
	public void setDescription(String description);
	public void setAuthorID(int authorID);
	public void setResolverID(int resolverID);

	
}
