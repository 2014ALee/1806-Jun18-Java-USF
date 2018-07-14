package com.revature;

import java.util.ArrayList;

import com.revature.DAO.ReimbDAOImpl;
import com.revature.DAO.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;
public class ERSDriver {

	public static void main(String[] args) {
	
		
		
		UserDAOImpl test = new UserDAOImpl();
		
		/*ReimbDAOImpl test2 = new ReimbDAOImpl();
		
		User newUser = new User("Tomsteyaert","f9i3t6","Tom","Steyaert","tomsteyaert@gmail.com","manager");
		if(test.validRegistration(newUser)) {
			test.registerUser(newUser);	
		}else {
			System.out.println("invalid registration");
		}
		
		newUser = test.getUser(newUser);
		
		ArrayList<Reimbursement> bob = test2.getReimbursements(newUser);
		for(int i =0;i<bob.size();i++) {
			System.out.println(bob.get(i));
		}
		
		Reimbursement reimb = new Reimbursement();
		reimb.setDescription("Went out hiking");
		reimb.setReimbursementAmount(100);
		reimb.setTypeName("Jogging");

		test2.addReimbursement(reimb, newUser);
		
					*/
}
}
	
