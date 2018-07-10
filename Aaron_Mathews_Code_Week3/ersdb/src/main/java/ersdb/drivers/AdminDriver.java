package ersdb.drivers;

import ersdb.dao.UserDAOImpl;
import ersdb.models.User;

public class AdminDriver {
	
	UserDAOImpl userDAO = new UserDAOImpl();
	User admin = new User(1, "admin", "p4ssw0rd", "Aaron", "Mathews", "aaron.mathews95@gmail.com", 1);

}
