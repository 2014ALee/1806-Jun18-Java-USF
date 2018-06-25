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

		country = "Hyrule";
		Currency hyrule = CurrencyFactory.createCurrency(country);
		System.out.println("Hyrule currency: " + hyrule.getSymbol());

		country = "Venezula";
		Currency venezula = CurrencyFactory.createCurrency(country);
		System.out.println("Venezula currency: " + venezula.getSymbol());
	}
}
