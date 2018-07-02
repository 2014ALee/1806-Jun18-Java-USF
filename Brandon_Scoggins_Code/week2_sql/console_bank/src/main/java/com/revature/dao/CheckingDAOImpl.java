package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.CheckingAccount;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class CheckingDAOImpl implements CheckingAccountDAO{

	AccountsDAO accountsDAO = new AccountsDAOImpl();
	
	@Override
	public double getCheckingBalance(User currentUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean depositChecking(User currentUser, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean withdrawChecking(User currentUser, double amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override		// creates a new checking account. A separate method will pair the newest checking account to a main account
	public boolean createChecking(User currentUser) {
		
		boolean success = false;
		
		System.out.println("Creating a checking account for " + currentUser.getUserName() + "...");
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO checkingAccounts (accountId) VALUES (NULL)";

			Statement stmt = conn.createStatement();

			success = !stmt.execute(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("Checking account created for " + currentUser.getUserName());
			return true;
		}else {
			System.out.println("Failed to create checking account for " + currentUser.getUserName());
			return false;
		}
	}

	@Override
	public boolean deleteChecking(User currentUser) {
		
		int checkingId = accountsDAO.getUserCheckingId(currentUser.getUserId());
		System.out.println("got checking id. Attempting to delete..");
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			System.out.println("before delete");
			String sql = "DELETE FROM checkingAccounts WHERE accountId = ?";
			System.out.println("after delete");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, checkingId);
			
			if (!pstmt.execute()) {
				System.out.println("Checking account successfully deleted.");
				return true;
			}else {
				System.out.println("Checking account not deleted.");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("after if statement");
		return false;		
	}

	@Override
	public ArrayList<CheckingAccount> getAllCheckingAccounts() {
		
		ArrayList<CheckingAccount> allCheckingAccounts = new ArrayList<>();
		System.out.println("getting all checking accounts");
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM checkingAccounts ORDER BY accountId";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				allCheckingAccounts.add(new CheckingAccount(rs.getInt(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("retrieved all checking accounts");
		return allCheckingAccounts;
	}

	@Override
	public boolean pairCheckingToAccount(User currentUser) {
		
		System.out.println("Pairing checking account to current user...");
		
		int newestCheckingId = 0;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT MAX(accountId) FROM checkingAccounts";
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			rs.next();
			newestCheckingId = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE accounts SET checkingId = ? WHERE accountHolderId = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newestCheckingId);
			pstmt.setInt(2, currentUser.getUserId());

			if(pstmt.executeUpdate() != 0) {
				System.out.println("Checking account paired");
				return true;
			}else {
				System.out.println("Failed to pair checking account ");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
