package com.revature.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;

public class UserDB implements UserDAO{


	@Override
	public User GetUser(User a) {
		
		User newuser = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "SELECT * FROM users WHERE username = ? AND pass_word = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				newuser.setUserid(rs.getInt(1));
				newuser.setUsername(a.getUsername());
				newuser.setPassword(a.getPassword());
				newuser.setEmail(rs.getString(4));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return newuser;
	}
// Need to set false in this method to see if it is true or not.
	// needed to add a string array and also needed to have an update so the rows would be properly updated.
	
	@Override
	public User AddUser(User a) {
		
		User newuser = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
	
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO users(username, pass_word, email) VALUES (?, ?, ? )";
			String[] place = new String[1];
			
			place[0] = "user_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, place);
			
			
			pstmt.setString(1, a.getUsername());
			pstmt.setString(2, a.getPassword());
			pstmt.setString(3, a.getEmail());
			
			int rowsUpdated = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while (rs.next()) {
					a.setUserid(rs.getInt(1));
				}
				
				newuser.setUsername(a.getUsername());
				newuser.setPassword(a.getPassword());
				newuser.setEmail(a.getEmail());
				
				conn.commit();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newuser;
	}
		@Override
		public boolean updateUser(User updatedUser) {
		
		return false;
		}
		
		@Override
		public User createUser(User b) {
			User newUser = new User();
			try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
				
				String sql = "{ CALL register_user(?, ?, ?, ?, ?) }";
				
				CallableStatement cstmt = conn.prepareCall(sql);
				
				cstmt.setString(1, b.getFirstName());
				cstmt.setString(2, b.getLastName());
				cstmt.setString(3, b.getUsername());
				cstmt.setString(4, b.getPassword());
				cstmt.setString(5, b.getEmail());
				
				ResultSet rs = cstmt.executeQuery();
				
			}	catch (SQLException e) {

				e.printStackTrace();
			}
			return newUser;
		}
}

