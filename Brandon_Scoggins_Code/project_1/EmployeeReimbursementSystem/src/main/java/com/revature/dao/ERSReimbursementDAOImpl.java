package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ERSReimbursement;
import com.revature.models.ERSUser;
import com.revature.util.ConnectionFactory;

public class ERSReimbursementDAOImpl implements ERSReimbursementsDAO {

	@Override
	public boolean createReimbursement(ERSReimbursement newReim) {

		try (Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "INSERT INTO ersReimbursement (reimAmount, reimDescription,"
					+ "reimAuthor, reimStatusId, reimTypeId) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, newReim.getReimAmount());
			pstmt.setString(2, newReim.getReimDescription());
			pstmt.setInt(3, newReim.getReimAuthor());
			pstmt.setInt(4, newReim.getReimStatusId());
			pstmt.setInt(5, newReim.getReimTypeId());
			
			if(pstmt.executeUpdate() != 0) {
				System.out.println("\nReimbursement creationg succesful!\n");
				return true;
			}else {
				System.out.println("\nReimbursement creation failed.\n");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean cancelReimbursement(ERSReimbursement reimToCancel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approveReimbursement(ERSReimbursement approvedReim, ERSUser currentUser) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE ersReimbursement SET reimResolver = ?, reimStatusId = ? WHERE reimId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUser.getUserId());
			pstmt.setInt(2, 3);
			pstmt.setInt(3, approvedReim.getReimId());
			
			if(pstmt.executeUpdate() != 0) {
				System.out.println("\nApproval succesful!\n");
				return true;
			}else {
				System.out.println("\nApproval failed.\n");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean denyReimbursement(ERSReimbursement deniedReim, ERSUser currentUser) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE ersReimbursement SET reimResolver = ?, reimStatusID = ? WHERE reimId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUser.getUserId());
			pstmt.setInt(2, 4);
			pstmt.setInt(3, deniedReim.getReimId());
			
			if(pstmt.executeUpdate() != 0) {
				System.out.println("\nDenial succesful!\n");
				return true;
			}else {
				System.out.println("\nDenial failed.\n");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean viewReimbursement(ERSReimbursement viewedReim, ERSUser currentUser) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "UPDATE ersReimbursement SET reimResolver = ?, reimStatusId = ? WHERE reimId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUser.getUserId());
			pstmt.setInt(2, 2);
			pstmt.setInt(3, viewedReim.getReimId());
			
			if(pstmt.executeUpdate() != 0) {
				System.out.println("\nView succesful!\n");
				return true;
			}else {
				System.out.println("\nView failed.\n");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ERSReimbursement getReimbursementByReimId(int reimId) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			String sql = "SELECT * FROM ersReimbursement WHERE reimId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reimId);
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
			return new ERSReimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3).toString(),
					(rs.getDate(4) != null) ? rs.getDate(4).toString() : (String) null,
					rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursements() {

		ArrayList<ERSReimbursement> allReimbursements = new ArrayList<>();
		ArrayList<ERSReimbursement> allReimbursementsStrings = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ersReimbursement ORDER BY reimSubmitted DESC";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				allReimbursements.add(new ERSReimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3).toString(),
						(rs.getDate(4) != null) ? rs.getDate(4).toString() : (String) null,
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			
			for (ERSReimbursement reim : allReimbursements) {
				sql = "SELECT reimStatus FROM ersReimbursementStatus WHERE reimStatusId = ?";
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reim.getReimStatusId());
				
				rs = pstmt.executeQuery();
				
				rs.next();
				String status = rs.getString(1);
				
				sql = "SELECT reimType FROM ersReimbursementType WHERE reimTypeId = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, reim.getReimTypeId());
				
				rs = pstmt.executeQuery();
				
				rs.next();
				String type = rs.getString(1);
				
				allReimbursementsStrings.add(new ERSReimbursement(reim.getReimId(), reim.getReimAmount(), 
						reim.getReimSubmitted(), reim.getReimResolved(), reim.getReimDescription(), 
						reim.getReimAuthor(), reim.getReimResolver(), status, type));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allReimbursementsStrings;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByStatus(String reimStatus) {
		ArrayList<ERSReimbursement> allReimbursementsByStatus = new ArrayList<>();
		
		for (ERSReimbursement reim : getAllReimbursements()) {
			if (reim.getReimStatusString().equals(reimStatus)) {
				allReimbursementsByStatus.add(reim);
			}
		}
		return allReimbursementsByStatus;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByType(String reimType) {
		ArrayList<ERSReimbursement> allReimbursementsByType = new ArrayList<>();
		
		for (ERSReimbursement reim : getAllReimbursements()) {
			if (reim.getReimTypeString().equals(reimType)) {
				allReimbursementsByType.add(reim);
			}
		}
		return allReimbursementsByType;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByUserId(int reimUserId) {
		ArrayList<ERSReimbursement> allReimbursementsByUser = new ArrayList<>();
		
		for (ERSReimbursement reim : getAllReimbursements()) {
			if (reim.getReimAuthor() == reimUserId) {
				allReimbursementsByUser.add(reim);
			}
		}
		return allReimbursementsByUser;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByUserNameOrEmail(String userNameOrEmail) {
		ERSUsersDAO usersDao = new ERSUsersDAOImpl(); 
		return getAllReimbursementsByUserId(usersDao.getUserId(userNameOrEmail));
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByRole(int roleId) {
		ERSUsersDAO usersDao = new ERSUsersDAOImpl();
		ArrayList<ERSReimbursement> allReimbursementsByRoleId = new ArrayList<>();
		
		for (ERSUser user : usersDao.getAllUsersByRole(roleId)) {
			allReimbursementsByRoleId.addAll(getAllReimbursementsByUserId(user.getUserId()));
		}
		return allReimbursementsByRoleId;
	}

}
