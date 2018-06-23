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
		System.out.println("Called before class Method");
	}
	
	@AfterClass
	public static void AfterClass() {
		System.out.println("Called after class Method");
	}
	@Before
	public void runBefore() {
		System.out.println("Called runBefore Method");
	}
	
	@After
	public void runAfter() {
		System.out.println("Called runAfter Method");
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
		System.out.println("does not run");
	}
}





