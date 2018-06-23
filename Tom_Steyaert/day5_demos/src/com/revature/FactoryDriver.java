package com.revature;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

public class FactoryDriver {

	public static void main(String[] args) {
		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + usa.getSymbol());
		
		country = "China";
		Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("China currency: " + china.getSymbol());
		
		country = "Venezuela";
		Currency venezuela = CurrencyFactory.createCurrency(country);
		System.out.println("Ven currency: " + venezuela.getSymbol());	
	}
	=
}
