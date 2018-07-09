package com.revature.dao;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class reimbursementDaoImpl implements reimbursementDao{

	public Reimbursement newReimbursement(User u, Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			
		}
		return r;
	}

	public void removeReimbursement(Reimbursement r) {
		// TODO Auto-generated method stub
		
	}

}
