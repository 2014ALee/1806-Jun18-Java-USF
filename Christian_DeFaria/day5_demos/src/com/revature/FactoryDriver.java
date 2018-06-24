package com.revature;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

public class FactoryDriver {
	
	public static void main(String[] args) {
		String country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA Currency: " + usa.getSymbol());
		
		country = "Italy";
		Currency italy = CurrencyFactory.createCurrency(country);
		System.out.println("Italy currency: " + italy.getSymbol());
		
		country = "China";
		Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("China currency: " + china.getSymbol());
		
		country = "Venezuela";
		Currency ven = CurrencyFactory.createCurrency(country);
		System.out.println("Venezuela currency: " + ven.getSymbol());
	}

}
