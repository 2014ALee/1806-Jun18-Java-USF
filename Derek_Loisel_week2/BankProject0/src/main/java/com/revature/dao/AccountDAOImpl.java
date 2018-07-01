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

import oracle.jdbc.internal.OracleTypes;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account getAccountByUserID(Account account) {

		Account a = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{CALL get_account_by_userid(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);

			//setting params is same as prepared statement
			cstmt.setInt(1, account.getUserID());

			//define the index of our second param and its type which is curosr
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);

			cstmt.execute()	; //returns boolean could catch this boolean if we wanted to 

			ResultSet rs = (ResultSet) cstmt.getObject(2); //we are expecting to get the cursor back which is the second param

			while(rs.next()) {

				a.setAccountID(rs.getInt("accountid")); 
				a.setUserID(rs.getInt("userid"));
				a.setCheckingBalance(rs.getDouble("checkingbalance"));
				a.setSavingsBalance(rs.getDouble("savingsBalance"));				
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public Account addAccount(Account newAccount) {

		Account account = new Account();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//conn.setAutoCommit(false);

			String sql = "INSERT INTO account (userid, checkingbalance, savingsbalance) VALUES (?, ?, ?)";

			//an array of string objects that will take IN the primary keys that's generated when you put the account in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1
			keys[0] = "accountid";  //you could then set keys[1] = "column" if there was another column you were keeping track of

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back because you want to keep track of the key for the artist
			pstmt.setInt(1, newAccount.getUserID());
			pstmt.setDouble(2, -999999999);
			pstmt.setDouble(3, -999999999);

			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated

			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set

			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					account.setAccountID(rs.getInt(1));
				}

				//set the variables for the account object your returning 
				account.setUserID(newAccount.getUserID());
				account.setCheckingBalance(-999999999);
				account.setSavingsBalance(-999999999);
				//commit
				//conn.commit();

			}//else {
			//				//if it didnt update anything then roll it back
			//				conn.rollback();
			//			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return account;

	}


	@Override
	public boolean updateAccount(Account updatedAccount) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE account SET checkingbalance = ?, savingsbalance = ? WHERE accountid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  updatedAccount.getCheckingBalance());
			pstmt.setDouble(2,  updatedAccount.getSavingsBalance());
			pstmt.setInt(3,  updatedAccount.getAccountID());

			int rowsUpdated = pstmt.executeUpdate();

			if(rowsUpdated != 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}



}
