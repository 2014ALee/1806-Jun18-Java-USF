package answers.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import answers.Employee;
import answers.Question7;

class Question7Test {

	@Test
	public void testCompare1() {

		Employee emp1 = new Employee("Aaron", "Accounting", 23);
		Employee emp2 = new Employee("Brina", "Banking", 24);

		List<Employee> emps = new ArrayList<>();
		
		Question7 ques = new Question7();

		emps.add(emp2);
		emps.add(emp1);
		
		assertEquals(-1, ques.compare(emp1, emp2));
	}
	
	@Test
	public void testCompare2() {

		Employee emp1 = new Employee("Aaron", "Accounting", 23);
		Employee emp2 = new Employee("Brina", "Banking", 24);

		List<Employee> emps = new ArrayList<>();
		
		Question7 ques = new Question7();

		emps.add(emp2);
		emps.add(emp1);
		
		assertEquals(1, ques.compare(emp2, emp1));
	}
}
