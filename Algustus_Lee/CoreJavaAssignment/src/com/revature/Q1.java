package com.revature;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args)
	{
		//the array to be organized through the bubble sort
		int[] theArray = {1,0,5,6,3,2,3,7,9,8,4};
		arraySorter(theArray);
			
	}
	public static int[] arraySorter(int[] theArray)
	{
		//temporary variable to store the integer to be swapped
				int temp1 = 0;
				//variable to count how many times the array was reset.
				int resetCounter = 0;
				
				//main for loop to swap through everything
				for (int i=0; i < theArray.length; i++)
				{
					//try/catch block in case something goes wrong
					try {
						//if statement to check if int i is at the end of the array. it adds to the counter of resets
						if(i+1 >= theArray.length)
						{
							i = 0;
							resetCounter++;
						}
						//this is the part where it swaps the higher number to the right
							if(theArray[i+1]<theArray[i])
							{
								temp1 = theArray[i];
								theArray[i] = theArray[i+1];
								theArray[i+1] = temp1;
							}
						//prints the array
						System.out.println("The Array: " + theArray[i]);
					}
					//in case something goes wrong
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("You went out of bounds somehow.");
						e.printStackTrace();
					}
					//breaks the loop by setting i to the end if the counter goes too high.
					if (resetCounter > theArray.length)
					{
						i = theArray.length;
					}
					
				}
				//prints the finalized array.
				System.out.println(Arrays.toString(theArray));
				return theArray;
			
	}

}
