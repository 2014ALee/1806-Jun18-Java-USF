package com.revature.models;

import java.util.Comparator;

public class QuestionSevenComparator implements Comparator<QuestionSevenEmployee> {

	@Override
	public int compare(QuestionSevenEmployee emp1, QuestionSevenEmployee emp2) {
		
		int a = 0;
		
		//sort by name unless they're equal, then by department unless they're equal, then finally by age. a will remain 0 if they're all the same
		a = emp1.getName().compareTo(emp2.getName()) ;
		
		if (a == 0) {	
			a = emp1.getDepartment().compareTo(emp2.getDepartment()) ;			
		}
		if (a == 0){
			a = emp1.getAge().compareTo(emp2.getAge()) ;
		}
		
		return a;
	}

	
}
