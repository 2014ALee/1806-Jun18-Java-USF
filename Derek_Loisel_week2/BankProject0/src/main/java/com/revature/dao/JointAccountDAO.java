package com.revature.dao;

import com.revature.models.JointAccount;

public interface JointAccountDAO {

	public JointAccount getJointAccountByUserID(int id);
	
	public JointAccount addJointAccount(JointAccount newJointAccount);
}
