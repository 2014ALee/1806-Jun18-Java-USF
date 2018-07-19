package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.util.MakeConnection;

public class ImplementUsers implements UserInterface {

	@Override
	public boolean addUser(Users newUser) {
		
		int rowsUpdated = 0;
		try(Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "INSERT INTO users VALUES(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setInt(1, newUser.getUserId());
			prepare.setString(2, newUser.getUsername());
			prepare.setString(3, newUser.getPassword());
			prepare.setString(4, newUser.getFirstName());
			prepare.setString(5, newUser.getLastName());
			prepare.setString(6, newUser.getEmail());
			prepare.setInt(7, newUser.getRoleId());
			
			 rowsUpdated = prepare.executeUpdate();
			 System.out.println("inside of implementedusers rowsUpdated = " + rowsUpdated);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( rowsUpdated != 0) {
			return true;
			}else {
				return false;
			}
	}

	@Override
	public Users getUserByUsername(String username) {
		
		Users gotUser = new Users();
		boolean bool = false;
		
		try(Connection conn = MakeConnection.getConnectionInstance().createConnection()){

			String sql = "SELECT * FROM users WHERE username = ? ";

			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setString(1, username);
			ResultSet rs = prepare.executeQuery();

			while(rs.next()) {
				bool = true;
				gotUser.setUserId(rs.getInt(1));
				gotUser.setUsername(rs.getString(2));
				gotUser.setPassword(rs.getString(3));
				gotUser.setFirstName(rs.getString(4));
				gotUser.setLastName(rs.getString(5));
				gotUser.setEmail(rs.getString(6));
				gotUser.setRoleId(rs.getInt(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!bool) {
			System.out.println("There is no such user on our records");
			return null;
		}
		return gotUser;
	}

	@Override
	public boolean removeUserByUsername(String username) {
		
		int update = 0;
		
		try(Connection conn = MakeConnection.getConnectionInstance().createConnection()){

			String sql = "DELETE * FROM users WHERE username = ? ";

			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setString(1, username);
			update = prepare.executeUpdate();

			if (update != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
