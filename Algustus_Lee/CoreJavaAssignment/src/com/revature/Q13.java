package com.revature;
//This was the 19th question I did. It's been the hardest so far.


public class Q13 {
	public static void main(String[] args) {
		//counts the row, and is the number to print out. when it's odd, it prints one
		//when it's even, it prints zero
		int counter = 0;

		//outer loop, counts four lines. used i=1 to make counting the rows easier on myself
		for(int i = 1; i <= 5; i++)
		{
			//inner loop, marks the  numbers to go in each row.
			//it takes the mod of counter (set below in the i loop) which will always be
			//either 0 or one and prints it.
			for (int j = 1;j < i;j++)
			{
				System.out.print(counter % 2);
				counter++;
			}
			//row 1 starts with a 0
			if (i == 1)
			{
				counter = 0;
			}
			//row 2 starts with a 1
			else if(i== 2)
			{
				counter = 1;
			}
			//row 3 starts with a 1 as well (note: this threw me off for the longest time)
			else if(i == 3)
			{
				counter = 1;
			}
			//row four starts with a 0
			else
			{
				counter = 0;
			}
			System.out.println("");
		}
	}
}
