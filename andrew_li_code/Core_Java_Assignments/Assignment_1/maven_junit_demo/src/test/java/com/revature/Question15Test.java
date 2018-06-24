package com.revature;

import static com.revature.Question15.*;
import static org.junit.Assert.*;

import org.junit.Test;


public class Question15Test {

	@Test
	public void testAddition() {
		main(new String[0]);
		assertEquals("3.5 + 8.9 = 12.4", Math.abs(addition(
				3.5, 8.9) - 12.4) < 0.0001, true);
		assertEquals("75.12 + 9221.21 = 9296.33", Math.abs(addition(
				75.12 , 9221.21) - 9296.33) < 0.00001, true);
		assertEquals("24 + 66 = 90", Math.abs(addition(
				24, 66) - 90) < 0.0001, true);
		assertEquals("41.2 + 6.8 = 48", Math.abs(addition(
				41.2, 6.8) - 48) < 0.0001, true);
		System.out.println("Addition Cases work fine!");
	}
	@Test
	public void testSubtraction() {
		main(new String[0]);
		assertEquals("3.5 - 8.9 = -5.4", Math.abs(
				subtraction(3.5, 8.9) + 5.4) < 0.0001, true);
		assertEquals("8.9 - 3.5 = 5.4", Math.abs(
				subtraction(8.9, 3.5) - 5.4) < 0.0001, true);
		assertEquals("9221.21 - 75.12 = 9146.09", Math.abs(
				subtraction(9221.21, 75.12) - 9146.09)
				< 0.00001, true);
		assertEquals("66 - 16 = 50", Math.abs(
				subtraction(66, 16) - 50) < 0.0001,
				true);
		assertEquals("41.2 - 6.2 = 35", Math.abs(
				subtraction(41.2, 6.2) - 35) < 0.0001,
				true);
		System.out.println("Subtraction Cases work fine!");
	}
	@Test
	public void testMultiplication() {
		main(new String[0]);
		assertEquals("33.81 * 531.56 = 17972.0436", Math.abs(
				multiplication(33.81, 531.56) - 17972.0436)
				< 0.0001, true);
		assertEquals("100 * 500 = 50000", Math.abs(
				multiplication(100, 500) - 50000)
				< 0.0001, true);
		assertEquals("43324.432932432 * 0 = 0", Math.abs(
				multiplication(43324.432932432, 0))
				< 0.0001, true);
		System.out.println("Multiplication tests passed!");
	}
	@Test
	public void testDivision() {
		main(new String[0]);
		assertEquals("157.16 / 209.01 = 0.75192574", Math.abs(
				division(157.16, 209.01) - 0.75192574)
				< 0.0001, true);
		assertEquals("101.911 / 31.203 = 3.26606416", Math.abs(
				division(101.911, 31.203) - 3.26606416)
				< 0.0001, true);

		assertEquals("101241.911 / 1.0 = 101241.911", Math.abs(
				division(101241.911, 1.0) - 101241.911)
				< 0.0001, true);
		System.out.println("Division tests passed!");
	}

}
