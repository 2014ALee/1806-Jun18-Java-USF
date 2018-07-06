package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UsersDAOImpl implements UsersDAO {

	@Override
	public ArrayList<User> getAllUsers() {

		ArrayList<User> usersList = new ArrayList<>();

		//create a connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//create an object for the type of statement you want to make
			Statement stmt = conn.createStatement();

			//create a string that holds the query you want to run
			String sql = "SELECT * FROM users ORDER BY userid";

			//execute the query into a result set object
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //while the results has a next value, we want to loop

				//create an artist object to represent each row
				User temp = new User();
				//add the row contents to the user object
				temp.setUserID(rs.getInt("userid")); //identifying column by column name string 
				temp.setUsername(rs.getString("username"));
				temp.setPassword(rs.getString("pass"));
				temp.setFirstName(rs.getString("firstname"));
				temp.setLastName(rs.getString("lastname"));
				temp.setEmail(rs.getString("email"));

				//add the user object (row) to your array
				usersList.add(temp);			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	@Override
	public User getUserByUsername(User newUser) {

		User u = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM users WHERE username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newUser.getUsername()); 

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				u.setUserID(rs.getInt(1));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pass"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public User addUser(User newUser) {

		User u = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO users (username, pass, firstname, lastname, email) VALUES (?, ?, ?, ?, ?)";

			//an array of string objects that will take IN the primary keys that's generated WHEN you put the user in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1 
			keys[0] = "userid";  //you could then set keys[1] = "column" if there was another column you were keeping track of

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back 			
			pstmt.setString(1, newUser.getUsername());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getFirstName());
			pstmt.setString(4, newUser.getLastName());
			pstmt.setString(5, newUser.getEmail());

			int rowsUpdated = pstmt.executeUpdate(); //this isnt a query, its an update.  it also returns a value that tells you how many rows were updated

			ResultSet rs = pstmt.getGeneratedKeys(); //this is only going to have the keys in the result set

			if(rowsUpdated != 0) {
				// if any rows were updated, you get the key for it in the result set
				while(rs.next()) {
					u.setUserID(rs.getInt(1));
				}

				//set the variables for the account object your returning 
				u.setUsername(newUser.getUsername());
				u.setPassword(newUser.getPassword());
				u.setFirstName(newUser.getFirstName());
				u.setLastName(newUser.getLastName());
				u.setEmail(newUser.getEmail());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int getUserIDByUsername(String username) {
		int id = 0;

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT userid FROM users WHERE username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				id = rs.getInt("userid");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}
	
	@Override
	public boolean deleteUserByUsername(String deletedUsername) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "DELETE FROM users WHERE username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql); //pass in the sql statement as well as the keys you want to get back 			
			pstmt.setString(1, deletedUsername);

			pstmt.executeUpdate(); //this isnt a query, its an update
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
