package com.revature;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.models.QuestionSevenAgeComparator;
import com.revature.models.QuestionSevenComparator;
import com.revature.models.QuestionSevenEmployee;

public class QuestionSevenDriverTest {

	@Test
	public void test() {
		
		//create Employee objects to test sort
		QuestionSevenEmployee emp1 = new QuestionSevenEmployee("ted", 25, "sales") ;	
		QuestionSevenEmployee emp2 = new QuestionSevenEmployee("ted", 25, "sales") ;
		QuestionSevenEmployee emp3 = new QuestionSevenEmployee("ted", 18, "sales") ;	
		QuestionSevenEmployee emp4 = new QuestionSevenEmployee("abby", 50, "HR") ;
		
		//create a comparator to test
		QuestionSevenComparator comp1 = new QuestionSevenComparator();
				
		//test the compare() method for name, department, and age.  If both employees are the same then compare() should return 0
		assertEquals("The compare() method didn't return the correct int", 0, comp1.compare(emp1,emp2));
		
		//---------------------------------------------------------------------------------------------------------------
		//create properly sorted Array List to hold Employee objects
		ArrayList<QuestionSevenEmployee> list1 = new ArrayList<>();
		list1.add(emp4);
		list1.add(emp3);
		list1.add(emp2);	
		
		//create an incorrectly sorted array list to test sorting comparator
		ArrayList<QuestionSevenEmployee> list2 = new ArrayList<>();
		list2.add(emp2);
		list2.add(emp3);
		list2.add(emp4);
			
		list2.sort(comp1);
		
		//test that list2 was properly sorted to match list1
		assertEquals("The list.sort(comparator) method didn't correctly sort the list", list1, list2);
		
		//---------------------------------------------------------------------------------------------------------------
		//test the QuestionSevenAgeComparator that sorts specifically by age
		//create a correctly sorted array
		ArrayList<QuestionSevenEmployee> list3 = new ArrayList<>();		
		list3.add(emp3);
		list3.add(emp2);
		list3.add(emp4);
		
		//create an incorrectly sorted array list to test the age comparator
		ArrayList<QuestionSevenEmployee> list4 = new ArrayList<>();
		list4.add(emp4);
		list4.add(emp2);
		list4.add(emp3);	
		
		QuestionSevenAgeComparator comp2 = new QuestionSevenAgeComparator();
		list4.sort(comp2);
		
		//test that list4 was properly sorted to match list3 by age
		assertEquals("The age specific list.sort(comparator) method didn't correctly sort the list by age", list3, list4);
	}

}
