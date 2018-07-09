package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.models.Type;
import com.revature.util.ConnectionFactory;

public class RoleDAOImpl implements RoleDAO {

	@Override
	public Role getRole(int id) {
		Role r = new Role();
		r.setRole_id(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_user_roles WHERE ers_user_role_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				r.setRole(rs.getString(2));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public Role getRole(String role) {
		Role r = new Role(role);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_user_roles WHERE ers_user_role = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, role);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				r.setRole_id(rs.getInt(1));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Role> getAllRoles() {
		ArrayList<Role> roles = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_user_roles";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Role temp = new Role();
				temp.setRole_id(rs.getInt(1));
				temp.setRole(rs.getString(2));
				roles.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public Role addRole(Role r) {
		return r;
	}

}
