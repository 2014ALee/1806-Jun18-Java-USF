package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.util.ConnectionFactory;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean addTransaction(Transaction transaction) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Transactions (user_id, account_id, amount) VALUES(?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, transaction.getUserID());
			ps.setInt(2, transaction.getAccountID());
			ps.setDouble(3, transaction.getAmount());
			
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ArrayList<Transaction> getTransactionsForUser(int id) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Transactions WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction temp = new Transaction(rs.getInt("transaction_id"),
													rs.getInt("user_id"),
													rs.getInt("account_id"),
													rs.getDouble("amount"),
													rs.getTimestamp("timestamp"));
				
				transactions.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

	@Override
	public ArrayList<Transaction> getTransactionsForAccount(int id) {
		ArrayList<Transaction> transactions = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Transactions WHERE account_id = ? ORDER BY timestamp";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transaction temp = new Transaction(rs.getInt("transaction_id"),
													rs.getInt("user_id"),
													rs.getInt("account_id"),
													rs.getDouble("amount"),
													rs.getTimestamp("timestamp"));
				
				transactions.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transactions;
	}

}
