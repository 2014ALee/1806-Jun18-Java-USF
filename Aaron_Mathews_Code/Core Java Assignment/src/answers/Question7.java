package answers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question7 implements Comparator<Employee> {
	
	public static void main(String[] args) {
		Employee emp1 = new Employee("Aaron", "Accounting", 23);
		Employee emp2 = new Employee("Brina", "Banking", 24);

		List<Employee> emps = new ArrayList<>();

		emps.add(emp2);
		emps.add(emp1);
		emps.add(emp1);

		Question7 ques = new Question7();

		System.out.println(emps);
		emps.sort(ques);
		System.out.println(emps);
	}
	
	@Override
	public int compare(Employee emp1, Employee emp2) {
		int val = 0;
		if (emp1.equals(emp2)) {
			return val;
		}
		if (emp1.getAge() - emp2.getAge() > 0) {
			val = 1;
		} else if (emp1.getAge() - emp2.getAge() < 0) {
			val = -1;
		}
		if (val == 0 & emp1.getDepartment().compareTo(emp2.getDepartment()) > 0) {
			val = 1;
		} else if (emp1.getDepartment().compareTo(emp2.getDepartment()) < 0) {
			val = -1;
		}
		if (val == 0 &emp1.getName().compareTo(emp2.getName()) > 0) {
			val = 1;
		} else if (emp1.getName().compareTo(emp2.getName()) < 0) {
			val = -1;
		}
		return val;
	}
}
