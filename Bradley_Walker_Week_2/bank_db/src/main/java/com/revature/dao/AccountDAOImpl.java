package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account addAccount(int userID, Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Accounts (account_name, balance) VALUES(?, ?)";


			String[] keys = {"account_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1, account.getAccountName());
			ps.setDouble(2, account.getBalance());


			int rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if(rowsAffected == 0)
				return null;
			else {
				rs.next();
				account.setAccountID(rs.getInt(1));
			}

			sql = "INSERT INTO UserHasAccount VALUES (?, ?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, userID);
			ps.setInt(2, account.getAccountID());

			rowsAffected = ps.executeUpdate();

			if(rowsAffected == 0) {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	@Override
	public Account getAccountByID(int id) {
		Account account = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Accounts WHERE account_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				account.setAccountID(rs.getInt("account_id"));
				account.setAccountName(rs.getString("account_name"));
				account.setBalance(rs.getDouble("balance"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

	@Override
	public boolean updateAccount(Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "UPDATE Accounts "
					+ "SET account_name = ?, balance = ?"
					+ "WHERE account_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, account.getAccountName());
			ps.setDouble(2, account.getBalance());
			ps.setInt(3, account.getAccountID());

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
	public Account addJointAccount(int userID1, int userID2, Account account) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Accounts (account_name, balance) VALUES(?, ?)";


			String[] keys = {"account_id"};
			PreparedStatement ps = conn.prepareStatement(sql, keys);

			ps.setString(1, account.getAccountName());
			ps.setDouble(2, account.getBalance());


			int rowsAffected = ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();

			if(rowsAffected == 0)
				return null;
			else {
				rs.next();
				account.setAccountID(rs.getInt(1));
			}

			sql = "INSERT INTO UserHasAccount VALUES (?, ?)";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, userID1);
			ps.setInt(2, account.getAccountID());

			rowsAffected = ps.executeUpdate();

			if(rowsAffected == 0)
				return null;

			ps = conn.prepareStatement(sql);

			ps.setInt(1, userID2);
			ps.setInt(2, account.getAccountID());

			rowsAffected = ps.executeUpdate();

			if(rowsAffected == 0)
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	}

}
