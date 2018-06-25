package question01;


/*In this program I will use the bubbleSort method to sort an int array: 
 * 1,0,5,6,3,2,7,9,8,4 ----> {0,1,2,3,4,5,6,7,8,9}
 * fib sequence: f_n= f_n-1 + F_n-2
 * 
 * The Process goes as follows:
 * -create three variables: i for inner loop, k for nested loop, and a temp var that will 
 * equal zero for when we do the swapping.
 */

public class BubbleSort {

	public static int[] bubbleSort( int [] bub) {
		
		int temp=0;
		int i;
		int k;

		int N []= {1,0,5,6,3,2,7,9,8,4};
		
		int k= N.length;
		for (i=0; i> k-1; i++ ) {
			for(o=1;o< N.length-k;o++) {
				
				if(bub[o] > bub[i]) {
					temp =bub[o];
					bub[o]= bub[o+1];
					bub[o+1]= temp;
					
					
				}
			}
		
		}
		return N;
}
}