package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.revature.models.ERSUser;
import com.revature.models.ReimbursementRequest;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.util.ConnectionFactory;

public class ERSReimbursementDAOImplementation implements ERSReimbursementDAO {

	@Override
	public void makeRequest(ERSUser employee, int amount, String description, int type) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "{CALL MAKE_REIMBURSEMENT_REQUEST(?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, amount);
			cstmt.setString(2, description);
			cstmt.setInt(3, employee.getId());
			cstmt.setInt(4, type);
			cstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean resolveRequest(ERSUser manager, boolean approve, int reimbursementId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			conn.setAutoCommit(false);
			
			// Preparing the statement here.
			String sql = "UPDATE ERS_REIMBURSEMENT ";
			sql += "SET ERS_REIMBURSEMENT_RESOLVER=?, ";
			sql += "ERS_REIMBURSEMENT_STATUS_ID=?, ";
			sql += "ERS_REIMBURSEMENT_RESOLVED=CURRENT_TIMESTAMP(6) ";
			sql += "WHERE (ERS_REIMBURSEMENT_ID=? ";
			sql += "AND ERS_REIMBURSEMENT_STATUS_ID=1)";

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, manager.getId());
			int newStatus = approve ? 2 : 3;
			preparedStatement.setInt(2, newStatus);
			preparedStatement.setInt(3, reimbursementId);
			int successful = preparedStatement.executeUpdate();
			
			if (successful != 0) {
				conn.commit();
				return true;
			}
			else {
				System.out.println("Unsuccessful Resolving...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<ReimbursementRequest> getPendingRequests() {
		ArrayList<ReimbursementRequest> pending = new ArrayList<ReimbursementRequest>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT ";
			sql += "WHERE ERS_REIMBURSEMENT_STATUS_ID=1 ";
			sql += "ORDER BY ERS_REIMBURSEMENT_SUBMITTED DESC";
			Statement statement = conn.createStatement();
			statement.execute(sql);
			ResultSet rs = statement.getResultSet();

			while (rs.next()) {
				int id = rs.getInt("ERS_REIMBURSEMENT_ID");
				int amount = rs.getInt("ERS_REIMBURSEMENT_CENTS_AMOUNT");
				Date submitted = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_SUBMITTED").getTime());
				String description = rs.getString("ERS_REIMBURSEMENT_DESCRIPTION");
				int authorID = rs.getInt("ERS_REIMBURSEMENT_AUTHOR");
				ERSUser author = (new ERSUserDAOImplementation()).getERSUserById(authorID);
				int typeID = rs.getInt("ERS_REIMBURSEMENT_TYPE_ID");
				ReimbursementType type = null;
				switch (typeID) {
					case 1:
						type = ReimbursementType.LODGING;
						break;
					case 2:
						type = ReimbursementType.TRAVEL;
						break;
					case 3:
						type = ReimbursementType.FOOD;
						break;
					default:
						type = ReimbursementType.OTHER;
				}
				ReimbursementStatus status = ReimbursementStatus.PENDING;
				pending.add(new ReimbursementRequest(id, amount, submitted, description,
						author, type, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pending;
	}

	@Override
	public ArrayList<ReimbursementRequest> getEmployeeRequests(ERSUser employee) {
		ArrayList<ReimbursementRequest> employeeRequests = new ArrayList<ReimbursementRequest>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "SELECT * FROM ERS_REIMBURSEMENT ";
			sql += "WHERE ERS_REIMBURSEMENT_AUTHOR=? ";
			sql += "ORDER BY ERS_REIMBURSEMENT_SUBMITTED DESC";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, employee.getId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ERS_REIMBURSEMENT_ID");
				int amount = rs.getInt("ERS_REIMBURSEMENT_CENTS_AMOUNT");
				Date submitted = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_SUBMITTED").getTime());
				Date resolved = null;
				String description = rs.getString("ERS_REIMBURSEMENT_DESCRIPTION");
				ERSUser author = employee;
				ERSUser resolver = null;
				int typeID = rs.getInt("ERS_REIMBURSEMENT_TYPE_ID");
				int statusID = rs.getInt("ERS_REIMBURSEMENT_STATUS_ID");
				ReimbursementType type = null;
				ReimbursementStatus status = null;
				switch (typeID) {
					case 1:
						type = ReimbursementType.LODGING;
						break;
					case 2:
						type = ReimbursementType.TRAVEL;
						break;
					case 3:
						type = ReimbursementType.FOOD;
						break;
					default:
						type = ReimbursementType.OTHER;
				}
				switch (statusID) {
					case 1:
						status = ReimbursementStatus.PENDING;
						break;
					case 2:
						status = ReimbursementStatus.APPROVED;
						resolved = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_RESOLVED").getTime());
						resolver = (new ERSUserDAOImplementation()).getERSUserById(
								rs.getInt("ERS_REIMBURSEMENT_RESOLVER"));
						break;
					case 3:
						status = ReimbursementStatus.DENIED;
						resolved = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_RESOLVED").getTime());
						resolver = (new ERSUserDAOImplementation()).getERSUserById(
								rs.getInt("ERS_REIMBURSEMENT_RESOLVER"));
						break;
				}
				employeeRequests.add(new ReimbursementRequest(id, amount, submitted, resolved, description,
						author, resolver, type, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeRequests;
	}
	
	@Override
    public ArrayList<ReimbursementRequest> getManagerResolves(ERSUser manager) {
        ArrayList<ReimbursementRequest> managerResolves = new ArrayList<ReimbursementRequest>();
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM ERS_REIMBURSEMENT ";
            sql += "WHERE ERS_REIMBURSEMENT_RESOLVER=? ";
            sql += "ORDER BY ERS_REIMBURSEMENT_SUBMITTED DESC";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, manager.getId());
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("ERS_REIMBURSEMENT_ID");
                int amount = rs.getInt("ERS_REIMBURSEMENT_CENTS_AMOUNT");
                Date submitted = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_SUBMITTED").getTime());
                Date resolved = new Date(rs.getTimestamp("ERS_REIMBURSEMENT_RESOLVED").getTime());
                String description = rs.getString("ERS_REIMBURSEMENT_DESCRIPTION");
                ERSUser author = (new ERSUserDAOImplementation()).getERSUserById(
						rs.getInt("ERS_REIMBURSEMENT_AUTHOR"));
                ERSUser resolver = manager;
                int typeID = rs.getInt("ERS_REIMBURSEMENT_TYPE_ID");
                int statusID = rs.getInt("ERS_REIMBURSEMENT_STATUS_ID");
                ReimbursementType type = null;
                ReimbursementStatus status = null;
                switch (typeID) {
                    case 1:
                        type = ReimbursementType.LODGING;
                        break;
                    case 2:
                        type = ReimbursementType.TRAVEL;
                        break;
                    case 3:
                        type = ReimbursementType.FOOD;
                        break;
                    default:
                        type = ReimbursementType.OTHER;
                }
                switch (statusID) {
                    case 1:
                        status = ReimbursementStatus.PENDING;
                        break;
                    case 2:
                        status = ReimbursementStatus.APPROVED;
                        break;
                    case 3:
                        status = ReimbursementStatus.DENIED;
                        break;
                }
                managerResolves.add(new ReimbursementRequest(id, amount, submitted, resolved, description,
                        author, resolver, type, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managerResolves;
    }

}
