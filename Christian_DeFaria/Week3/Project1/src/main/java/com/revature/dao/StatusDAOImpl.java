package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

public class StatusDAOImpl implements StatusDAO {

	@Override
	public Status getStatus(int id) {
		Status s = new Status();
		s.setStatus_id(id);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				s.setStatus(rs.getString(2));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Status getStatus(String stat) {
		Status s = new Status(stat);
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_status WHERE reimb_status = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stat);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				s.setStatus_id(rs.getInt(1));;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public ArrayList<Status> getAllStatuses() {
		ArrayList<Status> statuses = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "SELECT * FROM ers_reimbursement_status";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Status temp = new Status();
				temp.setStatus_id(rs.getInt(1));
				temp.setStatus(rs.getString(2));
				statuses.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statuses;
	}

	@Override
	public Status addStatus(Status s) {
		Status stat = new Status();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			
			String sql = "INSERT INTO ers_reimbursement_status (reimb_status) VALUES (?)";
			
			String[] keys = new String[1];
			keys[0] = "reimb_status_id";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, s.getStatus());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				while(rs.next()) {
					stat.setStatus_id(rs.getInt(1));
					stat.setStatus(s.getStatus());
					return stat;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
