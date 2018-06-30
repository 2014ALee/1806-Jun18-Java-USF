package com.revature;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

public class FactoryDriver {
	public static void main(String[] args) {
		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: " + usa.getSymbol());
		
		country = "Italy";
		Currency italy = CurrencyFactory.createCurrency(country);
		System.out.println("Italy currency: " + italy.getSymbol());
		
		country = "Philippines";
		Currency pinoy = CurrencyFactory.createCurrency(country);
		System.out.println("Philippine currency: " + pinoy.getSymbol());
		
		country = "Neverland";
		Currency neverland = CurrencyFactory.createCurrency(country);
		System.out.println("Neverland currency: " + neverland.getSymbol());
	}
}
