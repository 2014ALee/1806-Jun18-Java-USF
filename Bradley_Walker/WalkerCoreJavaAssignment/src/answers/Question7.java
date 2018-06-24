package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import answers.Question7.Employee;

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
		
		System.out.println("\nSorted by name:");
		for(Employee e : sortByName(employees))
			System.out.println(e);
		
		System.out.println("\nSorted by department:");
		for(Employee e : sortByDepartment(employees))
			System.out.println(e);
		
		System.out.println("\nSorted by age:");
		for(Employee e : sortByAge(employees))
			System.out.println(e);
	}
	
	public static ArrayList<Employee> sortByName(ArrayList<Employee> employees){
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		Collections.sort(result, new NameComparator());
		return result;
	}
	
	public static ArrayList<Employee> sortByDepartment(ArrayList<Employee> employees){
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		Collections.sort(result, new DepartmentComparator());
		return result;
	}
	
	public static ArrayList<Employee> sortByAge(ArrayList<Employee> employees){
		ArrayList<Employee> result = new ArrayList<>();
		for(Employee e : employees)
			result.add(e);
		Collections.sort(result, new AgeComparator());
		return result;
	}
	
	private static class NameComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.name.compareTo(emp2.name);
		}
		
	}
	
	private static class DepartmentComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.department.compareTo(emp2.department);
		}
		
	}
	
	private static class AgeComparator implements Comparator<Employee> {

		@Override
		public int compare(Employee emp1, Employee emp2) {
			return Integer.compare(emp1.age, emp2.age);
		}
		
	}
	
	/*
	 * A simple Employee class containing only the necessary data.
	 */
	public static class Employee {
		public String name;
		public String department;
		public int age;

		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}
	}

}
