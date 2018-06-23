package com.revature;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationTest {

	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass() method");
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called runAfterClass() method");	
	}
	
	@Before
	public void runBefore() {
		System.out.println("called runBefore() method");
	}
	
	@After
	public void runAfter() {
		System.out.println("called runAfter() method");	
	}
	
	@Test 
	public void test1() {
		System.out.println("Ran test1");
	}
	
	@Test 
	public void test2() {
		System.out.println("Ran test1");
	}
	
	@Test 
	public void test3() {
		System.out.println("Ran test1");
	}
	
	
	
}


