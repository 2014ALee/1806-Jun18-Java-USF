package homework_week1.questions;

public class Question1 {


	public static int[] bubbleSort(int[] a) {			
		
		int lastIndex=a.length-1;	
		final int LAST_INDEX = a.length-1;

		//we pass through the array doing swaps for as many times as we have values
		for(int j=0;j<LAST_INDEX;j++) {		
			for(int i=0;i<lastIndex;i++){				

				//we swap array value if the value at a[i] is greater than the value in the index to it's right
				if(a[i]>a[i+1]) {
					int temp=a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}

		return a;
	}

	public static void printArray(int[] array){
		for(int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
	}

	public static void main(String[] args) {
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};

		bubbleSort(array);
		printArray(array);

	}


}
