package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.MakeConnection;

public class ImplementType implements TypeInterface {

	@Override
	public String getTypeById(int id) {
		String str = null;

		try(Connection conn = MakeConnection.getConnectionInstance().createConnection()){

			String sql = "SELECT type FROM reimbursement_type WHERE type_id = ? ";

			PreparedStatement prepare = conn.prepareStatement(sql);
			prepare.setInt(1, id);
			ResultSet rs = prepare.executeQuery();

			while(rs.next()) {
				str = rs.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

}
