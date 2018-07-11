package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;

public  class UserDaoImp implements UserDao {

	@Override
	public ArrayList<User> getAllUsers() {
		
		ArrayList<User> users = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select * From ers_users order by ers_user_id";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				User temp = new User();
				temp.setErs_user_id(rs.getInt(1));
				temp.setErs_first_name(rs.getString("ers_first_name"));		
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
			
			String sql = "Select *From ers_users Where ers_users_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				user.setErs_user_id(id);
				user.setErs_username(rs.getString(2));
			}	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	// The below getUserByName will be used to get user by username
	@Override
	public User getUserByName(String name) {

		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){
			String sql = "Select *From ers_users where ers_username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			ResultSet rs = pstmt.executeQuery()	;
			
			while(rs.next()) {
				user.setErs_username(name);
				user.setErs_user_id(rs.getInt(1));
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
			
			String query = "INSERT INTO ers_users(ers_first_name,ers_Last_name,ers_username,ers_password,ers_email,ers_role_id) values(?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "ers_user_id";
			
			PreparedStatement pst = conn.prepareStatement(query);

			pst.setString(1, newUser.getErs_first_name());
			pst.setString(2, newUser.getErs_Last_name());
			pst.setString(3, newUser.getErs_username());
			pst.setString(4, newUser.getErs_password());
			pst.setString(5, newUser.getErs_email());
			pst.setInt(6, newUser.getErs_role_id());

			//pst.executeUpdate();
			
			int rowUpdated = pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if(rowUpdated != 0) {
				 while(rs.next()) {
					 newUsers.setErs_user_id(rs.getInt(1));
				 }
				 }
				 newUsers.setErs_username(newUser.getErs_username());
				 newUsers.setErs_Last_name(newUser.getErs_Last_name());
				 newUsers.setErs_first_name(newUser.getErs_first_name());
				 newUsers.setErs_password(newUser.getErs_password());
				 newUsers.setErs_email(newUser.getErs_email());
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
		
		String sql = "Update ers_users set ers_first_name = ?, ers_Last_name =?, ers_username =?, ers_password =?, ers_email =?, ers_role_id=? where ers_user_id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, updatedUser.getErs_first_name());
		pstmt.setString(2, updatedUser.getErs_Last_name());
		pstmt.setString(3, updatedUser.getErs_username());
		pstmt.setString(4, updatedUser.getErs_password());
		pstmt.setString(5, updatedUser.getErs_email());
		pstmt.setInt(6, updatedUser.getErs_role_id());
		pstmt.setInt(7, updatedUser.getErs_user_id());
		
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

}
