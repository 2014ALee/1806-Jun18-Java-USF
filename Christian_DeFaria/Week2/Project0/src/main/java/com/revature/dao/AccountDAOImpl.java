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

import oracle.jdbc.internal.OracleTypes;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public ArrayList<Account> getAllUserAccounts(int userId) {
		ArrayList<Account> accounts = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM accounts WHERE accountId in (SELECT accountId FROM userAccounts where customerid = " + userId + ")";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt(1));
				if(rs.getString(2) == "Checking")
					temp.setChecking(true);
				else
					temp.setChecking(false);
				temp.setBalance(rs.getDouble(3));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}

	@Override
	public Account getAccount(int userId, boolean type) {
		Account account = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM accounts WHERE accounttype = ? and accountid in (SELECT accountid FROM userAccounts WHERE customerId = ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, userId);
			if(type)
				pstmt.setString(1, "Checking");
			else
				pstmt.setString(1, "Savings");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				account.setAccountId(rs.getInt(1));
				account.setChecking(type);
				account.setBalance(rs.getDouble(3));
				return account;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateAccountBalance(Account a) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "{CALL update_balance(?,?)}";
			
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, a.getAccountId());
			
			cstmt.setDouble(2, a.getBalance());
			
			cstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Account createAccount(Account account, User user) {
		Account a = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO accounts (accounttype, balance) VALUES (?,?)";
			
			String[] keys = new String[1];
			keys[0] = "accountId";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			if(account.isChecking())
				pstmt.setString(1, "Checking");
			else
				pstmt.setString(1, "Savings");
			pstmt.setDouble(2, 0.0);
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					a.setAccountId(rs.getInt(1));
				}
				
				a.setChecking(account.isChecking());
				a.setBalance(0.0);
				conn.commit();
				sql = "INSERT INTO useraccounts (customerId, accountId) VALUES (?,?)";
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				pstmt1 = conn.prepareStatement(sql);
				pstmt1.setInt(1, user.getUserID());
				System.out.println("User ID: " + user.getUserID());
				pstmt1.setInt(2, a.getAccountId());
				System.out.println("Account ID: " + a.getAccountId());
				pstmt1.executeUpdate();
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}

}
