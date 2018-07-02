package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.JointAccount;
import com.revature.util.ConnectionFactory;

public class JointAccountDAOImpl implements JointAccountDAO {

	@Override
	public JointAccount getJointAccountByUserID(int id) {

		JointAccount ja = new JointAccount();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM jointaccount WHERE user1id = ? OR user2id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); 
			pstmt.setInt(2, id);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				ja.setJointID(rs.getInt(1));
				ja.setUser1ID(rs.getInt("user1id"));
				ja.setUser2ID(rs.getInt("user2id"));
				ja.setJointBalance(rs.getDouble("jointbalance"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ja;
	}


	@Override
	public JointAccount addJointAccount(JointAccount newJointAccount) {

		JointAccount ja = new JointAccount();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO jointaccount (user1id, user2id, jointbalance) VALUES (?, ?, ?)";

			//an array of string objects that will take IN the primary keys that's generated WHEN you put the joint account in
			String[] keys = new String[1];
			keys[0] = "jointid";  //you could then set keys[1] = "column" if there was another column you were keeping track of

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); 
			pstmt.setInt(1, newJointAccount.getUser1ID());
			pstmt.setDouble(2, newJointAccount.getUser2ID());
			pstmt.setDouble(3, newJointAccount.getJointBalance()); 

			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated

			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set

			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					ja.setJointID(rs.getInt(1));
				}
				//set the variables for the account object your returning 
				ja.setUser1ID(newJointAccount.getUser1ID());
				ja.setUser2ID(newJointAccount.getUser2ID());
				ja.setJointBalance(newJointAccount.getJointBalance());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ja;
	}

	public boolean updateJointBalanceByJointID(int jointID, double newBalance) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE jointaccount SET jointbalance = ? WHERE jointid = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,  newBalance);
			pstmt.setInt(2,  jointID);
			
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
