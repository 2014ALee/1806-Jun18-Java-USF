package SourceMainJava;

import java.util.Comparator;

public class EmployeeProblem implements Comparator {

	private String department;
	
	private String name;
	
	private int age;
	
	public static final Comparator<EmployeeProblem> AgeComparator = new Comparator<EmployeeProblem>() {
		
	@Override
	public int compare(EmployeeProblem e1, EmployeeProblem e2) {
		return e1.age - e2.age;

	}
	};
	public static final Comparator<EmployeeProblem> NameComparator = new Comparator<EmployeeProblem>() {
		
		@Override
		public int compare(EmployeeProblem e1, EmployeeProblem e2) {
			return e1.name.compareTo(e2.name);
	}

};

	public EmployeeProblem(String department, String name, int age) {
		
		this.department = department;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Department Name is " + department + ", Employee Name is" + name + ", Age of Employee is " + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeProblem other = (EmployeeProblem) obj;
		if (age != other.age)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
		
	
}