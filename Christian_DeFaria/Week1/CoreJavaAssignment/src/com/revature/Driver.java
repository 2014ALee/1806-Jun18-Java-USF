package com.revature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.models.ArithmeticImpl;
import com.revature.models.Employee;
import com.revature.models.EmployeeComparator;
import com.revature.models.StringSub;

import static com.revature.models.Vars.*;

public class Driver {
	static Scanner scan = new Scanner(System.in);
	static String userInput;
	
//	public static void main(String[] args) {
//		strLen(args[0]);
//	}
	
	//Q1
	public void bubbleSort() {
		System.out.println("Start of Q1");
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		int hold;
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j<arr.length; j++)
			{
				if(arr[i] > arr[j]) {
					hold = arr[i];
					arr[i] = arr[j];
					arr[j] = hold;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if(i==0) {
				System.out.print(arr[i]);
			}
			else {
				System.out.print(", " + arr[i]);
			}
		}
		System.out.println();
	}

	//Q2
	public void fib() {
		System.out.println("----------------------------");
		System.out.println("Start of Q2");
		int[] arr = new int[25];
		for(int i = 0; i< arr.length; i++)
		{
			if(i<2) {
				arr[i] = i;
			}
			else {
				arr[i] = arr[i-1] + arr[i-2];
			}
			if(i==0) {
				System.out.print(arr[i]);
			}
			else {
				System.out.print(", " + arr[i]);
			}
		}
		System.out.println();
	}

	//Q3
	public String strReverse(String str) {
		System.out.println("----------------------------");
		System.out.println("Start of Q3");
		//String str = "Hello, World!";
		int len = str.length();
		for(int i = len-1; i>=0; i--) {
			str += str.charAt(i);
		}
		str = str.substring(len);
		System.out.println(str);
		return str;
	}

	//Q4
	public long factorialOfN(long n) {
		System.out.println("----------------------------");
		System.out.println("Start of Q4");
		//Function after main
		System.out.println(factorial(n));
		return factorial(n);
	}

	//Q5
	public String subStr(String str, int end){
		System.out.println("----------------------------");
		System.out.println("Start of Q5");
		//Function after factorial
		System.out.println(subString(str, end));
		return subString(str, end);
	}

	//Q6
	public boolean isEven(int x){
		System.out.println("----------------------------");
		System.out.println("Start of Q6");
		//double x = 9;
		Double val = (double) (x / 2);
		//int check = (int)val;
		if((val  - val.intValue()) != 0.0) {
			System.out.println(x + " is not even.");
			return false;
		}
		else {
			System.out.println(x + " is even.");
			return true;
		}
	}

	//Q7
	public void employeeSort() {
		System.out.println("----------------------------");
		System.out.println("Start of Q7");
		Employee[] emp = {new Employee("Wezley", "Trainer", 27), new Employee("Christian", "Trainee", 24)};
		EmployeeComparator employeeComparator = new EmployeeComparator();
		int value = employeeComparator.compare(emp[0], emp[1]);
		System.out.println("Value = " + value);
	}

	//Q8
	public void findPalindromes() {
		System.out.println("----------------------------");
		System.out.println("Start of Q8");
		ArrayList<String> arrayList = new ArrayList<>();
		ArrayList<String> palad = new ArrayList<>();
		arrayList.add("karan");
		arrayList.add("madam");
		arrayList.add("tom");
		arrayList.add("civic");
		arrayList.add("radar");
		arrayList.add("jimmy");
		arrayList.add("kayak");
		arrayList.add("john");
		arrayList.add("refer");
		arrayList.add("billy");
		arrayList.add("did");
		for(String str : arrayList) {
			char[] arr = str.toCharArray();
			int len = arr.length-1;
			boolean p = true;
			for(int i = 0; i<(arr.length/2); i++) {
				if(arr[i] != arr[len-i]) {
					p = false;
				}
			}
			if(p) {
				palad.add(str);
			}
		}
		System.out.println(palad);
	}

	//Q9
	public void primesToN(int n) {
		System.out.println("----------------------------");
		System.out.println("Start of Q9");
		ArrayList<Integer> arrayList = new ArrayList<>();
		for(int i = 1; i<=n; i++) {
			arrayList.add(i);
		}
		for(int i : arrayList) {
			if(i == 1) {
				System.out.print(i);
				continue;
			}
			boolean prime = true;
			for(int j=2; j<i; j++) {
				if((i%j) == 0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				System.out.print(", " + i);
			}
		}
		System.out.println();
	}

	//Q10
	public int min(int i, int j){
		System.out.println("----------------------------");
		System.out.println("Start of Q10");
		//int i = 5;
		//int j = 3;
		int min = (i<j) ? i : j;
		System.out.println(min);
		return min;
	}

	//Q11
	public float compareOther() {
		System.out.println("----------------------------");
		System.out.println("Start of Q11");
		if(float1 < float2) {
			System.out.println(float1);
			return float1;
		} else {
			System.out.println(float2);
			return float2;
		}
	}

	//Q12
	public void evenTo100() {
		System.out.println("----------------------------");
		System.out.println("Start of Q12");
		int[] arr = new int[100];
		for(int i = 0; i< arr.length; i++) {
			arr[i] = i+1;
		}
		for(int num : arr) {
			if(num%2 == 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}

	//Q13
	public void triangle() {
		System.out.println("----------------------------");
		System.out.println("Start of Q13");
		int ch = 0;
		for(int i = 1; i <= 4; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(ch);
				ch = (ch+1)%2;
			}
			System.out.println();
		}
	}

	//Q14
	public void switchCase(int i) {
		System.out.println("----------------------------");
		System.out.println("Start of Q14");
		//int i = 1;
		switch(i) {
		case 1:
			double num = 36;
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			LocalDate dt = LocalDate.now();
			System.out.println(dt);
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");
			System.out.println(arr);
			break;
		}
	}

	//Q15
	public void artihmetic() {
		System.out.println("----------------------------");
		System.out.println("Start of Q15");
		ArithmeticImpl arth = new ArithmeticImpl();
		System.out.println("2 + 2 = " + arth.addition(2, 2));
		System.out.println("42 - 36 = " + arth.subtraction(42, 36));
		System.out.println("3 * 7 = " + arth.multiplication(3, 7));
		System.out.println("81 / 4 = " + arth.division(81, 4));
	}

	//Q16
	public int strLen(String str){
		System.out.println("----------------------------");
		System.out.println("Start of Q16");
		System.out.println(str + " has " + str.length() + " characters.");
		return str.length();
	}

	//Q17
	public double interestCalculator() {
		System.out.println("----------------------------");
		System.out.println("Start of Q17");
		double principal, rate, time, interest;
		System.out.print("Principal: ");
		userInput = scan.nextLine();
		principal = Double.parseDouble(userInput);

		System.out.print("Rate: ");
		userInput = scan.nextLine();
		rate = Double.parseDouble(userInput);

		System.out.print("Time: ");
		userInput = scan.nextLine();
		time = Double.parseDouble(userInput);

		interest = principal * rate * time;
		System.out.println("Interest = " + interest);
		return interest;
	}

	//Q18
	public void inheritance() {
		System.out.println("----------------------------");
		System.out.println("Start of Q18");
		StringSub strSub = new StringSub();
		if(strSub.checkUpperCase("Hello, World!")) {
			System.out.println("Hello, World! contains uppercase letters.");
		} else {
			System.out.println("Hello, World! doesn't contains uppercase letters.");
		}

		System.out.println("toUpper(\"Hello, World!\") = " + strSub.toUpper("Hello, World!"));

		System.out.println("toInt(\"12\" = " + strSub.toInt("12"));
	}

	//Q19
	public void listMath() {
		System.out.println("----------------------------");
		System.out.println("Start of Q19");
		ArrayList<Integer> arrayList = new ArrayList<>();
		int evenSum = 0;
		int oddSum = 0;
		for(int i = 1; i <= 10; i++) {
			arrayList.add(i);
		}
		System.out.println(arrayList);
		int len = arrayList.size();
		for(int i = 1; i <= len; i++) {
			if((i%2) == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}

			if(i == 1) {
				arrayList.remove(i-1);
				continue;
			}

			boolean prime = true;
			for(int j = 2; j < i; j++) {
				if((i%j)==0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				arrayList.remove(new Integer(i));
			}
		}
		System.out.println("Even sum = " + evenSum);
		System.out.println("Odd sum = " + oddSum);
		System.out.println(arrayList);
	}

	//Q20
	public void fileReader() {
		System.out.println("----------------------------");
		System.out.println("Start of Q20");
		String path = "C:\\Users\\Christian Defaria\\project-repos\\1806-Jun18-Java-USF\\Christian_DeFaria\\" + 
				"CoreJavaQs\\src\\main\\resources\\Data.txt";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));) {

			/*
			 * Write the specified object to the specified ObjectOutputStream. The class of the object, the signature of
			 * the class, and the values of the non-transient and non-static fields of the class and all of its
			 * super types are written
			 */
			bw.write("Mickey:Mouse:35:Arizona\n");
			bw.write("Hulk:Hogan:50:Virginia\n");
			bw.write("Roger:Rabbit:22:California\n");
			bw.write("Wonder:Woman:18:Montana");

		} catch (FileNotFoundException e) {
			System.out.println("[LOG] - An error occurred while accessing the file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[LOG] - An error occurred while writing to the file");
			e.printStackTrace();
		}

		try(BufferedReader br = new BufferedReader(new FileReader(path));) {

			String line = br.readLine();

			while(line != null) {
				String[] arr = line.split(":");
				System.out.println("Name: " + arr[0] + " " + arr[1]);
				System.out.println("Age: " + arr[2] + " years");
				System.out.println("State: " + arr[3] + " State");
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int factorial(long n) {
		if(n<1) {
			return 0;
		}
		int value = 1;
		for(int i = 1; i<=n; i++) {
			value *= i;
		}
		return value;
	}

	//For Q5
	public static String subString(String str, int idx) {
		if(str == "" || idx < 1) {
			return "";
		}
		String subStr = "";
		for(int i = 0; i < idx; i++) {
			subStr += str.charAt(i);
		}
		return subStr;
	}
}
