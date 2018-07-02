package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Transfer;
import com.revature.util.ConnectionFactory;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public boolean addTransfer(Transfer transfer) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "INSERT INTO Transfers (user_id, from_account_id, to_account_id, amount) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, transfer.getUserID());
			ps.setInt(2, transfer.getFromAccountID());
			ps.setInt(3, transfer.getToAccountID());
			ps.setDouble(4, transfer.getAmount());
			
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
	public ArrayList<Transfer> getTransfersForUser(int id) {
		ArrayList<Transfer> transfers = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Transfers WHERE user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transfer temp = new Transfer(rs.getInt("transfer_id"),
											rs.getInt("user_id"),
											rs.getInt("from_account_id"),
											rs.getInt("to_account_id"),
											rs.getDouble("amount"),
											rs.getTimestamp("timestamp"));
				
				transfers.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transfers;
	}

	@Override
	public ArrayList<Transfer> getTransfersForAccount(int id) {
		ArrayList<Transfer> transfers = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT * FROM Transfers WHERE from_account_id = ? OR to_account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.setInt(2, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Transfer temp = new Transfer(rs.getInt("transfer_id"),
											rs.getInt("user_id"),
											rs.getInt("from_account_id"),
											rs.getInt("to_account_id"),
											rs.getDouble("amount"),
											rs.getTimestamp("timestamp"));
				
				transfers.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return transfers;
	}

}
