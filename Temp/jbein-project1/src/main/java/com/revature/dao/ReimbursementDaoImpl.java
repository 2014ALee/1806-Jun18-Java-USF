package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class ReimbursementDaoImpl implements ReimbursementDao {


	@Override
	public boolean addReimbursement(Reimbursement reimb) {
		Reimbursement r = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			String[] keys = new String[1];
			keys[0] = "reimb_id";  

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back 
			pstmt.setDouble(1, reimb.getReimb_amount());
			pstmt.setDate(2, reimb.getReimb_submitted());
			pstmt.setDate(3, reimb.getReimb_resolved());
			pstmt.setString(4, reimb.getReimb_description());
			pstmt.setBlob(5, reimb.getReimb_receipt());
			pstmt.setInt(6, reimb.getReimb_author());
			pstmt.setInt(7, reimb.getReimb_resolver());
			pstmt.setInt(8, reimb.getReimb_status_id());
			pstmt.setInt(9, reimb.getReimb_type_id());

			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated

			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set

			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					r.setReimb_id(rs.getInt(1));
				}

				//set the variables for the reimbursement object youre returning 
				r.setReimb_amount(reimb.getReimb_amount());
				r.setReimb_submitted(reimb.getReimb_submitted());
				r.setReimb_resolved(reimb.getReimb_resolved());
				r.setReimb_description(reimb.getReimb_description());
				r.setReimb_receipt(reimb.getReimb_receipt());
				r.setReimb_author(reimb.getReimb_author());
				r.setReimb_resolver(reimb.getReimb_resolver());
				r.setReimb_status_id(reimb.getReimb_status_id());
				r.setReimb_type_id(reimb.getReimb_type_id());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	@Override
	public boolean updateReimbursement(Reimbursement reimb) {
		Reimbursement r = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "UPDATE ers_reimbursement SET reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?,"
					+ " reimb_description = ?, reimb_receipt = ?, reimb_author = ?, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, reimb.getReimb_amount());
			pstmt.setDate(2, reimb.getReimb_submitted());
			pstmt.setDate(3, reimb.getReimb_resolved());
			pstmt.setString(4, reimb.getReimb_description());
			pstmt.setBlob(5, reimb.getReimb_receipt());
			pstmt.setInt(6, reimb.getReimb_author());
			pstmt.setInt(7, reimb.getReimb_resolver());
			pstmt.setInt(8, reimb.getReimb_status_id());
			
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
	public ArrayList<Reimbursement> getReimbursementsById(int userID) {
		
		ArrayList<Reimbursement> rl = new ArrayList<Reimbursement>();
		 
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userID); 

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getDouble("reimb_amount"));
				r.setReimb_submitted(rs.getDate("reimb_submitted"));
				r.setReimb_resolved(rs.getDate("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				r.setReimb_receipt(rs.getBlob("reimb_receipt"));
				r.setReimb_author(rs.getInt("reimb_author"));
				r.setReimb_resolver(rs.getInt("reimb_resolver"));
				r.setReimb_status_id(rs.getInt("reimb_status_id"));
				r.setReimb_type_id(rs.getInt("reimb_type_id"));
				rl.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rl;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementsByUserID(int ers_users_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Reimbursement getReimbursement(int reimb_id) {
		// TODO Auto-generated method stub
		return null;
	}


	// SMOOTH THIS OUT
	
	@Override
	public ArrayList<Reimbursement> getReimbursementsByAuthor(int authorId) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";
			String[] keys = new String[1];
			keys[0] = "reimb_id";
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, authorId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimb_id(rs.getInt("REIMB_ID"));
				temp.setReimb_amount(rs.getInt("REIMB_AMOUNT"));
				temp.setReimb_submitted(rs.getDate("REIMB_SUBMITTED"));
				temp.setReimb_resolved(rs.getDate("REIMB_RESOLVED"));
				temp.setReimb_description(rs.getString("REIMB_DESCRIPTION"));
				temp.setReimb_receipt(rs.getBlob("REIMB_RECEIPT"));
				temp.setReimb_author(rs.getInt("REIMB_AUTHOR"));
				temp.setReimb_resolver(rs.getInt("REIMB_RESOLVER"));
				temp.setReimb_status_id(rs.getInt("REIMB_STATUS_ID"));
				temp.setReimb_type_id(rs.getInt("REIMB_TYPE_ID"));
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("error in sql statement");
			e.printStackTrace();
		}
		return reimbs;
	}

}
