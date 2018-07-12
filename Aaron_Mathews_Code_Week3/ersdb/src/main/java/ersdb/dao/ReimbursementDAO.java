package ersdb.dao;

import java.util.ArrayList;

import ersdb.models.Reimbursement;

public interface ReimbursementDAO {
	
	public Reimbursement createReimbursement(Reimbursement reimb);
	
	public Reimbursement updateReimbursementResolver(Reimbursement reimb);
	
	public Reimbursement resolveReimbursement(Reimbursement reimb);
	
	public Reimbursement getReimbursementById(int reimbId);
	
	public ArrayList<Reimbursement> getReimbursementByAuthorId(int authorId);
	
	public ArrayList<Reimbursement> getReimbursementByResolverId(int resolverId);
	
	public ArrayList<Reimbursement> getReimbursementByStatus(int status);
	
	public ArrayList<Reimbursement> getReimbursementByType(int type);

}
