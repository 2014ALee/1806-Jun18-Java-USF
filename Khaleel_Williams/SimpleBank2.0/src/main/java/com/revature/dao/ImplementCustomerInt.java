package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.model.Customers;
import com.revature.util.MakeConnection;

import oracle.jdbc.OracleTypes;

public class ImplementCustomerInt implements CustomerInterface {

	@Override
	public boolean addCustomer(Customers newCustomer) {
		
		int rowsUpdated = 0;
		
		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "INSERT INTO customers VALUES (?,?,?)";
			
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setString(1, newCustomer.getUserName());
			prepare.setString(2, newCustomer.getPassword());
			prepare.setFloat(3, newCustomer.getBalance());
			rowsUpdated = prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rowsUpdated != 0) {
			return true;
		} else {
		return false;
		}
	}

	@Override
	public Customers getCustomerByUsername(String username) {
		Customers gotCustomer = new Customers();
		
		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "{CALL getUser(?, ?)}";
			
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, username);
			call.registerOutParameter(2, OracleTypes.CURSOR);
			call.execute();
			boolean bool = false;
			
			ResultSet results = (ResultSet) call.getObject(2);
			
			while(results.next()) {
				 bool = true;
				 gotCustomer.setUserName(results.getString(1));
				 gotCustomer.setPassword(results.getString(2));
				 gotCustomer.setBalance(results.getFloat(3));
			}
			
			if (bool) {return gotCustomer;}
			else {return null;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBalance(Customers updateCustomer) {

		try (Connection conn = MakeConnection.getConnectionInstance().createConnection()){
			
			String sql = "UPDATE customers SET balance = ? WHERE username = ?";
			
			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setFloat(1, updateCustomer.getBalance());
			prepare.setString(2, updateCustomer.getUserName());
			int bool = prepare.executeUpdate();
			
			if (bool != 0) {
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

	@Override
	public ArrayList<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		ArrayList<Customers> allCustomers = new ArrayList<>();

		MakeConnection mkconnection = MakeConnection.getConnectionInstance();
		Connection conn = mkconnection.createConnection();

		String sql = "SELECT * FROM customers";

		try {
			Statement stmt = conn.createStatement();

			ResultSet resultSet = stmt.executeQuery(sql);

			while(resultSet.next()) {
				Customers cus = new Customers();
				cus.setUserName(resultSet.getString("username"));
				cus.setPassword(resultSet.getString("password"));
				cus.setBalance((resultSet.getFloat(3)));
				allCustomers.add(cus);
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allCustomers;
	}

	@Override
	public int getTotal() {
		int count = 0;
		
		MakeConnection mkconnection = MakeConnection.getConnectionInstance();
		Connection conn = mkconnection.createConnection();

		String sql = "CALL getTotal()";
		
		try {
			CallableStatement call = conn.prepareCall(sql);
			
			ResultSet total = call.executeQuery();
			
			while(total.next()) {
				count = total.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
