package com.revature.dao;

import com.revature.models.BankAccount;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.StringHandler;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BankUserDAOImplementation implements BankUserDAO {

	@Override
	public BankAccount getBankUserByUsername(String username) {
		ArrayList<BankAccount> users = new ArrayList<BankAccount>();
		
		/* 
		 * Try block (same layout as from demo) to get the account based
		 * on the username. This is useful because we want to know if user
		 * exists (when an account is being registered) and compare
		 * login information while a user is logging on. This is currently
		 * case insensitive since we don't want two accounts to have usernames
		 * with such an extent of similarity.
		 */
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL fetch_bankuser_by_username(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, username);
			cstmt.registerOutParameter(2,  OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while (rs.next()) {
				users.add(BankAccount.fromDB(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// If the user doesn't exist we'll get a null
		if (users.size() == 0) {
			return null;
		}
		// If there is somehow more than one user
		// with the same name then we see if there
		// is one with matching upper/lower case.
		for (BankAccount bnkAcc : users) {
			if (bnkAcc.getUsername().equals(username)) {
				return bnkAcc;
			}
		}
		// Otherwise we just return the first one we got.
		return users.get(0);
	}
	
	/*
	 * Prepared statement to add user to the BankUsers table.
	 * It's prepared for insert statements where strings can
	 * be passed in.
	 */
	@Override
	public boolean addBankUser(String username, String password) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			// Preparing the statement here.
			String sql = "INSERT INTO BankUser (Username, HashedPassword) ";
			sql += "VALUES (?, ?)";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, StringHandler.hash(password));
			int successful = preparedStatement.executeUpdate();
			
			if (successful != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBankUserBalance(BankAccount updatedBankUser) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			// Will use a regular statement for that since the input
			// is a long/int rather than a String.
			String sql = "UPDATE BankUser ";
			sql += "SET NumPennies=" + updatedBankUser.getPennies() + " ";
			sql += "WHERE BankUserId=" + updatedBankUser.getId();
			
			Statement statement = conn.createStatement();
			statement.execute(sql);
			boolean successful = statement.getUpdateCount() > 0;
			if (successful) {
				conn.commit();
			}
			else {
				System.out.println("Update failed.");
			}
			return successful;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
