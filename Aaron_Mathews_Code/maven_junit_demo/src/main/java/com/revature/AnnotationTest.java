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
	
	@Before
	public void runBefore() {
		System.out.println("Called runBefore() method");
	}
	
	@After
	public void runAfter() {
		System.out.println("Called runAfter() method");
	}
	
	@Test
	public void test1() {
		System.out.println("Ran test1.");
	}
	
	@Test
	public void test2() {
		System.out.println("Ran test2");
	}
	
	@Test
	public void test3() {
		System.out.println("Ran test3");
	}
	
	@Test
	public void test4() {
		System.out.println("Ran test4");
	}
	
	//@Ignore
	//Wont run following test
	
	//@Ignore("We can included a comment with the keyword")
}
