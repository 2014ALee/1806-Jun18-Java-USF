package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {

	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> usersList = new ArrayList<>();

		//create a connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//create statement object
			Statement stmt = conn.createStatement();

			
			String sql = "SELECT * FROM ers_users ORDER BY ers_users_id";

			
			ResultSet rs = stmt.executeQuery(sql);

			// loop through result set and add row to user arraylist
			while(rs.next()) { 

				//create an artist object to represent each row
				User temp = new User();
				//add the row contents to the user object
				temp.setErs_users_id(rs.getInt("ers_users_id"));  
				temp.setErs_username(rs.getString("ers_username"));
				temp.setErs_password(rs.getString("ers_password"));
				temp.setUser_first_name(rs.getString("user_first_name"));
				temp.setUser_last_name(rs.getString("user_last_name"));
				temp.setUser_email(rs.getString("user_email"));
				temp.setUser_role_id(rs.getInt("user_role_id"));
				
				usersList.add(temp);			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}
	

	public User GetUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
		public User addUser(User newUser) {
			
			User u = new User();

			try(Connection conn = ConnectionFactory.getInstance().getConnection();){

				String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, "
						+ "user_email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";

				
				String[] keys = new String[7]; 
				keys[0] = "ers_users_id";  
				keys[1] = "ers_username";
				keys[2] = "ers_password";
				keys[3] = "user_first_name";
				keys[4] = "user_last_name";
				keys[5] = "user_email";
				keys[6] = "user_role_id";
				
				PreparedStatement pstmt = conn.prepareStatement(sql, keys);  			
				pstmt.setString(1, newUser.getErs_username());
				pstmt.setString(2, newUser.getErs_password());
				pstmt.setString(3, newUser.getUser_first_name());
				pstmt.setString(4, newUser.getUser_last_name());
				pstmt.setString(5, newUser.getUser_email());
				pstmt.setInt(6, newUser.getUser_role_id());
				
				int rowsUpdated = pstmt.executeUpdate(); 

				ResultSet rs = pstmt.getGeneratedKeys(); 

				if(rowsUpdated != 0) {
					// if any rows were updated, you get the key for it in the result set
					while(rs.next()) {
						u.setErs_users_id(rs.getInt(1));
					}

					//set the variables for the account object your returning 
					u.setErs_username(rs.getString("ers_username"));
					u.setErs_password(rs.getString("ers_password"));
					u.setUser_first_name(rs.getString("user_first_name"));
					u.setUser_last_name(rs.getString("user_last_name"));
					u.setUser_email(rs.getString("user_email"));
					u.setUser_role_id(rs.getInt("user_role_id"));

				} else {
					System.out.println("hello");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return u;
		}
	
	

	public User getUserByUsername(User newUser) {
		
		User temp = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newUser.getErs_username()); 

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				temp.setErs_users_id(rs.getInt("ers_users_id"));  
				temp.setErs_username(rs.getString("ers_username"));
				temp.setErs_password(rs.getString("ers_password"));
				temp.setUser_first_name(rs.getString("user_first_name"));
				temp.setUser_last_name(rs.getString("user_last_name"));
				temp.setUser_email(rs.getString("user_email"));
				temp.setUser_role_id(rs.getInt("user_role_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}


	@Override
	public User getUserByEmail(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User AddUser(User newUser) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User updateUser(User u) {
		User updatedUser = new User();
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ers_users SET user_first_name = ?, user_last_name = ?, user_email = ?, ers_username = ?, ers_password = ?, user_role_id = ? "
					+ "WHERE ers_users_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUser_first_name());
			pstmt.setString(2, u.getUser_last_name());
			pstmt.setString(3, u.getUser_email());
			pstmt.setString(4, u.getErs_username());
			pstmt.setString(5, u.getErs_password());
			pstmt.setInt(6, u.getUser_role_id());

			
			int rowsUpdated = pstmt.executeUpdate();
			
			if(rowsUpdated != 0) {
				conn.commit();
				updatedUser = getUserByUsername(u);
			}
			
		}
		
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return updatedUser;

	}

}
