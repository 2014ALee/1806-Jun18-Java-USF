package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;



public class UserDAOImpl implements UserDAO {

	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select * From allusers order by user_id";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setFirstName(rs.getString("first_name"));		
				users.add(temp);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String sql = "Select *From Allusers Where user_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				user.setUserId(id);
				user.setUsername(rs.getString(2));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	

	@Override
	public User getUserByName(String name) {
		
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select *From allusers where username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				user.setUsername(name);
				user.setUserId(rs.getInt(1));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User addUser(User newUser) {
		//String firstName = null, lastName = null, username = null, password = null, email = null;
		
		User newUsers = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			String query = "INSERT INTO allUsers(first_name,last_name,username,password,email) values(?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "user_id";
			
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(1, newUser.getFirstName());
			pst.setString(2, newUser.getLastName());
			pst.setString(3, newUser.getUsername());
			pst.setString(4, newUser.getPassword());
			pst.setString(5, newUser.getEmail());

			//pst.executeUpdate();
			
			int rowUpdated = pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rowUpdated != 0) {
				 while(rs.next()) {
					 newUsers.setUserId(rs.getInt(1));
				 }
				 }
				 newUsers.setUsername(newUser.getUsername());
				 newUsers.setLastName(newUser.getLastName());
				 newUsers.setFirstName(newUser.getFirstName());
				 newUsers.setPassword(newUser.getPassword());
				 newUsers.setEmail(newUser.getEmail());
			}
					
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return newUsers;

	}
		

	@Override
	public boolean updateUser(User updatedUser) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			
			conn.setAutoCommit(false);
			
			String sql = "Update Allusers set first_name = ?, last_name =?, username =?, password =?, email =? where user_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedUser.getFirstName());
			pstmt.setString(2, updatedUser.getLastName());
			pstmt.setString(3, updatedUser.getUsername());
			pstmt.setString(4, updatedUser.getPassword());
			pstmt.setString(5, updatedUser.getEmail());
			pstmt.setInt(6, updatedUser.getUserId());
			
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
	public boolean removeUserById(User userForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUserByName(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Account> getUserAccount(User selectedUser) {
		// TODO Auto-generated method stub
		return null;
	}

		
}

