package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ERSUser;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.OracleTypes;

public class ERSUsersDAOImpl implements ERSUsersDAO{

	@Override
	public ERSUser logInUser(String userNameOrEmail, String passWord) {

		ERSUser loggedInUser = new ERSUser();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{CALL log_in_user(?, ?, ?)}";

			CallableStatement cstmt = conn.prepareCall(sql);

			cstmt.setString(1, userNameOrEmail);
			cstmt.setString(2, passWord);

			cstmt.registerOutParameter(3, OracleTypes.CURSOR);

			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(3);

			if(rs.next()) {
				loggedInUser.setUserId(rs.getInt(1));
				loggedInUser.setUserName(rs.getString(2));
				loggedInUser.setPassWord(rs.getString(3));
				loggedInUser.setFirstName(rs.getString(4));
				loggedInUser.setLastName(rs.getString(5));
				loggedInUser.setEmail(rs.getString(6));
				loggedInUser.setUserRoleId(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedInUser;
	}

	@Override
	public boolean userExist(String userNameOrEmail) {
		int numOfUsers = 0;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM ersUsers WHERE userName = ? OR email = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNameOrEmail);
			pstmt.setString(2, userNameOrEmail);

			numOfUsers = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		if(numOfUsers == 0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String[] createUser(ERSUser newUser) {

		if (userExist(newUser.getUserName())) {
			System.out.println("User already exist. Creation aborted.");
			return new String[] {"false", "0"};
		} else if (userExist(newUser.getEmail())) {
			System.out.println("User already exist. Creation aborted.");
			return new String[] {"false", "1"};
		} else {
			System.out.println("User credentials available. Creating..\n");
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "INSERT INTO ersUsers (userName, passWord, firstName, lastName, email, userRoleId) VALUES (?, ?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newUser.getUserName());
				pstmt.setString(2, newUser.getPassWord());
				pstmt.setString(3, newUser.getFirstName());
				pstmt.setString(4, newUser.getLastName());
				pstmt.setString(5, newUser.getEmail());
				pstmt.setInt(6, newUser.getUserRoleId());

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return new String[]{"true", "0"};
		}
	}

	@Override
	public boolean deleteUser(ERSUser deleteUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(ERSUser updatedUser) {

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE ersUsers SET userName = ?,"
					+ " passWord = ?, firstName = ?,"
					+ " lastName = ?, email = ?, userRoleId = ?"
					+ " WHERE userId = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, updatedUser.getUserName());
			pstmt.setString(2, updatedUser.getPassWord());
			pstmt.setString(3, updatedUser.getFirstName());
			pstmt.setString(4, updatedUser.getLastName());
			pstmt.setString(5, updatedUser.getEmail());
			pstmt.setInt(6, updatedUser.getUserRoleId());
			pstmt.setInt(7, updatedUser.getUserId());

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
	public ArrayList<ERSUser> getAllUsers() {

		ArrayList<ERSUser> allUsers = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM ersUsers ORDER BY userId";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				allUsers.add(new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUsers;
	}
	
	@Override
	public ArrayList<ERSUser> getAllUsersByRole(int roleId) {
		ArrayList<ERSUser> allUsersByRole = new ArrayList<>();
		
		for (ERSUser user : getAllUsers()) {
			if (user.getUserRoleId() == roleId) {
				allUsersByRole.add(user);
			}
		}
		return allUsersByRole;
	}

	@Override
	public int getUserId(String userNameOrEmail) {

		int userId = 0;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT userId FROM ersUsers WHERE (userName = ? OR email = ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userNameOrEmail);
			pstmt.setString(2, userNameOrEmail);
			
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				userId = rs.getInt(1);
				System.out.println("\nFound userId.\n");
			} else {
				System.out.println("\nUserId not found.\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userId;
	}

	
}
