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
	public ArrayList<User> getAllUsers() {

		ArrayList<User> usersList = new ArrayList<>();

		//create a connection
		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			//create an object for the type of statement you want to make
			Statement stmt = conn.createStatement();

			//create a string that holds the query you want to run
			String sql = "SELECT * FROM ers_users ORDER BY ers_users_id";

			//execute the query into a result set object
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) { //while the results has a next value, we want to loop

				//create an artist object to represent each row
				User temp = new User();
				//add the row contents to the user object
				temp.setUserID(rs.getInt("ers_users_id")); //identifying column by column name string 
				temp.setUsername(rs.getString("ers_username"));
				temp.setPassword(rs.getString("ers_password"));
				temp.setFirstname(rs.getString("user_first_name"));
				temp.setLastname(rs.getString("user_last_name"));
				temp.setEmail(rs.getString("user_email"));
				temp.setUserRoleID(rs.getInt("user_role_id"));
				//add the user object (row) to your array
				usersList.add(temp);			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	@Override
	public User getUserByUsername(String username) {
		User u = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT * FROM ers_users WHERE ers_username = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username); 

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				u.setUserID(rs.getInt(1));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstname(rs.getString("user_first_name"));
				u.setLastname(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setUserRoleID(rs.getInt("user_role_id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}

	@Override
	public User getUserByUsernameCallable(String username) {
		User u = new User();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();){

			String sql = "{CALL get_user_by_username(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);

			//setting params is same as prepared statement
			cstmt.setString(1, username);

			//define the index of our second param and its type which is curosr
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);

			cstmt.execute()	; //returns boolean could catch this boolean if we wanted to 

			ResultSet rs = (ResultSet) cstmt.getObject(2); //we are expecting to get the cursor back which is the second param

			while(rs.next()) {

				u.setUserID(rs.getInt(1));
				u.setUsername(rs.getString("ers_username"));
				u.setPassword(rs.getString("ers_password"));
				u.setFirstname(rs.getString("user_first_name"));
				u.setLastname(rs.getString("user_last_name"));
				u.setEmail(rs.getString("user_email"));
				u.setUserRoleID(rs.getInt("user_role_id"));				
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

			String sql = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) VALUES (?, ?, ?, ?, ?, ?)";

			//an array of string objects that will take IN the primary keys that's generated WHEN you put the user in
			String[] keys = new String[1];// the 1 IS how many columns we're keeping track of keys for, here its only 1 
			keys[0] = "ers_users_id";  //you could then set keys[1] = "column" if there was another column you were keeping track of

			PreparedStatement pstmt = conn.prepareStatement(sql, keys); //pass in the sql statement as well as the keys you want to get back 			
			pstmt.setString(1, newUser.getUsername());
			pstmt.setString(2, newUser.getPassword());
			pstmt.setString(3, newUser.getFirstname());
			pstmt.setString(4, newUser.getLastname());
			pstmt.setString(5, newUser.getEmail());
			pstmt.setInt(6, newUser.getUserRoleID());

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
				u.setFirstname(newUser.getFirstname());
				u.setLastname(newUser.getLastname());
				u.setEmail(newUser.getEmail());
				u.setUserRoleID(newUser.getUserRoleID());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}