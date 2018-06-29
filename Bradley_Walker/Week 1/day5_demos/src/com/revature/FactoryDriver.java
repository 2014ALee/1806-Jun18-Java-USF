package com.revature;

import java.util.Scanner;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

public class FactoryDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.print("Enter your country :> ");
			String input = scan.nextLine();
			Currency cash = CurrencyFactory.createCurrency(input);
			System.out.println(cash.getSymbol());
		}
	}

}
