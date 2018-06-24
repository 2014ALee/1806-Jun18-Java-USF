package com.revature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationTest {

	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("Called runBeforeClass() method");
	}
	@AfterClass
	public static void runAfterClass() {
		System.out.println("Called runBeforeClass() method");
	}
	@Test
	public void runTest() {
		System.out.println("Running test!!");
	}
	@Before
	public void runBefore() {
		System.out.println("Called runBefore())");
	}
	@After
	public void runAfter() {
		System.out.println("Called runAfter())");
	}

}
