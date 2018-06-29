package com.revature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class AnnotationTest {
	//other annotations

	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass() method");
	}
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called runBAfterClass() method");
	}


	@Before //runs before each test case to set it up
	public void runBefore() {
		System.out.println("called runbefore() method");
	}
	@After //runs after each test case to tear it down
	public void runAfter() {
		System.out.println("called runAfter() method");
	}
	
	//@Ignore
}
