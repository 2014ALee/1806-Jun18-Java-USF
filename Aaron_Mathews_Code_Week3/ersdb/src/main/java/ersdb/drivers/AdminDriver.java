package ersdb.drivers;

import ersdb.dao.UserDAOImpl;
import ersdb.models.User;

public class AdminDriver {
	
	
	public static void main(String[] args) {
		
		UserDAOImpl userDAO = new UserDAOImpl();
//		User admin = new User(1, "adminuser", "p4ssw0rd", "Aaron", "Mathews", "aaron.mathews95@gmail.com", 1);
//		
//		admin = userDAO.createUser(admin);
		
		User admin = userDAO.getUserByUsername("admin");
		System.out.println(admin.toString());
		
	}

}
