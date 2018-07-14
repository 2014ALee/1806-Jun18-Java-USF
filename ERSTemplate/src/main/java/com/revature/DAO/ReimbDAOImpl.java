package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.revature.DAO.ReimbDao;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class ReimbDAOImpl implements ReimbDao{

	@Override
	public ArrayList<Reimbursement> getAllReimbursements() {

		
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION,"
					+" REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID"
					+ " FROM ERS_REIMBURSEMENT";

			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {

				int REIMB_ID = rs.getInt(1);
				double REIMB_AMOUNT = rs.getDouble("REIMB_AMOUNT");
				Timestamp REIMB_SUBMITTED = rs.getTimestamp("REIMB_SUBMITTED");
				Timestamp REIMB_RESOLVED = rs.getTimestamp("REIMB_RESOLVED");
				String REIMB_DESCRIPTION = rs.getString("REIMB_DESCRIPTION");

				int REIMB_AUTHOR = rs.getInt("REIMB_AUTHOR");
				int REIMB_RESOLVER = rs.getInt("REIMB_RESOLVER");
				
				int REIMB_STATUS_ID = rs.getInt("REIMB_STATUS_ID");
				int REIMB_TYPE_ID = rs.getInt("REIMB_TYPE_ID");
		
				
				//we get our actual status and types here and set them to the member objects of the user
	
				Reimbursement reimb = new Reimbursement(REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,
						REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER,
						REIMB_STATUS_ID, REIMB_TYPE_ID);
						
				reimbs.add(reimb);
			}
			
		return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean addReimbursement(Reimbursement newReimb, User user) {
		
		String reimbDescription = newReimb.getDescription();
		Double reimbAmount = newReimb.getReimbursementAmount();
		int reimbTypeID = getReimbursementID(newReimb.getTypeName());
		int reimbStatusID = 1;
		Timestamp submittedTimeStamp = new Timestamp(System.currentTimeMillis());
		Timestamp resolvedTimeStamp = null;
		int reimbAuthor = user.getUserID();
		int reimbResolver = user.getUserID();
		
	try(Connection con = ConnectionFactory.getInstance().getConnection()){
		
		String sql = "INSERT INTO ERS_REIMBURSEMENT(REIMB_AMOUNT ,REIMB_SUBMITTED ,REIMB_RESOLVED ,REIMB_DESCRIPTION"
				+ " ,REIMB_AUTHOR,REIMB_RESOLVER ,REIMB_STATUS_ID,REIMB_TYPE_ID)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setDouble(1, reimbAmount);
		statement.setTimestamp(2, submittedTimeStamp);
		statement.setTimestamp(3, resolvedTimeStamp);
		statement.setString(4, reimbDescription);			
		statement.setInt(5, reimbAuthor);
		statement.setInt(6, reimbResolver);
		statement.setInt(7, reimbStatusID);
		statement.setInt(8, reimbTypeID);
		
		statement.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		return false;
	}
	
	private static int getReimbursementID(String typeName) {
	
		typeName = typeName.toLowerCase();
		if(typeName == "lodging") {
			return 1;
		} else if(typeName == "travel") {
			return 2;
		} else if(typeName == "food") {
			return 3;
		} else {
			return 4;
		}
		
	}
	
//this gets a user's past tickets	
	@Override
	public ArrayList<Reimbursement> getReimbursements(User newUser) {
		int userID = newUser.getUserID();
		
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION,"
					+" REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID"
					+ " FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, userID);

			ResultSet rs = statement.executeQuery();

			
			while(rs.next()) {

				int REIMB_ID = rs.getInt(1);
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
		
				
				//we get our actual status and types here and set them to the member objects of the user
	
				Reimbursement reimb = new Reimbursement(REIMB_ID,REIMB_AMOUNT,REIMB_SUBMITTED,
						REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER,
						REIMB_STATUS_ID, REIMB_TYPE_ID);
				//Strint statusName = 
					//	String typeName = 
						
				reimbs.add(reimb);
			}
			
		return reimbs;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Reimbursement> filterReimbByStatus(ArrayList<Reimbursement> reimbursements, String status) {
		
		for(int i = 0; i < reimbursements.size(); i++) {
			if(!reimbursements.get(i).getStatusName().equals(status)) {
				reimbursements.remove(i);
			}
		}
		
		return reimbursements;
	}

	@Override
	public boolean approveOrDenyReimb(Reimbursement newReimb, String approveOrDeny) {
		
		if(approveOrDeny == "denied") {
			newReimb.setStatusName("denied");
			newReimb.setStatusID(3);
			return true;
			
		}  else if(approveOrDeny == "approved") {
			newReimb.setStatusName("approved");
			newReimb.setStatusID(2);
			return true;
		}
		
		return false;	
	}


}
