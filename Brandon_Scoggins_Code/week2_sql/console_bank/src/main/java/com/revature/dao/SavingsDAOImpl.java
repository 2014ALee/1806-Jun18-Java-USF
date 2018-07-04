package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.SavingsAccount;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class SavingsDAOImpl implements SavingsAccountDAO{

	AccountsDAO accountsDAO = new AccountsDAOImpl();
	TransactionDAO transactionDAO = new TransactionDAOImpl();
	
	@Override
	public double getSavingsBalanceByUser(User currentUser) {
		
		int userSavingsId = accountsDAO.getUserSavingsId(currentUser.getUserId());
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT balance FROM savingsAccounts WHERE accountId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userSavingsId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getDouble(1);
			}else {
				System.out.println("unable to get savings balance");
				return 0.0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public double getSavingsBalanceByAccountId(int accountId) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT balance FROM savingsAccounts WHERE accountId = ("
					+ "SELECT savingsId FROM accounts WHERE accountId = ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, accountId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getDouble(1);
			}else {
				System.out.println("unable to get savings balance");
				return 0.0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean depositSavings(User currentUser, int targetAccountId, double amount) {
		// can deposit into any account you have access to 
		
		// check if user has access to target account
		// in menu, check if amount is positive before calling this method
		// also verify format
		
		ArrayList<User> authorizedUsers = accountsDAO.getAllAccountUsers(targetAccountId);
		
		boolean userAuthorized = false;
		
		for (User authorizedUser : authorizedUsers) {
			if(authorizedUser.getUserId() == currentUser.getUserId()) {
				System.out.println("User " + currentUser.getUserId() + " is authorized to deposit");
				userAuthorized = true;
				break;
			}
		}
		
		double newAmount = 0.0;
		
		if(userAuthorized) {
			
			newAmount = getSavingsBalanceByAccountId(targetAccountId) + amount;
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "UPDATE savingsAccounts SET balance = ? WHERE accountId = ("
						+ "Select savingsId FROM accounts WHERE accountId = ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setDouble(1, newAmount);
				pstmt.setInt(2, targetAccountId);
				System.out.println("Depositing $" + amount + " into savings account " + targetAccountId);
				if(pstmt.executeUpdate() != 0) {
					System.out.println("deposit successful\n");
					return true;
				}else {
					System.out.println("deposit failed\n");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean withdrawSavings(User currentUser, int targetAccountId, double amount) {
		// can withdraw from any account you have access to 
		
		// check if user has access to target account
		// in menu, check if amount is positive before calling this method
		// also verify format
		
		ArrayList<User> authorizedUsers = accountsDAO.getAllAccountUsers(targetAccountId);
		
		boolean userAuthorized = false;
		
		for (User authorizedUser : authorizedUsers) {
			if(authorizedUser.getUserId() == currentUser.getUserId()) {
				System.out.println("User " + currentUser.getUserId() + " is authorized to withdraw");
				userAuthorized = true;
				break;
			}
		}
		
		double newAmount = 0.0;
		
		if(userAuthorized) {
			
			newAmount = getSavingsBalanceByAccountId(targetAccountId) - amount;
			
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "UPDATE savingsAccounts SET balance = ? WHERE accountId = ("
						+ "Select savingsId FROM accounts WHERE accountId = ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);

				pstmt.setDouble(1, newAmount);
				pstmt.setInt(2, targetAccountId);
				System.out.println("Withdrawing $" + amount + " from savings account " + targetAccountId);
				if(pstmt.executeUpdate() != 0) {
					System.out.println("withdraw successful\n");
					return true;
				}else {
					System.out.println("withdraw failed\n");
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override		// creates a new savings account. A separate method will pair the newest savings account to a main account
	public boolean createSavings(User currentUser) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT savingsId FROM accounts WHERE accountHolderId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUser.getUserId());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				rs.getInt(1);
				if(!rs.wasNull()) {
					System.out.println("User " + currentUser.getUserId() + " already has a savings account");
					return false;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		boolean success = false;
		
		System.out.println("Creating a savings account for " + currentUser.getUserName() + "...");
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO savingsAccounts (accountId) VALUES (NULL)";

			Statement stmt = conn.createStatement();

			success = !stmt.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("Savings account created for " + currentUser.getUserName());
			pairSavingsToAccount(currentUser);
			return true;
		}else {
			System.out.println("Failed to create savings account for " + currentUser.getUserName());
			return false;
		}
	}

	@Override
	public boolean deleteSavings(User currentUser) {
		
		int savingsId = accountsDAO.getUserSavingsId(currentUser.getUserId());
		System.out.println("got savings id. Attempting to delete..");
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("before delete");
			String sql = "DELETE FROM savingsAccounts WHERE accountId = ?";
			System.out.println("after delete");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, savingsId);
			
			if (!pstmt.execute()) {
				System.out.println("Savings account successfully deleted.");
				return true;
			}else {
				System.out.println("Savings account not deleted.");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("after if statement");
		return false;		
	}

	@Override
	public ArrayList<SavingsAccount> getAllSavingsAccounts() {
		
		ArrayList<SavingsAccount> allSavingsAccounts = new ArrayList<>();
		System.out.println("getting all savings accounts");
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM savingsAccounts ORDER BY accountId";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				allSavingsAccounts.add(new SavingsAccount(rs.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("retrieved all savings accounts");
		return allSavingsAccounts;
	}

	@Override
	public boolean pairSavingsToAccount(User currentUser) {
		
		System.out.println("Pairing savings account to current user...");
		
		int newestSavingsId = 0;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT MAX(accountId) FROM savingsAccounts";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			newestSavingsId = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE accounts SET savingsId = ? WHERE accountHolderId = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newestSavingsId);
			pstmt.setInt(2, currentUser.getUserId());

			if(pstmt.executeUpdate() != 0) {
				System.out.println("Savings account paired");
				return true;
			}else {
				System.out.println("Failed to pair savings account ");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
