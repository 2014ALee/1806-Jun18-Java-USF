package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

public class AccountDaoImpl implements AccountDao{

	@Override
	public Account GetAccount(int account_num) {
		
		Account userAccount = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM BankAccount WHERE account_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account_num);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				userAccount.setAccount_id(rs.getInt(1));
				userAccount.setCust_id(rs.getInt(2));
				userAccount.setAccountNumber(account_num);
				userAccount.setBalance(rs.getDouble(4));
				userAccount.setAccountType(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAccount;
	}

	@Override
	public boolean Deposit(Account account, double depositAmount) {

		Account newAccount = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE BankAccount SET balance = ? WHERE account_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  (account.getBalance() + depositAmount));
			pstmt.setDouble(2,  account.getAccountNumber());
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Withdraw(Account account, double withdrawalAmount) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE BankAccount SET balance = ? WHERE account_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  account.getBalance());
			pstmt.setDouble(2,  account.getAccount_id());
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account createAccount() {

		Account account = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ACCOUNT VALUES()"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
