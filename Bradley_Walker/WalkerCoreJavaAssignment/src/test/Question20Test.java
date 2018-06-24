package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import answers.Question20;

public class Question20Test {
	
	@Test
	public void testReadFromFile() {
		String str = "Name: Mickey Mouse\n" + 
				"Age: 35 years\n" + 
				"State: Arizona State\n" + 
				"Name: Hulk Hogan\n" + 
				"Age: 50 years\n" + 
				"State: Virginia State\n" + 
				"Name: Roger Rabbit\n" + 
				"Age: 22 years\n" + 
				"State: California State\n" + 
				"Name: Wonder Woman\n" + 
				"Age: 18 years\n" + 
				"State: Montana State\n";
		assertEquals("Testing file IO", true, str.equals(Question20.readFromFile()));
	}

}
