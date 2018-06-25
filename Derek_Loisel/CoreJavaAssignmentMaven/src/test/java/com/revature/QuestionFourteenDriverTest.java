package com.revature;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class QuestionFourteenDriverTest {

	@Test
	public void test() {

		//create test string to compare the sqrt of 49
		String str1 = "7.0";
		
		//create test string to compare todays date
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String str2 = dateFormat.format(date);
		
		//create test string to compare returned string
		String str3 = "I am learning Core Java";
		
		assertEquals("The getSwitchString() method didnt return the correct string", str1, QuestionFourteenDriver.getSwitchString(1));
		assertEquals("The getSwitchString() method didnt return the correct string", str2, QuestionFourteenDriver.getSwitchString(2));
		assertEquals("The getSwitchString() method didnt return the correct string", str3, QuestionFourteenDriver.getSwitchString(3));

	}

}
