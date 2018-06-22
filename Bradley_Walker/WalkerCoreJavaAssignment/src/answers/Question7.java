package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question7 {
	// Comparing Employees

	public static void main(String[] args) {
		// Create the employees...
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(new Employee("John", "Sales", 32));
		employees.add(new Employee("Karen", "HR", 28));
		employees.add(new Employee("Bob", "R&D", 39));
		employees.add(new Employee("Bob", "R&D", 38));
		
		System.out.println("Unsorted: ");
		for(Employee e : employees)
			System.out.println(e);
		
		// and sort them.
		Collections.sort(employees);
		
		System.out.println("\nSorted:");
		for(Employee e : employees)
			System.out.println(e);
	}
	
	/*
	 * A simple Employee class containing only the necessary data
	 * and the compareTo function.
	 */
	static class Employee implements Comparable<Employee> {
		String name;
		String department;
		int age;

		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}
		
		/*
		 * The documentation is incredibly unclear on how exactly
		 * the interfaces are supposed to be used. From reading around
		 * online, I think this is the best way to compare 2 employee
		 * objects on multiple different fields.
		 */
		@Override
		public int compareTo(Employee emp) {
			// What we need to do first is configure the Comparator that
			// will actually do the comparing.
			
			// We say that we want to compare Employee objects by their name...
			return Comparator.comparing((Employee e)->e.name)
					// then by their department...
					.thenComparing(e->e.department)
					// then by their age.
					.thenComparing(e->e.age)
					// Once this is done, the actual comparison can happen.
					.compare(this, emp);
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}
	}

}
