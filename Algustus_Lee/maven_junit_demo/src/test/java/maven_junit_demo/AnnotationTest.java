package maven_junit_demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AnnotationTest {
	@BeforeClass
	public static void runBeforeClass() {
		System.out.println("called runBeforeClass() method");
	}
	
	@AfterClass
	public static void runAfterClass()
	{
		System.out.println("called runAfterClass() method");
	}
	
	@Before
	public void runBefore()
	{
		System.out.println("called runBefore() method");
	}
	
	@After
	public void runAfter()
	{
		System.out.println("called runAfter() method");
	}
	
	@Test
	public void test1()
	{
		System.out.println("ran test1");
	}
	@Test
	public void test2()
	{
		System.out.println("ran test2");
	}
	@Test
	public void test3()
	{
		System.out.println("ran test3");
	}
	@Test
	public void test4()
	{
		System.out.println("ran test4");
	}
	@Ignore("We can include explanations of why a test case is ignored like this.")
	public void test5()
	{
		System.out.println("You shouldn't see me, I'm being ignored!");
	}
}
