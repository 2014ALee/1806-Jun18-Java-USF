package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.utility.question.eighteen.OurAbstractClass;
import com.revature.utility.question.eighteen.OurConcreteClass;

public class Question18Test {

	@Test
	public void test() {
		//oCC.printAddByTen(testString4)
		OurAbstractClass oac = new OurConcreteClass();
		assertEquals("Hello World!! has upper case letters",
				oac.hasUpperCase("Hello World!!"), true);
		assertEquals("revature does not have upper case letters",
				oac.hasUpperCase("revature"), false);
		assertEquals("math upper case is MATH",
				oac.makeUpperCase("math"), "MATH");
		assertEquals("12042 add by ten is 12052",
				oac.printAddByTen("12042"),
				"12052");
		assertEquals("Invalid number test",
				oac.printAddByTen("Invalid Number"),
				"Unable to parse Invalid Number as int.");
		System.out.println("Test cases for Question 18 have passed.");
		
	}

}
