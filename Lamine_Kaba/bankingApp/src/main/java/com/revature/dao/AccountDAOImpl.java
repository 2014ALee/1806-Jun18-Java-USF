package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO{


	
	@Override
	public ArrayList<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(int ind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account addAccount(Account newAccount) {

		Account newAccounts = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String query = "INSERT INTO account(user_id, checking, savings) values(?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "account_id";
			
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setInt(1, newAccount.getUserid());
			pst.setDouble(2, newAccount.getChecking());
			pst.setDouble(3, newAccount.getSaving());
			

			//pst.executeUpdate();
			
			int rowUpdated = pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rowUpdated != 0) {
				 while(rs.next()) {
					 newAccounts.setAccountid(rs.getInt(1));
				 }
				 }
				 newAccounts.setUserid(newAccount.getUserid());
				 newAccounts.setChecking(newAccount.getChecking());
				 newAccounts.setSaving(newAccount.getSaving());
			}
					
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return newAccounts;
	}

	@Override
	public boolean updateAccount(Account updatedAccount) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "Update account set account_id = ?, checking =?, saving =? where account_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updatedAccount.getAccountid());
			pstmt.setDouble(2, updatedAccount.getChecking());
			pstmt.setDouble(3, updatedAccount.getSaving());
			pstmt.setInt(4, updatedAccount.getAccountid());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeAccountById(Account accountForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAccountByName(String accountName) {
		// TODO Auto-generated method stub
		return false;
	}

}
