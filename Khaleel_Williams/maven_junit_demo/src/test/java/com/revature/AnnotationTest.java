package com.revature;

public class AnnotationTest {

	@BeforeClass
	public static void runBeforeClass()	{
		System.out.println("called runBeforeClass() method");
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("called runAfterClass() method");

	}
}
