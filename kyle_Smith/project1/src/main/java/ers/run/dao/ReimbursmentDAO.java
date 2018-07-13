package ers.run.dao;

import java.util.ArrayList;

import ers.run.models.Reimbursment;

public interface ReimbursmentDAO {

	ArrayList<Reimbursment> getAllReimbursments();
	ArrayList<Reimbursment> getReimbursmentsByAuthor(int author);
	
	Reimbursment getTypeAndStatus(int reimbursmentId);
	Reimbursment getReimbursmentById(int reimId);
	
    boolean insertReimbursment(Reimbursment reim);
    boolean updateReimbursment(Reimbursment reim);
    boolean deleteReimbursment(Reimbursment reim);
}

