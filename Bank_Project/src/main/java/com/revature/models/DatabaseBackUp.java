package com.revature.models;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.revature.models.BankAccount;
import com.revature.models.User;
import com.revature.models.interfaces.DatabaseBackUpInterface;
import com.revature.util.ConnectionFactory;

public class DatabaseBackUp implements DatabaseBackUpInterface {

	@Override
	public TreeMap<String, User> getUsers() {

		TreeMap <String, User> users = new TreeMap<>();

		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "SELECT USERNAME, USERPASSWORD, FIRSTNAME, LASTNAME, BALANCE"
					+ " FROM USERS";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while(rs.next()) {

				String userName = rs.getString("USERNAME");
				String password = rs.getString("USERPASSWORD");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				Double balance = rs.getDouble("BALANCE");


				User newUser = new User(firstName, lastName, userName, password);

				BankAccount newAccount = newUser.getBankAccount();
				newAccount.setBalance(balance);
				newUser.setBankAccount(newAccount);

				users.put(userName, newUser);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}



	@Override
	public boolean registerAccount(User newUser, BankAccount newAccount) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "INSERT INTO USERS (UserName, UserPassword, FirstName, LastName, Balance)\r\n" + 
					"VALUES(?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setString(1, newAccount.getUserName());
			statement.setString(2, newAccount.getPassword());
			statement.setString(3, newUser.getFirstName());
			statement.setString(4, newUser.getLastName());
			statement.setDouble(5, newAccount.getBalance());

			statement.executeUpdate();
			
			return true;

		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setBalance(double newBalance, User currentUser, BankAccount currentAccount) {

		try(Connection con = ConnectionFactory.getInstance().getConnection();){

			String sql = "UPDATE USERS SET BALANCE = ? WHERE USERNAME = ?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setDouble(1, newBalance);
			statement.setString(2, currentAccount.getUserName());

			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
]	
	}

	@Override
	public double adminViewTotalBalance() {
	
		try(Connection con = ConnectionFactory.getInstance().getConnection();){
			String sql = "{CALL totalBalance(?)}";
					
			CallableStatement statement = con.prepareCall(sql);
			statement.registerOutParameter(1, java.sql.Types.NUMERIC);
					
			statement.execute();	
			
			double totalBankBalance = statement.getDouble(1);
			
			System.out.println("Total balance is: $" + totalBankBalance);
			
			return totalBankBalance;
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		}

	}

}
