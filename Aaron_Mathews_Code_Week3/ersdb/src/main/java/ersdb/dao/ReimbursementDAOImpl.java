package ersdb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ersdb.models.Reimbursement;
import ersdb.util.ConnectionFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public Reimbursement createReimbursement(Reimbursement newReimb) {
		Reimbursement reimb = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, "
					+ "reimb_receipt, reimb_author, reimb_status_id, reimb_type_id) VALUES (?,?,?,?,?,?,?)";
			
			String[] keys = new String[1];
			keys[0] = "reimb_id";
			
			PreparedStatement pstat = conn.prepareStatement(sql, keys);
			pstat.setDouble(1, newReimb.getReimbAmount());
			pstat.setDate(2, newReimb.getSubmitted());
			pstat.setString(3, newReimb.getDescription());
			pstat.setBlob(4, newReimb.getReceipt());
			pstat.setInt(5, newReimb.getAuthor());
			pstat.setInt(6, newReimb.getStatusId());
			pstat.setInt(7, newReimb.getTypeId());
			
			int success = pstat.executeUpdate();
			ResultSet rs = pstat.getGeneratedKeys();
			
			if (success != 0) {
				while (rs.next()) {
					reimb.setReimbId(rs.getInt(1));
				}
				reimb.setAuthor(newReimb.getAuthor());
				reimb.setDescription(newReimb.getDescription());
				reimb.setReceipt(newReimb.getReceipt());
				reimb.setReimbAmount(newReimb.getReimbAmount());
				reimb.setStatusId(newReimb.getStatusId());
				reimb.setSubmitted(newReimb.getSubmitted());
				reimb.setTypeId(newReimb.getTypeId());
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public Reimbursement updateReimbursementResolver(Reimbursement reimb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement resolveReimbursement(Reimbursement reimb) {
		Reimbursement re = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			conn.setAutoCommit(false);
			
			String sql = "UPDATE ers_reimbursement SET reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? WHERE reimb_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setDate(1, reimb.getResolved());
			pstat.setInt(2, reimb.getResolver());
			pstat.setInt(3, reimb.getStatusId());
			pstat.setInt(4, reimb.getReimbId());
			
			int success = pstat.executeUpdate();
			
			if (success != 0) {
				re.setAuthor(reimb.getAuthor());
				re.setDescription(reimb.getDescription());
				re.setReceipt(reimb.getReceipt());
				re.setReimbAmount(reimb.getReimbAmount());
				re.setReimbId(reimb.getReimbId());
				re.setResolved(reimb.getResolved());
				re.setResolver(reimb.getResolver());
				re.setStatusId(reimb.getStatusId());
				re.setSubmitted(reimb.getSubmitted());
				re.setTypeId(reimb.getTypeId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public Reimbursement getReimbursementById(int reimbId) {
		Reimbursement reimb = new Reimbursement();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, reimbId);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				reimb.setAuthor(rs.getInt("reimb_author"));
				reimb.setDescription(rs.getString("reimb_description"));
				reimb.setReceipt(rs.getBlob("reimb_receipt"));
				reimb.setReimbAmount(rs.getDouble("reimb_amount"));
				//Set rest of values
				reimb.setReimbId(reimbId);
				reimb.setResolved(rs.getDate("reimb_resolved"));
				reimb.setResolver(rs.getInt("reimb_resolver"));
				reimb.setStatusId(rs.getInt("reimb_status_id"));
				reimb.setSubmitted(rs.getDate("reimb_submitted"));
				reimb.setTypeId(rs.getInt("reimb_type_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByAuthorId(int authorId) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, authorId);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setReimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbId(rs.getInt("reimb_id"));
				temp.setResolved(rs.getDate("reimb_resolved"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatusId(rs.getInt("reimb_status_id"));
				temp.setSubmitted(rs.getDate("reimb_submitted"));
				temp.setTypeId(rs.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
 	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByResolverId(int resolverId) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_resolver = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, resolverId);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setReimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbId(rs.getInt("reimb_id"));
				temp.setResolved(rs.getDate("reimb_resolved"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatusId(rs.getInt("reimb_status_id"));
				temp.setSubmitted(rs.getDate("reimb_submitted"));
				temp.setTypeId(rs.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByStatus(int status) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, status);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setReimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbId(rs.getInt("reimb_id"));
				temp.setResolved(rs.getDate("reimb_resolved"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatusId(rs.getInt("reimb_status_id"));
				temp.setSubmitted(rs.getDate("reimb_submitted"));
				temp.setTypeId(rs.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public ArrayList<Reimbursement> getReimbursementByType(int type) {
		ArrayList<Reimbursement> reimbs = new ArrayList<>();
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_type_id = ?";
			
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, type);
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				Reimbursement temp = new Reimbursement();
				temp.setAuthor(rs.getInt("reimb_author"));
				temp.setDescription(rs.getString("reimb_description"));
				temp.setReceipt(rs.getBlob("reimb_receipt"));
				temp.setReimbAmount(rs.getDouble("reimb_amount"));
				temp.setReimbId(rs.getInt("reimb_id"));
				temp.setResolved(rs.getDate("reimb_resolved"));
				temp.setResolver(rs.getInt("reimb_resolver"));
				temp.setStatusId(rs.getInt("reimb_status_id"));
				temp.setSubmitted(rs.getDate("reimb_submitted"));
				temp.setTypeId(rs.getInt("reimb_type_id"));
				reimbs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

}
