package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class reimbursementDaoImpl implements reimbursementDao{

	public Reimbursement newReimbursement(User u, Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			Date date = new Date();
			//String sql = "{CALL newReimbursement(?,?,?,?,?)}";
			String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT, REIMB_SUBMITTED,\r\n" + 
					"    REIMB_DESC, REIMB_AUTHOR, REIMB_TYPE_ID) \r\n" + 
					"    VALUES (?, ?,?, ?,?)";
			//CallableStatement cstmt = conn.prepareCall(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, r.getAmount());
			pstmt.setTimestamp(2, new Timestamp(date.getTime()));
			pstmt.setString(3, r.getDescription());
			pstmt.setLong(4, u.getUserid());
			pstmt.setLong(5, r.getTypeId());
			
			ResultSet rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	//made but deemed unneccessary
	public void removeReimbursement(User u, Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "DELETE FROM ERS_REIMBURSEMENT WHERE REIMB_ID = ? AND REIMB_AUTHOR = ? AND REIMB_STATUS_ID = 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, r.getReimbId());
			pstmt.setLong(2, u.getUserid());
			
			ResultSet rs = pstmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Reimbursement> getPastReimbursements(User u) {
		ArrayList<Reimbursement> theReimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?"
					+ "AND NOT REIMB_STATUS_ID = 1 ORDER BY REIMB_SUBMITTED DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, u.getUserid());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getLong(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitTime(rs.getTimestamp(3));
				temp.setResolveTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthorId(rs.getLong(6));
				temp.setResolverId(rs.getLong(7));
				temp.setStatusId(rs.getLong(8));
				temp.setTypeId(rs.getLong(9));
				theReimbs.add(temp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return theReimbs;
	}


	@Override
	public ArrayList<Reimbursement> getReimbursements(User u) {
		ArrayList<Reimbursement> theReimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ? ORDER BY REIMB_SUBMITTED DESC";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, u.getUserid());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getLong(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitTime(rs.getTimestamp(3));
				temp.setResolveTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthorId(rs.getLong(6));
				temp.setResolverId(rs.getLong(7));
				temp.setStatusId(rs.getLong(8));
				temp.setTypeId(rs.getLong(9));
				theReimbs.add(temp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return theReimbs;
	}

	@Override
	public void updateStatus(User u, long code, Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			Date date = new Date();
			String sql = "{CALL updateStatus(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setLong(1, code);
			cstmt.setLong(2, r.getReimbId());
			cstmt.setTimestamp(3, new Timestamp(date.getTime()));
			cstmt.setLong(4, u.getUserid());
			
			ResultSet rs = cstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateType(User u, Reimbursement r) {
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "{CALL updateType(?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setLong(1, r.getStatusId());
			cstmt.setLong(2, r.getReimbId());
			cstmt.setLong(3, u.getUserid());
			
			ResultSet rs = cstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reimbursement> getEditReimbursements(User u) {
		ArrayList<Reimbursement> theReimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT WHERE"
					+ " REIMB_STATUS_ID = 1 AND NOT REIMB_AUTHOR  = ? ORDER BY REIMB_SUBMITTED";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, u.getUserid());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getLong(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitTime(rs.getTimestamp(3));
				temp.setResolveTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthorId(rs.getLong(6));
				temp.setResolverId(rs.getLong(7));
				temp.setStatusId(rs.getLong(8));
				temp.setTypeId(rs.getLong(9));
				theReimbs.add(temp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return theReimbs;
	}
	@Override
	public ArrayList<Reimbursement> getAllReimbursements(User u) {
		ArrayList<Reimbursement> theReimbs = new ArrayList<Reimbursement>();
		try(Connection conn = ConnectionFactory.getInstanceMethod().getConnection()){
			String sql = "SELECT * FROM ERS_REIMBURSEMENT ORDER BY REIMB_SUBMITTED DESC";
			Statement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setReimbId(rs.getLong(1));
				temp.setAmount(rs.getDouble(2));
				temp.setSubmitTime(rs.getTimestamp(3));
				temp.setResolveTime(rs.getTimestamp(4));
				temp.setDescription(rs.getString(5));
				temp.setAuthorId(rs.getLong(6));
				temp.setResolverId(rs.getLong(7));
				temp.setStatusId(rs.getLong(8));
				temp.setTypeId(rs.getLong(9));
				theReimbs.add(temp);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return theReimbs;
	}


}
