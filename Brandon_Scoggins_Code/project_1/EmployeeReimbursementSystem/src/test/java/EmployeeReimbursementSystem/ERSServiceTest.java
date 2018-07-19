package EmployeeReimbursementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.models.ERSUser;
import com.revature.services.ERSService;

public class ERSServiceTest {

	@Test
	public void testLogInUserGoodUserNameAndGoodPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", true, admin.equals(service.logInUser("admin", "admin")));
	}

	@Test
	public void testLogInUserGoodUserNameAndBadPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("admin", "notadmin")));
	}
	
	@Test
	public void testLogInUserGoodEmailAndGoodPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", true, admin.equals(service.logInUser("admin@admin.com", "admin")));
	}
	
	@Test
	public void testLogInUserGoodEmailAndBadPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("admin@admin.com", "notadmin")));
	}

	@Test
	public void testLogInUserBadUserNameAndGoodPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("notadmin", "admin")));
	}
	
	@Test
	public void testLogInUserBadUserNameAndBadPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("notadmin", "notadmin")));
	}
	
	@Test
	public void testLogInUserBadEmailAndGoodPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("notadmin@admin.com", "admin")));
	}
	
	@Test
	public void testLogInUserBadEmailAndBadPassword() {
		ERSService service = new ERSService();
		ERSUser admin = new ERSUser(1, "admin", "admin", "admin", "admin", "admin@admin.com", 2);
		assertEquals("Logging in admin by username", false, admin.equals(service.logInUser("notadmin@admin.com", "notadmin")));
	}
	
//	@Test
//	public void testRegisterUser
}
