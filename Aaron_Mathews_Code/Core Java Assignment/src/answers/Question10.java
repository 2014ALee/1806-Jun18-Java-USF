package answers;

public class Question10 {
	
	public static void main(String[] args) {
		System.out.println(findMin(3, 5));
	}
	
	public static int findMin(int a, int b) {
		return (a <= b ? a : b);
	}

}
