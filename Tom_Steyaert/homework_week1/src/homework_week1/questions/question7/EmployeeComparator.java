package homework_week1.questions.question7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {

		int lastNameToken = compareStrings(emp1.getLastName(), emp2.getLastName());
		int firstNameToken = compareStrings(emp1.getFirstName(), emp2.getFirstName());
		int departmentToken = compareStrings(emp1.getDepartment(), emp2.getDepartment());
		int ageToken = compareAge(emp1.getAge(), emp2.getAge());

		if(lastNameToken != 0) {
			return lastNameToken;

		} else if (firstNameToken != 0) {
			return firstNameToken;

		} else if (departmentToken != 0) {
			return departmentToken;

		} else if (ageToken != 0) {
			return ageToken;

		} else {
			return 0;
		}
	}

	public int compareStrings(String str1, String str2) {
		int shorterLength = 0;

		//we make them lowercase to make comparison easier to make
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		//if the strings are equal, we return 0
		if(str1.equals(str2)) {
			return 0;
		}

		//we only iterate through our strings for as long as the smaller string is
		if(str1.length() <= str2.length()) {
			shorterLength = str1.length();
		} else {
			shorterLength = str2.length();
		}

		//if our first letter of the first word is lower in the alphabet,
		//we know that word comes first, so we return 1
		for(int i = 0; i < shorterLength; i++) {
			if(str1.charAt(i) < str2.charAt(i)) {
				return -1;
			} else if(str1.charAt(i) > str2.charAt(i)) {
				return 1;
			}
		}

		//if one of the strings is a substring of the other one
		//we say the longer string goes first
		if(str1.length() > str2.length()) {
			return -1;
		} else {
			return 1;
		}

	}

	public int compareAge(int age1, int age2) {

		if(age1 > age2) {
			return 1;
		} else if(age1 < age2) {
			return -1;
		} else {
			return 0;
		}
	}
}
