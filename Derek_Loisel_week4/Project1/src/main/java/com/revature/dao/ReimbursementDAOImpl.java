package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO{

	@Override
	public Reimbursement addReimbursement(Reimbursement newReimbursement) {
		
		Reimbursement r = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			//an array of string objects that will take in the primary keys that's generated when you put the account in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1
			keys[0] = "reimb_id";  

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back 
			pstmt.setDouble(1, newReimbursement.getReimbursementAmount());
			pstmt.setDate(2, newReimbursement.getReimbursementSubmitted());
			pstmt.setDate(3, newReimbursement.getReimbursementResolved());
			pstmt.setString(4, newReimbursement.getReimbursementDescription());
			pstmt.setBlob(5, newReimbursement.getReimbursementReceipt());
			pstmt.setInt(6, newReimbursement.getReimbursementAuthor());
			pstmt.setInt(7, newReimbursement.getReimbursementResolver());
			pstmt.setInt(8, newReimbursement.getReimbursementStatusID());
			pstmt.setInt(9, newReimbursement.getReimbursementTypeID());

			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated

			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set

			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					r.setReimbursementID(rs.getInt(1));
				}

				//set the variables for the reimbursement object your returning 
				r.setReimbursementAmount(newReimbursement.getReimbursementAmount());
				r.setReimbursementSubmitted(newReimbursement.getReimbursementSubmitted());
				r.setReimbursementResolved(newReimbursement.getReimbursementResolved());
				r.setReimbursementDescription(newReimbursement.getReimbursementDescription());
				r.setReimbursementReceipt(newReimbursement.getReimbursementReceipt());
				r.setReimbursementAuthor(newReimbursement.getReimbursementAuthor());
				r.setReimbursementResolver(newReimbursement.getReimbursementResolver());
				r.setReimbursementStatusID(newReimbursement.getReimbursementStatusID());
				r.setReimbursementTypeID(newReimbursement.getReimbursementTypeID());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public boolean updateReimbursementByReimbursementID(Reimbursement updatedReimbursement) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_receipt = ? WHERE reimb_id = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDate(1,  updatedReimbursement.getReimbursementResolved());
			pstmt.setDouble(2,  updatedReimbursement.getReimbursementResolver());
			pstmt.setBlob(3,  updatedReimbursement.getReimbursementReceipt());
			pstmt.setInt(4,  updatedReimbursement.getReimbursementID());
			
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
