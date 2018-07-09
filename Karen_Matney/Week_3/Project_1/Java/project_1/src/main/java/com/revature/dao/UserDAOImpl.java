package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAOImpl implements UserDAO {
	@Override
	public User validateUser(User u) {
		ArrayList<User> users = new ArrayList<>();
		User temp = new User();
		
		// Get Connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			// Get password for comparison
			String sql = "SELECT * from users WHERE username = '" + u.getUsername() + "'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// Add to the list of passwords
			while(rs.next()) {
				temp.setUserId(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstName(rs.getString(4));
				temp.setLastName(rs.getString(5));
				temp.setEMail(rs.getString(6));
				getUserRole(temp,rs.getInt(7));
				users.add(temp);
			}
			
			// Check against username
			if(users.size() == 1) {
				if(users.get(0).getPassword().equals(u.getPassword())) {
					temp.setPassword("");
					return temp;
				} else {
					return null;
				}
			} else if (users.size() == 0) {
				// There isn't a matching user
				return null;
				
			} else {
				System.out.println("Check for username duplicates");
				return null;
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
	
	// TODO: convert to regular statement, no reason for prepared
	private void getUserRole(User u,int uid) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "SELECT user_role FROM user_roles WHERE user_role_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, uid);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				u.setUserRole(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}