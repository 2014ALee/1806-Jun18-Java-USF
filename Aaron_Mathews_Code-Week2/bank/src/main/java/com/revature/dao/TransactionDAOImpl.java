package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.AccountMenu;
import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.util.ConnectionFactory;

public class TransactionDAOImpl implements TransactionDAO {
	
	@Override
	public Transaction createTransaction(Transaction newTransaction) {
		
		Transaction trans = new Transaction();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO transactions (accountid, amount) VALUES (?, ?)";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, newTransaction.getAccountid());
			pstat.setDouble(2, newTransaction.getAmount());
			
			int success = pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			
			if (success != 0) {
				while (rs.next()) {
					trans.setTransactionid(rs.getInt(1));
				}
				trans.setAccountid(newTransaction.getAccountid());
				trans.setAmount(newTransaction.getAmount());
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trans;
	}

	@Override
	public ArrayList<Transaction> getAllTransaction(Account account) {
		ArrayList<Transaction> allTransactions = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM transactions WHERE accountid = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, account.getAccountId());
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Transaction temp = new Transaction();
				temp.setTransactionid(rs.getInt(1));
				temp.setAccountid(rs.getInt("accountid"));
				temp.setAmount(rs.getDouble("amount"));
				allTransactions.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured while retrieving transactions. Please try again.");
			AccountMenu.accountMenu(account);
		}
		return allTransactions;
	}

}
