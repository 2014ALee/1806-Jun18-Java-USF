package question03; //completed

/*
 * his is a java program that reverses using the toCharArray method. Karen helped me 
 * with the loop logic because since I was not getting an output. 
 * 
 */


public class ReverseString {

	public static void main(String[] args) {

		String gooey = "desrever";
//here I have created a String named gooey and set its contents to be  reversed spelled backward
		
		
		//char.firstIndex= reversed.charAt(7);
		//char.secondIndex= reversed.charAt(6);
		//char.thirdIndex= reversed.charAt(5);
		//char.fourthIndex= reversed.charAt(4);
		//char.fifthIndex= reversed.charAt(3);
		//char.sixthIndex= reversed.charAt(2);
		//char.seventhIndex= reversed.charAt(1);
		
		
/*I was watching Kathryn Hodge's "Learning Java" two hr video where she was using the charAt method to output 
 * an index at a specific location. It occurred to me that to reverse my string this way I'd have to output
 * as many times as there are letters. I'm sure that's NOT what you meant by reverse the string.
 */
		
		//char[] yougotit= gooey.toCharArray(); //converted string to char array
		//int j= yougotit.length; //created an integer variable that references the length of my character array.
		
		for( char i=8; i<=gooey.toCharArray().length; i--) {
			
			//System.out.println(gooey);
		//for( char i:gooey.toCharArray()) {
			
			System.out.println(gooey.charAt(i));
			
			
	//here I have changed my string into a character array, looped through it's indexes and printed out the index at every iteration.
			
		}
			
	}

}
