package com.revature;

import static com.revature.Question20.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class Question20Test {

	@Test
	public void test() {
		main(new String[0]);
		assertEquals("First line is Mickey Mouse, age 35, from AZ",
				"Name: Mickey Mouse\n" + "Age: 35 years\n"
						+ "State: Arizona State", getString(0));
		assertEquals("Second line is Hulk Hogan, age 50, from VA",
				"Name: Hulk Hogan\n" + "Age: 50 years\n"
						+ "State: Virginia State", getString(1));
		assertEquals("First line is Roger Rabbit, age 22, from CA",
				"Name: Roger Rabbit\n" + "Age: 22 years\n"
						+ "State: California State", getString(2));
		assertEquals("First line is Wonder Woman, age 18, from MT",
				"Name: Wonder Woman\n" + "Age: 18 years\n"
						+ "State: Montana State", getString(3));
		System.out.println("Test case for Question 20 passed!");
	}

}
