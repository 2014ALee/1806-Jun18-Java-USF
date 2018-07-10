package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Users;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public Reimbursement getReimb(int id) {
		Reimbursement r = new Reimbursement();
		r.setReimbursement_id(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3));
				r.setResolved(rs.getDate(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatus_id(rs.getInt(9));
				r.setType_id(rs.getInt(10));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbByAuth(Users u) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getUser_id());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3));
				r.setResolved(rs.getDate(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatus_id(rs.getInt(9));
				r.setType_id(rs.getInt(10));
				reimbs.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbByRslvr(Users u) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, u.getUser_id());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3));
				r.setResolved(rs.getDate(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatus_id(rs.getInt(9));
				r.setType_id(rs.getInt(10));
				reimbs.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public Reimbursement addReimb(Reimbursement r) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "reimb_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setInt(1, r.getAmount());
			pstmt.setDate(2, r.getSubmitted());
			pstmt.setDate(3, null);
			pstmt.setString(4, r.getDescription());
			pstmt.setBlob(5, r.getReceipt());
			pstmt.setInt(6, r.getAuthor());
			pstmt.setInt(7, r.getResolver());
			pstmt.setInt(8, r.getStatus_id());
			pstmt.setInt(9, r.getType_id());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					r.setReimbursement_id(rs.getInt(1));
					return r;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement updateReimb(Reimbursement r) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "UPDATE ers_reimbursement SET reimb_amount=?, reimb_submitted=?, reimb_resolved=?, reimb_description=?, reimb_receipt=?, reimb_author=?, reimb_resolver=?, reimb_status_id=?, reimb_type_id=? WHERE reimb_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r.getAmount());
			pstmt.setDate(2, r.getSubmitted());
			pstmt.setDate(3, r.getResolved());
			pstmt.setString(4, r.getDescription());
			pstmt.setBlob(5, r.getReceipt());
			pstmt.setInt(6, r.getAuthor());
			pstmt.setInt(7, r.getResolver());
			pstmt.setInt(8, r.getStatus_id());
			pstmt.setInt(9, r.getType_id());
			pstmt.setInt(10, r.getReimbursement_id());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				return r;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbursement_id(rs.getInt(1));
				temp.setAmount(rs.getInt(2));
				temp.setSubmitted(rs.getDate(3));
				temp.setResolved(rs.getDate(4));
				temp.setDescription(rs.getString(5));
				temp.setReceipt(rs.getBlob(6));
				temp.setAuthor(rs.getInt(7));
				temp.setResolver(rs.getInt(8));
				temp.setStatus_id(rs.getInt(9));
				temp.setType_id(rs.getInt(10));
				reimbs.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}
	
	public ArrayList<Reimbursement> getReimbsByStatus(int stat) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stat);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setAmount(rs.getInt(2));
				r.setSubmitted(rs.getDate(3));
				r.setResolved(rs.getDate(4));
				r.setDescription(rs.getString(5));
				r.setReceipt(rs.getBlob(6));
				r.setAuthor(rs.getInt(7));
				r.setResolver(rs.getInt(8));
				r.setStatus_id(rs.getInt(9));
				r.setType_id(rs.getInt(10));
				reimbs.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

}
