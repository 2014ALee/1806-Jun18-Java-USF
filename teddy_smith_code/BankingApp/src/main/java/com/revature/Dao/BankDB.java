package com.revature.Dao;


import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.Account;
import com.revature.model.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;


public class BankDB implements BankDAO{

	@Override
	public Account GetCredential(int user_number) {
		
		
		Account userCredential = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM BankApp WHERE user_number = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_number);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				userCredential.setBank_id(rs.getInt(1));
				userCredential.setUser_id(rs.getInt(2));
				userCredential.setUser_number(rs.getInt(3));
				userCredential.setUser_account(rs.getString(4));
				
				userCredential.setCredbalance(rs.getInt(3));
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return userCredential;
	}

	@Override
	public boolean Deposit(Account account, double depositAmount) {
		
		Account depCredential = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
				conn.setAutoCommit(false);
				
				String sql = "UPDATE BankApp SET credbalance = ? WHERE user_number = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1,  (getCredbalance(account) + depositAmount));
				pstmt.setDouble(2,  account.getUser_number());
				int rowsUpdated = pstmt.executeUpdate();

				if(rowsUpdated != 0) {

					conn.commit();

					return true;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Withdraw(Account account, double withdrawAmount) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE BankApp SET credbalance = ? WHERE user_number = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, (getCredbalance(account) - withdrawAmount));
			pstmt.setDouble(2, account.getBank_id());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				return true;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Account createCredential(User a, String username) {
		Account account = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){

			conn.setAutoCommit(false);

			String sql = "INSERT INTO BankApp VALUES()";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, a.getUserid());
			pstmt.setInt(3, 0);
			pstmt.setDouble(4, 0);
			pstmt.setString(5, username);
			
			
			int rowsUpdated = pstmt.executeUpdate();				
			conn.commit();

		} catch (SQLException e) {


			e.printStackTrace();

		}
		return account;
	}

	@Override
	public ArrayList<Account> GetFunds(User a) {
		ArrayList<Account> custAccounts = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{CALL get_user_accounts(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, a.getUserid());
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);

			while(rs.next()) {
				Account account = new Account();
				account.setBank_id(rs.getInt("bank_id"));
				account.setUser_id(rs.getInt("user_id"));
				account.setUser_number(rs.getInt("user_number"));
				account.setCredbalance(rs.getDouble("credbalance"));
				account.setUser_account(rs.getString("user_account"));
				custAccounts.add(account);
			}
	} catch (SQLException e) {
		e.printStackTrace();

	} return custAccounts;
	
	}

	@Override
	public double getCredbalance(Account acct) {

		
		Account credbalance = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT credbalance FROM BankApp WHERE user_number = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acct.getUser_number());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				credbalance.setCredbalance(rs.getDouble(1));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return credbalance.getCredbalance();
		
	}
}
	