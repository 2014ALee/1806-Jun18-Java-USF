package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import oracle.jdbc.internal.OracleTypes;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean userExist(String userNameOrEmail) {
		int numOfUsers = 0;
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT * FROM users WHERE userName = ? OR email = ?";
			
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
	public boolean createUser(User newUser) {
		
		if(!userExist(newUser.getUserName()) && !userExist(newUser.getEmail())) {
			System.out.println("User available. Creating..");
			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "INSERT INTO users (firstName, lastName, userName, passWord, email) VALUES (?, ?, ?, ?, ?)";

				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newUser.getFirstName());
				pstmt.setString(2, newUser.getLastName());
				pstmt.setString(3, newUser.getUserName());
				pstmt.setString(4, newUser.getPassWord());
				pstmt.setString(5, newUser.getEmail());

				pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			AccountsDAO accountsDAO = new AccountsDAOImpl();
			accountsDAO.createAccount(newUser);
			return true;
		}else {
			System.out.println("User already exist. Creation aborted.");
			return false;
		}
	}

	@Override
	public boolean deleteUser(User deleteUser) {
		// can only delete the active user. 'logs out' the user after deletion attempt
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "DELETE FROM users WHERE userName = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteUser.getUserName());
			
			if (pstmt.executeUpdate() != 0) {
				System.out.println(deleteUser.getUserName() + " successfully deleted.");
				return true;
			}else {
				System.out.println("User not deleted.");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}

	@Override
	public User logInUser(String userNameOrEmail, String passWord) {
		
		User loggedInUser = new User();
		
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
				loggedInUser.setFirstName(rs.getString(2));
				loggedInUser.setLastName(rs.getString(3));
				loggedInUser.setUserName(rs.getString(4));
				loggedInUser.setPassWord(rs.getString(5));
				loggedInUser.setEmail(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedInUser;
	}

	@Override
	public boolean updateUser(User updatedUser) {
		// can change username, password, or email, but must keep same userId
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "UPDATE users SET firstName = ?,"
					+ " lastName = ?, userName = ?,"
					+ " passWord = ?, email = ?"
					+ " WHERE userId = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatedUser.getFirstName());
			pstmt.setString(2, updatedUser.getLastName());
			pstmt.setString(3, updatedUser.getUserName());
			pstmt.setString(4, updatedUser.getPassWord());
			pstmt.setString(5, updatedUser.getEmail());
			pstmt.setInt(6, updatedUser.getUserId());
			
			if(pstmt.executeUpdate() != 0) {
				System.out.println("update succesful\n");
				return true;
			}else {
				System.out.println("update failed\n");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> allUsers = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "SELECT * FROM users ORDER BY userId";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				allUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}

	@Override
	public int getUserId(User myUser) {

		int myUserId = 0;

		System.out.println("Getting user id for " + myUser.getUserName() + "...");

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "SELECT userId FROM users WHERE userName = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, myUser.getUserName());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return myUserId;
	}

}
