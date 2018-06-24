package com.revature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
		System.out.println("Called runBefore method");
	}
	
	@After
	public void runAfter() {
		System.out.println("Called runAfter method");
	}
	
	@Test
	public void test1() {
		System.out.println("Ran test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Ran test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Ran test 3");
	}
	
	@Ignore
	public void test4() {
		System.out.println("Ran test 4");
	}
	
	@Ignore("We can include an explanation of why a test was ignored")
	public void test5() {
		System.out.println("Test will never run");
	}

}
