package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.AccountMenu;
import com.revature.MainMenu;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account createAccount(Account account, User user) {
		Account acc = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO accounts (balance, ownerid) VALUES (?, ?)";
			
			String[] keys = new String[1];
			keys[0] = "accountid";
			
			
			PreparedStatement pstat = conn.prepareStatement(sql, keys);
			
			pstat.setDouble(1, account.getBalance());
			pstat.setInt(2, user.getUserId());
			
			int success = pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			
			if (success != 0) {
				while (rs.next()) {
					acc.setAccountId(rs.getInt(1));
					acc.setOwnerId(user.getUserId());
				}
				acc.setBalance(0.0);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured while creating account for user " + user.getUserId() + ". Please try again.");
			AccountMenu.accountMenu(account);
		}
		return acc;
	}
	
	@Override
	public Account getAccountByUser(User user) {
		Account acc = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM accounts WHERE ownerid = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, user.getUserId());
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt(1));
				temp.setBalance(rs.getDouble("balance"));
				temp.setOwnerId(rs.getInt("ownerid"));
				acc = temp;
			}
		} catch (SQLException e) {
			System.out.println("Error occured while retrieving account for user " + user.getUserId() + ". Please try again.");
			MainMenu.mainMenu();
		}
		return acc;
	}

	@Override
	public Account getAccountById(int accountid) {
		Account acc = new Account();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM accounts WHERE accountid = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, accountid);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				acc.setAccountId(rs.getInt(1));
				acc.setOwnerId(rs.getInt("ownerid"));
				acc.setBalance(rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			System.out.println("Error occured while retrieving account. Please try again.");
			MainMenu.mainMenu();
		}
		return acc;
	}

	@Override
	public boolean deposit(int accountid, double value) {
		Account acc = new Account();
		AccountDAOImpl accDAO = new AccountDAOImpl();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			acc = accDAO.getAccountById(accountid);
			double currBalance = acc.getBalance();
			double newBalance = currBalance + value;
			
			String sql = "UPDATE accounts SET balance = ? WHERE accountid = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, String.valueOf(newBalance));
			pstat.setInt(2, accountid);
			
			int success = pstat.executeUpdate();
			
			if (success != 0) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error occured while making deposit. Please try again.");
			AccountMenu.accountMenu(acc);
		}
		return false;
	}

	@Override
	public boolean withdraw(int accountid, double value) {
		Account acc = new Account();
		AccountDAOImpl accDAO = new AccountDAOImpl();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			acc = accDAO.getAccountById(accountid);
			double currBalance = acc.getBalance();
			double newBalance = currBalance - value;
			
			String sql = "UPDATE accounts SET balance = ? WHERE accountid = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, String.valueOf(newBalance));
			pstat.setInt(2, accountid);
			
			int success = pstat.executeUpdate();
			
			if (success != 0) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error occured while making withdrawal. Please try again.");
			AccountMenu.accountMenu(acc);
		}
		return false;
	}

	@Override
	public boolean checkUsername(String username) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, username);
			
			ResultSet rs = pstat.executeQuery();
			
			if(rs.next()) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean checkEmail(String email) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM users WHERE email = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, email);
			
			ResultSet rs = pstat.executeQuery();
			
			if(rs.next()) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM accounts";
			
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				Account temp = new Account();
				temp.setAccountId(rs.getInt(1));
				temp.setBalance(rs.getDouble("balance"));
				temp.setOwnerId(rs.getInt("ownerid"));
				accounts.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured while retrieving accounts.");
			AccountMenu.accountMenu(new Account());
		}
		return accounts;
	}

	public double getAverageBalance() {
		double avgBalance = 0.00;
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "{? = call balance_average()}";
			
			CallableStatement cstat = conn.prepareCall(sql);
			cstat.registerOutParameter(1, OracleTypes.NUMBER);
			cstat.executeQuery();
			
			avgBalance = cstat.getDouble(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error while executing function.");
			MainMenu.mainMenu();
		}
		return avgBalance;
	}

}
