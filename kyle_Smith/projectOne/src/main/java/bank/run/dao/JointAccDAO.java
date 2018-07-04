package bank.run.dao;

import bank.run.util.JointAccount;

public interface JointAccDAO {
	
    JointAccount getJointByAccountId(int AccountId);
    
    boolean insertAccount(JointAccount acc);
    boolean updateAccount(JointAccount acc);
}
