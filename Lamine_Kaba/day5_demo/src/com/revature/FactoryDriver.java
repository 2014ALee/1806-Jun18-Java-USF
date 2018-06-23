package com.revature;

import java.util.Currency;

import com.revature.util.CurrencyFactory;

public class FactoryDriver {

	public static void main(String[] args) {
		
		String country;
		
		country = "USa";
		
		com.revature.models.Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + usa.getSymbol());
		
		country = "China";
		
		com.revature.models.Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + china.getSymbol());
		
		country = "Mexico";
		
		com.revature.models.Currency mexico = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + mexico.getSymbol());
	}
}
