package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import answers.Question14;

public class Question14Test {
	
	@Test
	public void testGetString() {
		assertEquals("Testing case 1", true, "8.0".equals(Question14.getString(1)));
		
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		assertEquals("Testing case 2", true, today.getTime().toString().equals(Question14.getString(2)));
		
		assertEquals("Testing case 3", true, "I".equals(Question14.getString(3)));
	}

}
