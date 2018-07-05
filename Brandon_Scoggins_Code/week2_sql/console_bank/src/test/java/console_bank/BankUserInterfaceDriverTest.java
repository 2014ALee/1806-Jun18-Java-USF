package console_bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

import com.revature.BankUserInterfaceDriver;
import com.revature.models.User;

public class BankUserInterfaceDriverTest {

	@Ignore
	public void testCheckingAccountExist() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		User testUser = new User();
		assertEquals("An empty user should not have a checking account", false, tester.checkingAccountExist(testUser, 0));
	}
	
	@Ignore
	public void testSavingsAccountExist() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		User testUser = new User();
		assertEquals("An empty user should not have a savings account", false, tester.savingsAccountExist(testUser, 0));
	}
	
	@Ignore
	public void testGetStringInput() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertTrue("A string should be returned", tester.getStringInput().getClass() == " ".getClass());
	}
	
	@Ignore
	public void testGetMenuInput() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertTrue("A string should be returned", tester.getMenuInput().getClass() == " ".getClass());
	}
	
	@Ignore
	public void testGetIntInput() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertTrue("A string should be returned", tester.getIntInput().getClass() == " ".getClass());
	}
	
	@Test
	public void testStringIsNumberSingleDigit() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This String is a number", true, tester.stringIsNumber("4"));
	}
	
	@Test
	public void testStringIsNumberSeveralDigits() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This String is a longer number", true, tester.stringIsNumber("4983"));
	}
	
	@Test
	public void testStringIsNumberMixedInput() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This String is a mix of letters and numbers", false, tester.stringIsNumber("4jf8dd9"));
	}
	
	@Test
	public void testStringIsNumberJustLetters() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This String is just letters", false, tester.stringIsNumber("hello"));
	}
	
	@Test
	public void testCharIsNumberMixedInput() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This Char is a number", true, tester.charIsNumber('4'));
	}
	
	@Test
	public void testCharIsNumberJustLetters() {
		BankUserInterfaceDriver tester = new BankUserInterfaceDriver();
		assertEquals("This Char is a letters", false, tester.charIsNumber('h'));
	}
}
