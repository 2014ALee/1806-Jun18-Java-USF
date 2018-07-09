import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.userDAOImpl;
import com.revature.models.userData;

public class BankAppTestCases {
	static userDAOImpl testDao = new userDAOImpl();
	static userData testUser = new userData();
	
	
	@Test
	public void buildTestUser() {
		testUser.setFirstName("APP");
		testUser.setLastName("TESTER");
		testUser.setUserName("TEST");
		testUser.setPassword("TEST");
		testUser.setEmail("Popquiz@testmail.org");
		testUser.setBalance(0);
		testDao.createUser(testUser);
		assertEquals("The account name and password should be TEST,"+ 
	"the name should be APP, and TESTER. Balance should be Zero.",false,testDao.checkForUser(testUser));
	}
	@Test
	public void withdrawTest() {
		assertEquals("The account TEST should have $1 remaining after the withdrawl.", 1d, testDao.withdraw(testUser, 9d), 0);
	}
	@Test
	public void depositTest() {
		assertEquals("The account TEST should have $10 in their account after the deposit.", 10d, testDao.deposit(testUser, 10d), 0);
		System.out.println(testUser.getBalance());
	}
	@Test
	public void clearTestUser() {
		testDao.clearUser(testUser);
		assertEquals("testUser should no longer point to normal values.", null,testUser.getFirstName());
	}

}
