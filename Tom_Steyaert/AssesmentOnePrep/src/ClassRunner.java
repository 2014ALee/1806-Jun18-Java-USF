
public class ClassRunner {
	public static void main(String[] args) {
		
		//static type is on the left
		//dynamic type is on the right
		SubClass class2 = new SubClass();
		
		
		class2.print();
		class2.staticPrint(); // SubClass.staticPrint()
		((SubClass) class2).staticPrint();
		SuperClass.staticPrint();
		SubClass.staticPrint();
		
		
	}
}
