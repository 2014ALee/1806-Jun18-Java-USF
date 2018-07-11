package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.model.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDaoImp implements ReimbursementDao {

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		
		ArrayList<Reimbursement> reimbursements = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select * From ers_reimbursement order by reimb_id";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimb_id(rs.getInt(1));
				temp.setReimb_description(rs.getString("reimb_description"));		
				reimbursements.add(temp);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursements;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		
		Reimbursement reimbursement = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "Select *From ers_reimbursement Where reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				reimbursement.setReimb_id(id);
				reimbursement.setReimb_description(rs.getString(2));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}
	
	// below method will get reimbursement by author id

	@Override
	public Reimbursement getReimbursementByName(String name) {
		
		Reimbursement reimbursement = new Reimbursement();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select *From ers_reimbursement where reimb_description = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				reimbursement.setReimb_description(name);
				reimbursement.setReimb_id(rs.getInt(1));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement newReimbursement) {

		Reimbursement reimbursement = new Reimbursement();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String query = "INSERT INTO ers_reimbursement(reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) values(?,?,?,?,?,?,?,?,?)";

			String[] keys = new String[1];
			keys[0] = "reimb_id";

			PreparedStatement pst = conn.prepareStatement(query);

			pst.setDouble(1, newReimbursement.getReimb_amount());
			pst.setDate(2, (Date) newReimbursement.getReimb_submitted());
			pst.setDate(3, (Date) newReimbursement.getReimb_resolved());
			pst.setString(4, newReimbursement.getReimb_description());
			pst.setBlob(5, newReimbursement.getReimb_receipt());
			pst.setInt(6, newReimbursement.getReimb_author());
			pst.setInt(7, newReimbursement.getReimb_resolver());
			pst.setInt(8, newReimbursement.getReimb_status_id());
			pst.setInt(9, newReimbursement.getReimb_type_id());

			//pst.executeUpdate();

			int rowUpdated = pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();

			if(rowUpdated != 0) {
				while(rs.next()) {
					reimbursement.setReimb_id(rs.getInt(1));
				}
			}
			reimbursement.setReimb_amount(newReimbursement.getReimb_amount());
			reimbursement.setReimb_submitted(newReimbursement.getReimb_submitted());
			reimbursement.setReimb_resolved(newReimbursement.getReimb_resolved());
			reimbursement.setReimb_description(newReimbursement.getReimb_description());
			reimbursement.setReimb_receipt(newReimbursement.getReimb_receipt());
			reimbursement.setReimb_author(newReimbursement.getReimb_author());
			reimbursement.setReimb_resolver(newReimbursement.getReimb_resolver());
			reimbursement.setReimb_status_id(newReimbursement.getReimb_status_id());
			reimbursement.setReimb_type_id(newReimbursement.getReimb_type_id());
		}

		catch(SQLException e) {
			e.printStackTrace();
		}

		return reimbursement;
	}

	@Override
	public boolean updateReimbursement(Reimbursement updatedReimbursement) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "Update ers_reimbursement set reimb_amount = ?, reimb_submitted =?, reimb_resolved =?, reimb_description =?, reimb_receipt =?, reimb_author=?, reimb_resolver =?, reimb_status_id =?, reimb_type_id =? where reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setDouble(1, updatedReimbursement.getReimb_amount());
			pstmt.setDate(2,(Date) updatedReimbursement.getReimb_submitted());
			pstmt.setDate(3, (Date) updatedReimbursement.getReimb_resolved());
			pstmt.setString(4, updatedReimbursement.getReimb_description());
			pstmt.setBlob(5, updatedReimbursement.getReimb_receipt());
			pstmt.setInt(6, updatedReimbursement.getReimb_author());
			pstmt.setInt(7, updatedReimbursement.getReimb_resolver());
			pstmt.setInt(8, updatedReimbursement.getReimb_status_id());
			pstmt.setInt(9, updatedReimbursement.getReimb_type_id());
			pstmt.setInt(10, updatedReimbursement.getReimb_id());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeReimbursementById(Reimbursement reimbursementForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeReimbursementByName(String reimbursementName) {
		// TODO Auto-generated method stub
		return false;
	}

}
