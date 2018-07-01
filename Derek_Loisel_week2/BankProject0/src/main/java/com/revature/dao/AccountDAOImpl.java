package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.util.ConnectionFactory;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public Account addAccount(Account newAccount) {

		Account account = new Account();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			//conn.setAutoCommit(false);
			
			String sql = "INSERT INTO account (checkingbalance, savingsbalance) VALUES (?, ?)";
					
			//an array of string objects that will take IN the primary keys that's generated WHEN you put the artist in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1 for the name
			keys[0] = "accountid";  //you could then set keys[1] = "column" if there was another column you were keeping track of
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back because you want to keep track of the key for the artist
			pstmt.setDouble(1, -999999999);
			pstmt.setDouble(2, -999999999);
			
			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated
			
			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set
			
			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					account.setAccountID(rs.getInt(1));
				}
				
				//set the variables for the account object your returning 
				//account.setCheckingBalance(-999999999);
				//account.setSavingsBalance(-999999999);
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

}
