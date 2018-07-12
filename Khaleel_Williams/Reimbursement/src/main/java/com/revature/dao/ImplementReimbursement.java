package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.util.MakeConnection;

import oracle.jdbc.OracleTypes;

public class ImplementReimbursement implements ReimbursementInterface {

	@Override
	public boolean addReimbursement(Reimbursement newReimb) {
		int rowsUpdated = 0;

		try(Connection conn = MakeConnection.getConnectionInstance().createConnection()){

			String sql = "INSERT INTO reimbursement VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setInt(1, newReimb.getReimbId());
			prepare.setDouble(2, newReimb.getAmount());
			prepare.setTimestamp(3, newReimb.getSubmitted());
			prepare.setTimestamp(4, newReimb.getResolved());
			prepare.setString(5, newReimb.getDescription());
			prepare.setBlob(6, newReimb.getReceipt());
			prepare.setInt(7, newReimb.getAuthor());
			prepare.setInt(8, newReimb.getResolver());
			prepare.setInt(9, newReimb.getStatusId());
			prepare.setInt(10, newReimb.getTypeId());


			rowsUpdated = prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception check) {
			System.out.println("There was an Exception in addReimbursement dao method");
		}

		if (rowsUpdated != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<Reimbursement> getPastReimbById(int userId) {
		ArrayList<Reimbursement> allMyReimb= new ArrayList<Reimbursement>();

		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){

			String sql = "{CALL getPastReimbById(?, ?)}";

			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, userId);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			call.execute();
			boolean bool = false;

			ResultSet results = (ResultSet) call.getObject(2);

			while(results.next()) {
				bool = true;
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbId(results.getInt(1));
				reimb.setAmount(results.getDouble(2));
				reimb.setSubmitted(results.getTimestamp(3));
				reimb.setResolved(results.getTimestamp(4));
				reimb.setDescription(results.getString(5));
				reimb.setReceipt(results.getBlob(6));
				reimb.setAuthor(results.getInt(7));
				reimb.setResolver(results.getInt(8));
				reimb.setStatusId(results.getInt(9));
				reimb.setTypeId(results.getInt(10));
				
				allMyReimb.add(reimb);
			}

			if (bool) {return allMyReimb;}
			else {return null;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception check) {
			System.out.println("There was an Exception in getPastReimbById dao method");
		}
		return null;
	}

	@Override
	public boolean update(Timestamp resolvedTimestamp, int resolverId, int statusId) {
		
		int rowsUpdated = 0;
		
		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "UPDATE reimbursement SET resolved = ?, resolver = ?, status_id = ? ";
			
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setTimestamp(1, resolvedTimestamp);
			prepare.setInt(2, resolverId);
			prepare.setInt(3, statusId);
			
			rowsUpdated = prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception check) {
			System.out.println("There was an Exception in update dao method");
		}
		
		if (rowsUpdated != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		
		ArrayList<Reimbursement> allReim = new ArrayList<Reimbursement>();
		
		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "SELECT * FROM reimbursements";
			
			Statement state = conn.createStatement();
			ResultSet results = state.executeQuery(sql);
			
			while(results.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimbId(results.getInt(1));
				reimb.setAmount(results.getDouble(2));
				reimb.setSubmitted(results.getTimestamp(3));
				reimb.setResolved(results.getTimestamp(4));
				reimb.setDescription(results.getString(5));
				reimb.setReceipt(results.getBlob(6));
				reimb.setAuthor(results.getInt(7));
				reimb.setResolver(results.getInt(8));
				reimb.setStatusId(results.getInt(9));
				reimb.setTypeId(results.getInt(10));
				
				allReim.add(reimb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception check) {
			System.out.println("There was an Exception in getAllReimbursement dao method");
		}
		
		return allReim;
	}

	@Override
	public ArrayList<Reimbursement> filterReimbursements(int status) {
		
		ArrayList<Reimbursement> allReimb = getAllReimbursements();
		ArrayList<Reimbursement> filteredReimb = new ArrayList();
		
		for (Reimbursement reimb : allReimb) {
			
			if (status == reimb.getStatusId()) {
				filteredReimb.add(reimb);
			} else {
				continue;
			}
		}
		return filteredReimb;
	}


}
