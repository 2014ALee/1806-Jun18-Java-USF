package com.revature;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

/*
 * Class used to create other classes
 */
public class FactoryDriver {
	
	public static void main(String[] args) {
		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + usa.getSymbol());
		
		country = "Germany";
		Currency germany = CurrencyFactory.createCurrency(country);
		System.out.println("Germany currency: " + germany.getSymbol());
		
		country = "China";
		Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("China currency: " + china.getSymbol());
		
		country = "Canada";
		Currency canada = CurrencyFactory.createCurrency(country);
		System.out.println("Canada currency: " + canada.getSymbol());
	}

}
