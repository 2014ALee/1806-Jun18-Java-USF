package homework_week1.questions.question7;

public class Question7 {

	public static void main(String[] args) {
		
		EmployeeComparator compare = new EmployeeComparator();
		
		Employee tom = new Employee("Tom", "Steyaert", "Sales", 22);
		Employee andrew = new Employee("Tom", "Steyaert", "Bales", 23);
		
		System.out.println(compare.compare(tom, andrew));
		
	}
	
}
