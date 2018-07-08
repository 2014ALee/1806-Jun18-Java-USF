package com.revature.util;

import com.revature.models.Bitcoin;
import com.revature.models.Currency;
import com.revature.models.Euro;
import com.revature.models.USDallar;
import com.revature.models.Yuan;

public class CurrencyFactory {

	public static Currency createCurrency(String country) {
		
		switch (country) {
		case "USA":
			return new USDallar();
		case "Germany":
			return new Euro();
		case "China":
			return new Yuan();
		default:
			return new Bitcoin();
		}
	}
}
