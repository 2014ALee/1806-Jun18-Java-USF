package homework_week1;

public class BubbleSort {

	
public static int[] bubbleSorter(int[] a) {	
	int lastIndex=a.length-1;	
	final int LAST_INDEX = a.length-1;
	
	//this outter loop goes through each pass of the array
	for(int j=0;j<LAST_INDEX;j++) {
		for(int i=0;i<lastIndex;i++){				
			if(a[i]>a[i+1]) {
				int temp=a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
			}
		
		if(i==lastIndex) {
			System.out.println("got here");
			lastIndex--;
		}
	}
}
	
	for(int i=0; i<a.length;i++) {
		System.out.println(a[i]);
	}
	
	
	return a;
}



}
