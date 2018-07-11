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
				System.out.println("\nUpdate succesful!\n");
				return true;
			}else {
				System.out.println("\nUpdate failed.\n");
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
			String sql = "UPDATE ersReimbursement SET reimResolver = ?, reimStatus = ? WHERE reimId = ?";
			
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
			String sql = "UPDATE ersReimbursement SET reimResolver = ?, reimStatus = ? WHERE reimId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, currentUser.getUserId());
			pstmt.setInt(2, 4);
			pstmt.setInt(3, deniedReim.getReimId());
			
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
	public ArrayList<ERSReimbursement> getAllReimbursements() {

		ArrayList<ERSReimbursement> allReimbursements = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ersReimbursement ORDER BY reimSubmitted";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				allReimbursements.add(new ERSReimbursement(rs.getInt(1), rs.getDouble(2), rs.getDate(3).toString(),
						rs.getDate(4).toString(), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allReimbursements;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByStatus(int reimStatusId) {
		ArrayList<ERSReimbursement> allReimbursementsByStatus = new ArrayList<>();
		
		for (ERSReimbursement reim : getAllReimbursements()) {
			if (reim.getReimStatusId() == reimStatusId) {
				allReimbursementsByStatus.add(reim);
			}
		}
		return allReimbursementsByStatus;
	}

	@Override
	public ArrayList<ERSReimbursement> getAllReimbursementsByType(int reimTypeId) {
		ArrayList<ERSReimbursement> allReimbursementsByType = new ArrayList<>();
		
		for (ERSReimbursement reim : getAllReimbursements()) {
			if (reim.getReimTypeId() == reimTypeId) {
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
