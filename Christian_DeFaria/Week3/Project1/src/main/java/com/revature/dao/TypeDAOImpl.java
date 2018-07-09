package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Type;
import com.revature.util.ConnectionFactory;

public class TypeDAOImpl implements TypeDAO {

	@Override
	public Type getType(int id) {
		Type type = new Type();
		type.setType_id(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				type.setType(rs.getString(2));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public Type getType(String t) {
		Type type = new Type(t);
		type.setType(t);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_type WHERE reimb_type = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				type.setType_id(rs.getInt(1));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return type;
	}

	@Override
	public ArrayList<Type> getAllTypes() {
		ArrayList<Type> types = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_type";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Type temp = new Type();
				temp.setType_id(rs.getInt(1));
				temp.setType(rs.getString(2));
				types.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return types;
	}

	@Override
	public Type addType(Type t) {
		Type type = new Type(t.getType());
		return type;
	}

}
