package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.models.ConcreteClass;

public class ConcreteClassTest {

	@Test
	public void testConvertStr() {
		String str2 = "10";
		ConcreteClass cc = new ConcreteClass();
		System.out.println(cc.convertStr(str2));
		assertTrue("They are not equal", (10 == cc.convertStr(str2)));
	}
	@Test
	public void testMakeUppercase() {
		String str = "dOg";
		ConcreteClass cc = new ConcreteClass();
		System.out.println(cc.makeUppercase(str));
		assertTrue("They are not equal", "DOG".equals(cc.makeUppercase(str)));
	}
	@Test
	public void testHasUppercase() {
		String str = "doG";
		ConcreteClass cc = new ConcreteClass();
		System.out.println(cc.hasUppercase(str));

		assertTrue("They are not equal", (cc.hasUppercase(str)));
	}

}
