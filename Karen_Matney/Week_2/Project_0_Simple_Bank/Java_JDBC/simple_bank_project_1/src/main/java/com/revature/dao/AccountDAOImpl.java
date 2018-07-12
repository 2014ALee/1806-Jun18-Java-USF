package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {
	@Override
	public Account createAccount(Account a, User u) {
		String[] accountid = new String[1];
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			accountid[0] = "accountid";
			// Get account creation
			String sql = "INSERT INTO accounts (accounttype,balance) VALUES (?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql,accountid);
			
			pstmt.setString(1, a.getType());
			pstmt.setDouble(2, a.getBalance());
			
			int rowsUpdated = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			// Add to the list of usernames
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					a.setAccountNumber(rs.getInt(1));
				}
			} else {
				conn.rollback();
				return null;
			}
			
			// Linking account and user tables
			String sql2 = "{CALL link_client_account(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql2);
			
			// Defining insert parameters
			cstmt.setInt(1, u.getUserId());
			cstmt.setInt(2, a.getAccountNumber());
			
			// execute Callable statement
			cstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	@Override
	public ArrayList<Account> getAccounts(User u) {
		ArrayList<Account> accounts = new ArrayList<>();
		Account a = new Account();
		
		// Get Connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			// Get usernames for comparision
			String sql = "SELECT * FROM accounts JOIN clientaccounts USING (accountid) WHERE clientid = " + u.getUserId();
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// Add to the list of usernames
			while(rs.next()) {
				a.setAccountNumber(rs.getInt(1));
				a.setType(rs.getString(2));
				a.setBalance(rs.getDouble(3));
				
				accounts.add(a);
			}

			return accounts;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateBalance(Account a) {
		ArrayList<Account> accounts = new ArrayList<>();
		String[] keys = new String[1];
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
		// Get usernames for comparision
		String sql = "UPDATE accounts SET balance = " + a.getBalance() + "WHERE accountid = " + a.getAccountNumber();
		
		Statement stmt = conn.createStatement();
		int rowUpdated = stmt.executeUpdate(sql,keys);
		ResultSet rs = stmt.getGeneratedKeys();
		
		// Add to the list of usernames
		while(rs.next()) {
			a.setBalance(rs.getDouble(1));
			
		}
		
		return true;
	} catch (SQLException sqle) {
		sqle.printStackTrace();
	}
		return false;
	}
}