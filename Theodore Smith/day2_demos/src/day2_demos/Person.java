package day2_demos;

public class Person {

		

		private String firstName;

		private String lastName;

		private int age;

		private Skill primarySkill;

		

		public Person() {

			this.firstName = "firstName";

			this.lastName = "lastName";

			this.age = 0;

			this.primarySkill = Skill.JAVA;

		}

		

		public Person(String fn, String ln, int age, Skill skill) {

			this.firstName = fn;

			this.lastName = ln;

			this.age = age;

			this.primarySkill = skill;

		}

		

		public String getFirstName() {

			int x = 4; // method level scope (can't be seen outside of this code block!)

			System.out.println(x);

			System.out.println(firstName); // firstName is visible here because it has class level scope

			int z;

			

			if(true) {

				int y = 5; // block level scope

				System.out.println(y); // 'y' is visible here

				

				z = 4;

				System.out.println(z);

			}

			

//			System.out.println(y); // not visible because y was declared within the if block

			System.out.println(z); // prints 4

			

			return firstName;

		}



		public void setFirstName(String fn) {

//			System.out.println(x); // this does not work because 'x' is not visible within this scope

			this.firstName = fn;

		}



		public String getLastName() {

			return lastName;

		}



		public void setLastName(String lastName) {

			this.lastName = lastName;

		}



		public int getAge() {

			return age;

		}



		public void setAge(int age) {

			this.age = age;

		}



		public Skill getPrimarySkill() {

			return primarySkill;

		}



		public void setPrimarySkill(Skill primarySkill) {

			this.primarySkill = primarySkill;

		}



//		@Override // annotation that is used to override the existing implementation defined within a parent class

//		public String toString() {

//			return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", primarySkill="

//					+ primarySkill + "]";

//		}



		@Override

		public int hashCode() {

			final int prime = 31;

			int result = 1;

			result = prime * result + age;

			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());

			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());

			result = prime * result + ((primarySkill == null) ? 0 : primarySkill.hashCode());

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

			Person other = (Person) obj;

			if (age != other.age)

				return false;

			if (firstName == null) {

				if (other.firstName != null)

					return false;

			} else if (!firstName.equals(other.firstName))

				return false;

			if (lastName == null) {

				if (other.lastName != null)

					return false;

			} else if (!lastName.equals(other.lastName))

				return false;

			if (primarySkill != other.primarySkill)

				return false;

			return true;

		}
}