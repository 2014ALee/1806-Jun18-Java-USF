package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class TransactionDAOImpl implements TransactionDAO{
	UserDAO userDAO = new UserDAOImpl();
	AccountsDAO accountsDAO = new AccountsDAOImpl();

	@Override		
	public ArrayList<Transaction> getTransactionsByUserId(User currentUser, int userId) {

		System.out.println("Displaying transactions by user " + userId + ".\n");

		int userAccountId = accountsDAO.getAccountIdByUser(currentUser);
		ArrayList<Transaction> accountTransactions = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM transactions WHERE (originAccountId = ? "
					+ "OR targetAccountId = ?) AND userId = ? ORDER BY transactionId";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userAccountId);
			pstmt.setInt(2, userAccountId);
			pstmt.setInt(3, userId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				accountTransactions.add(new Transaction(rs.getInt(1), 
						rs.getInt(2), 
						rs.getDouble(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountTransactions;
	}

	@Override		
	public ArrayList<Transaction> getAccountTransactions(User currentUser) {

		int userAccountId = accountsDAO.getAccountIdByUser(currentUser);

		System.out.println("Displaying all account transactions for account " + userAccountId + ".\n");

		ArrayList<Transaction> accountTransactions = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM transactions WHERE originAccountId = ? "
					+ "OR targetAccountId = ? ORDER BY transactionId";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userAccountId);
			pstmt.setInt(2, userAccountId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				accountTransactions.add(new Transaction(rs.getInt(1), 
						rs.getInt(2), 
						rs.getDouble(3), 
						rs.getInt(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getString(7), 
						rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountTransactions;
	}

	@Override			
	public boolean recordTransaction(User currentUser, int originAccount, String originType, int targetAccount, String targetType, double amount) {

		int originAccountId = originAccount;

		System.out.println("\nLogging the transaction from account: " + originAccountId + " (" + originType + ") "
				+ "to account: " + targetAccount + " (" + targetType + ") of amount: $" + amount + "...");

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			if(targetType == null) {
				String sql = "INSERT INTO transactions (userId, amount, originAccountId, "
						+ "originAccountType) VALUES (?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, currentUser.getUserId());
				pstmt.setDouble(2, amount);
				pstmt.setInt(3, originAccountId);
				pstmt.setString(4, originType);

				if(pstmt.executeUpdate() != 0) {
					System.out.println("Withdraw successful!");
					return true;
				}else {
					System.out.println("Withdraw failed.");
					return false;
				}
			}else if(originType == null) {
				String sql = "INSERT INTO transactions (userId, amount, "
						+ "targetAccountId, targetAccountType) VALUES (?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, currentUser.getUserId());
				pstmt.setDouble(2, amount);
				pstmt.setInt(3, targetAccount);
				pstmt.setString(4, targetType);

				if(pstmt.executeUpdate() != 0) {
					System.out.println("Deposit successful!");
					return true;
				}else {
					System.out.println("Deposit failed.");
					return false;
				}
			}else {
				String sql = "INSERT INTO transactions (userId, amount, originAccountId, "
						+ "originAccountType, targetAccountId, targetAccountType) VALUES (?, ?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, currentUser.getUserId());
				pstmt.setDouble(2, amount);
				pstmt.setInt(3, originAccountId);
				pstmt.setString(4, originType);
				pstmt.setInt(5, targetAccount);
				pstmt.setString(6, targetType);

				if(pstmt.executeUpdate() != 0) {
					System.out.println("Transfer successful!");
					return true;
				}else {
					System.out.println("Transfer failed.");
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
