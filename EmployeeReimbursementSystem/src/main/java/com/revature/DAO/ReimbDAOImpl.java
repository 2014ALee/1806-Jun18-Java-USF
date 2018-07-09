package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.DAOInterfaces.ReimbDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.util.ConnectionFactory;

public class ReimbDAOImpl implements ReimbDao{

	@Override
	public ArrayList<Reimbursement> getReimbursements(User newUser) {
		
		return null;
	}

	@Override
	public boolean addReimbursement(Reimbursement newReimb) {
		
		return false;
	}

	public String getReimbursementStatus(User newUser) {
		newUser.getUserID();	
		
		
		return "";
	}
	
	public String getReimbursementType(User newUser) {
		
		return "";
	}
	
	@Override
	public ArrayList<Reimbursement> getAllReimbursements(User newUser) {
		int userID = newUser.getUserID();
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION,"
					+" REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID"
					+ " FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, userID);

			ResultSet rs = statement.executeQuery();

			
			while(rs.next()) {

				int REIMB_ID = rs.getInt("REIMB_ID");
				double REIMB_AMOUNT = rs.getDouble("REIMB_AMOUNT");
				Timestamp REIMB_SUBMITTED = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp REIMB_RESOLVED = rs.getTimestamp("REIMB_RESOLVED");
				String REIMB_DESCRIPTION = rs.getString("REIMB_DESCRIPTION");

				int REIMB_AUTHOR = rs.getInt("REIMB_AUTHOR");
				int REIMB_RESOLVER = rs.getInt("REIMB_RESOLVER");
				
				//these ID's aren't going into our reimbursement object, they are going in their 
				//respective objects
				int REIMB_STATUS_ID = rs.getInt("REIMB_STATUS_ID");
				int REIMB_TYPE_ID = rs.getInt("REIMB_TYPE_ID");

				String reimbStatus = getReimbursementType(REIMB_STATUS_ID);
				String reimbType = getReimbursementType(REIMB_TYPE_ID);
				
				ReimbursementStatus newStatus = new ReimbursementStatus(REIMB_STATUS_ID, reimbStatus);
				ReimbursementType newType = new ReimbursementType(REIMB_TYPE_ID, reimbType);
				
				
				//we still need to get and create the reimbStatus and reimbType objects and store them into here
				Reimbursement reimb = new Reimbursement(REIMB_AMOUNT,REIMB_SUBMITTED,
						REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER,
						newStatus, newType);
			}
			
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> filterReimbByStatus(ArrayList<Reimbursement> reimbursements, String status) {
		
		return null;
	}

	@Override
	public boolean approveOrDenyReimb(Reimbursement newReimb, String approveOrDeny) {
		
		return false;
	}

}
