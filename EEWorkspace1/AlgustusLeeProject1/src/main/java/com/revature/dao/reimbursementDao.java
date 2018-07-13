package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface reimbursementDao {
	Reimbursement newReimbursement(User u, Reimbursement r);
	void removeReimbursement(Reimbursement r);
}
