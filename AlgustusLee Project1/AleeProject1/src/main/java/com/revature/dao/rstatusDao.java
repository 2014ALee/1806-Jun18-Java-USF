package com.revature.dao;

import com.revature.models.Reimbursement;

public interface rstatusDao {
	Reimbursement getStatus(Reimbursement r);
	Reimbursement updateStatus(Reimbursement r);
}
