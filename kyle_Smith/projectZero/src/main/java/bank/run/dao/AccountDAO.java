package bank.run.dao;

import bank.run.util.Account;


public interface AccountDAO {
    Account getAccountByUserId(int userId);
    Account totalBankSum();
    
    boolean insertAccount(Account acc);
    boolean updateAccount(Account acc);
    boolean deleteAccount(Account acc);
}
