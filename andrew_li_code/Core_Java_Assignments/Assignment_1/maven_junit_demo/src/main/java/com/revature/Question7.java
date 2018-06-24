package com.revature;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 {

	public static void main(String[] args) {
		
		EmployeeComparator employeeComparator = new EmployeeComparator();

		Employee employee1 = new Employee("Li", "Andrew", "R&D", 23);
		Employee employee2 = new Employee("Steyaert", "Tom", "HR", 21);
		List<Employee> employees = Arrays.asList(employee2, employee1);
		System.out.println(employees);
		Collections.sort(employees, employeeComparator);
		System.out.println(employees);
	}
	
	/*
	 * Creating an Employee class because that's what we're
	 * comparing.
	 */
	public static class Employee {
		private String lastName;
		private String firstName;
		private String department;
		private int age;
		
		Employee(String lastName, String firstName, String department, int age) {
			// Unnecessary since it's implicit, but good practice.
			super();
			
			// Formatting the Naming layout.
			/*
			 * First letter is upper case, and rest of the
			 * letters in the word are lower case.
			 */
			this.lastName = lastName.substring(0,
					1).toUpperCase() + lastName.substring(1,
					lastName.length()).toLowerCase();
			this.firstName = firstName.substring(0,
					1).toUpperCase() + firstName.substring(1,
					firstName.length()).toLowerCase();
			// Upper case for department name
			this.department = department.toUpperCase();
			this.age = age;
		}
		
		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName.substring(0,
					1).toUpperCase() + lastName.substring(1,
					lastName.length()).toLowerCase();
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName.substring(0,
					1).toUpperCase() + firstName.substring(1,
					firstName.length()).toLowerCase();
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department.toUpperCase();
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [lastName=" + lastName + ", firstName=" + firstName + ", department=" + department + ", age="
					+ age + "]";
		}		
	}
	/*
	 * We need to create the comparator object in order
	 * to sort an Employee.
	 */
	public static class EmployeeComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee employee1, Employee employee2) {
			/*
			 * Compare based on the employees' last name.
			 * If they're the same, we move on.
			 * If not, we have our return value.
			 * The strCmp method is defined later.
			 */
			int returnValue = strCmp(employee1.lastName,
					employee2.lastName);
			if (returnValue != 0) {
				return returnValue;
			}
			
			/*
			 * Now compare based on the employees' first names.
			 * If they're the same, we move on.
			 * If not, we have our return value.
			 */
			returnValue = strCmp(employee1.firstName,
					employee2.firstName);
			if (returnValue != 0) {
				return returnValue;
			}
			
			/*
			 * Now compare based on the employees' departments.
			 * If they're the same, we move on.
			 * If not, we have our return value.
			 */
			returnValue = strCmp(employee1.department,
					employee2.department);
			if (returnValue != 0) {
				return returnValue;
			}
			
			/*
			 * Since the employees' names and department
			 * are the same, we finally compare based on
			 * their ages.
			 */
			if (employee1.age < employee2.age) {
				return -1;
			}
			else if (employee1.age == employee2.age) {
				return 0;
			}
			else {
				return 1;
			}
		}
		public static int strCmp(String s1,
				String s2) {
			// We want to ignore case.
			s1 = s1.toLowerCase();
			s2 = s2.toLowerCase();
			/*
			 * Loop through both strings until they
			 * no longer have the same character on the 
			 * index. 
			 */
			for (int i = 0; i < s1.length() && i < s2.length(); i++) {

				// Reducing number of function calls.
				char s1CharAtI = s1.charAt(i);
				char s2CharAtI = s2.charAt(i);


				/*
				 * If the character from first string is less
				 * than character from second, return -1
				 * as first string is less than second.
				 * If the character from first string is greater
				 * than character from second, return 1
				 * as first string is greater than second.
				 */
				if (s1CharAtI < s2CharAtI) {
					return -1;
				}
				if (s1CharAtI > s2CharAtI) {
					return 1;
				}
			}
			/*
			 * If one of the strings ends before
			 * we have a differentiating character,
			 * the string with fewer characters is
			 * considered the smaller.
			 */
			if (s1.length() < s2.length()) {
				return -1;
			}
			if (s1.length() > s2.length()) {
				return 1;
			}
			/*
			 * If both strings have same characters and
			 * same length, return 0 as they are equal.
			 */
			return 0;
		}
	}

}