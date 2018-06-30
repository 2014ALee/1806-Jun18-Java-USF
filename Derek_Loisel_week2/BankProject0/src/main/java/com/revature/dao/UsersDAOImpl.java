package com.revature.dao;

import java.sql.Connection;
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
				temp.setAccountID(rs.getInt("accountid"));
				temp.setJointID(rs.getInt("jointid"));
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

}
