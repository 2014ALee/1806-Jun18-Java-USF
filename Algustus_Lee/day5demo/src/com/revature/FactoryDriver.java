package com.revature;

import com.revature.models.Currency;
import com.revature.util.CurrencyFactory;

/*
 * Factory design:
 * 
 * Exactly what it sounds like. Factory design is meant to create many classes.
 */
public class FactoryDriver {
	public static void main(String[] args)
	{
		String country;
		
		country = "USA";
		Currency usa = CurrencyFactory.createCurrency(country);
		System.out.println("USA currency: "+usa.getSymbol());
		

		country = "France";
		Currency france = CurrencyFactory.createCurrency(country);
		System.out.println("France currency: "+france.getSymbol());
		

		country = "USA";
		Currency china = CurrencyFactory.createCurrency(country);
		System.out.println("China currency: "+china.getSymbol());
		

		country = "Venezuela";
		Currency venezuela = CurrencyFactory.createCurrency(country);
		System.out.println("Venezuela currency: "+venezuela.getSymbol());
	}

}
