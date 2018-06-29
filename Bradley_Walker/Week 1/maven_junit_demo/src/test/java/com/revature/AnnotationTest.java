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
		System.out.println("Called runAfterClass() method");
	}
	
	// runs before anything
	@Before
	public void runBefore() {
		System.out.println("Called the runBefore() method");
	}
	
	@After
	public void runAfter() {
		System.out.println("Called runAfter() method");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
}
