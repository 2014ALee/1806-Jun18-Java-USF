package com.revature.models;

import java.util.Comparator;

public class QuestionSevenAgeComparator implements Comparator<QuestionSevenEmployee>{

	@Override
	public int compare(QuestionSevenEmployee employee1, QuestionSevenEmployee employee2) {
		if (employee1.getAge() - employee2.getAge() > 0) {
			return 1;
		}else if (employee1.getAge() - employee2.getAge() < 0) {
			return -1;
		}else {
		return 0;
		}
	}

}
