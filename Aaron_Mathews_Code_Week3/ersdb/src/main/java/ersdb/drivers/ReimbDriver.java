package ersdb.drivers;

import java.util.Date;
import java.sql.Timestamp;

import ersdb.dao.ReimbursementDAOImpl;
import ersdb.models.Reimbursement;

public class ReimbDriver {
	
	public static void main(String[] args) {
		ReimbursementDAOImpl reimbDAO = new ReimbursementDAOImpl();
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		//Timestamp timestamp = new Timestamp(date.getTime());
		
		Reimbursement reimb = new Reimbursement(0, 0.34, sqlDate, null, "Some stuff",
				null, 2, 2, 1, 1);
		reimb = reimbDAO.createReimbursement(reimb);
		
		System.out.println(reimb);
		
		
	}

}
