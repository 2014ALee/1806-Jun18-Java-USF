package com.revature;

import com.revature.models.Currency;

import come.revature.util.CurrencyFactory;

public class FactoryDriver {
	
	public static void main(String[] args) {
		
		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + usa.getSymbol());
		
		country = "Italy";
		Currency italy = CurrencyFactory.createCurrency(country);
		System.out.println("Italy currency: " + italy.getSymbol());
		
		country = "China";
		Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + china.getSymbol());
		
		country = "Venezuela";
		Currency venezuela = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + venezuela.getSymbol());
		
	}

}
