package package1;

public class TopLevelClassWithPrivateMethod {
	private void print() {
		System.out.println("This method is private!!");
	}
	public static class SecondLevelClass extends TopLevelClassWithPrivateMethod {
		void print() {
			super.print();
			
			float f = 1.4f;
					
			
		}
	}
}
