package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class AccountDaoImpl implements AccountDao{

	@Override
	public ArrayList<Account> GetAccounts(User u) {

		ArrayList<Account> userAccounts = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "{CALL get_user_accounts(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, u.getUserid());
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);

			while(rs.next()) {
				Account account = new Account();
				account.setAccount_id(rs.getInt("account_id"));
				account.setCust_id(rs.getInt("cust_id"));
				account.setAccountNumber(rs.getInt("account_num"));
				account.setBalance(rs.getDouble("balance"));
				account.setAccountType(rs.getString("account_type"));
				userAccounts.add(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userAccounts;
	}

	@Override
	public boolean Deposit(Account account, double depositAmount) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "UPDATE BankAccount SET balance = ? WHERE account_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  (GetBalance(account) + depositAmount));
			pstmt.setDouble(2,  account.getAccountNumber());
			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean Withdraw(Account account, double withdrawalAmount) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE BankAccount SET balance = ? WHERE account_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  (GetBalance(account) - withdrawalAmount));
			pstmt.setDouble(2,  account.getAccount_id());
			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Account createAccount(User u, String accountType) {

		Account account = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			conn.setAutoCommit(false);
			String sql = "INSERT INTO BANKACCOUNT VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0);
			pstmt.setInt(2, u.getUserid());
			pstmt.setInt(3, 0);
			pstmt.setDouble(4, 0);
			pstmt.setString(5, accountType);
			// use execute update because insert is not a query
			int rowsUpdated = pstmt.executeUpdate();				
			conn.commit();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public Account GetAccount(int account_num) {

		Account account = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM BANKACCOUNT WHERE ACCOUNT_NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, account_num);
			ResultSet rs = pstmt.executeQuery();				
			
			while(rs.next()) {
				account.setAccount_id(rs.getInt(1));
				account.setCust_id(rs.getInt(2));
				account.setAccountNumber(rs.getInt(3));
				account.setAccountType(rs.getString(4));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;

	}

	@Override
	public double GetBalance(Account acct) {
		
		Account account = new Account();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT balance FROM BankAccount WHERE account_num = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acct.getAccountNumber());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				account.setBalance(rs.getDouble(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account.getBalance();
	}


}
