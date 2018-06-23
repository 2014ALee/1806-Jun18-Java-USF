package Question18;

public class Subclass extends Superclass {

	@Override
	public boolean hasUpperCase(String str) {

		for(int i = 0; i < str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toUpperCase(String str) {

		return str.toUpperCase();

	}

	@Override
	public int toInteger(String str) {

		int asciiSum = 0;
		for(int i = 0; i < str.length(); i++) {
			asciiSum += (int) str.charAt(i);
		}

		asciiSum += 10;

		System.out.println("The integer representation of my string is: " + asciiSum);
		return asciiSum;
	}
}
