package com.revature;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public  class AnnotationTest {
	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass() method");
		
	}
 
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called runAfterClass() method");
	}
	
	@Before 
	public void runAfter() { //runs after each test case and cleans it up
}
	
	@Test
	public void test1() {
		System.out.println("ran test1");
	}
	
	@Test
	public void test2() {
		System.out.println("ran test2");
	}
	
	@Test
	public void test3() {
		System.out.println("ran test3");
	}
	
	@Test
	public void test4() {
		System.out.println("ran test4");
	}
	@Ignore
	public void test5() {
		System.out.println("this will never run because it is ignored");
	}
	
}