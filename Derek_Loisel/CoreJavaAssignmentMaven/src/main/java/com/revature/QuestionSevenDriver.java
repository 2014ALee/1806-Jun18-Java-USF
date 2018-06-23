package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.QuestionSevenAgeComparator;
import com.revature.models.QuestionSevenComparator;
import com.revature.models.QuestionSevenEmployee;

public class QuestionSevenDriver {

//	Q7. Sort two employees based on their name, department, and age using the Comparator interface.
	
	public static void main(String[] args) {
		
		
		//make employee objects to sort
		QuestionSevenEmployee emp1 = new QuestionSevenEmployee("John", 19, "marketing");
		QuestionSevenEmployee emp2 = new QuestionSevenEmployee("Jen", 21, "marketing");
		QuestionSevenEmployee emp3 = new QuestionSevenEmployee("Shannon", 25, "engineering");
		QuestionSevenEmployee emp4 = new QuestionSevenEmployee("Billy", 19, "public relations");
		
		//add the employees to an ArrayList
		List<QuestionSevenEmployee> empList = new ArrayList<>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		
		//sort employees by age with age comparator
		QuestionSevenAgeComparator ageComparator = new QuestionSevenAgeComparator();
		empList.sort(ageComparator);
		
		//print employees sorted by age with age comparator
		System.out.println("Employees sorted by age:");
		for (QuestionSevenEmployee emp : empList) {
			System.out.println(emp);
		}
		System.out.println("------------------------------------------------------------------------");
		
		//sort employees by name, department, and age with compareTo() method in comparator
		QuestionSevenComparator comp = new QuestionSevenComparator();
		empList.sort(comp);
		
		//print employees sorted by name, department, and age with comparator
		System.out.println("Employees sorted by name, department, and age:");
		for (QuestionSevenEmployee emp : empList) {
			System.out.println(emp);
		}
	}
	
}
