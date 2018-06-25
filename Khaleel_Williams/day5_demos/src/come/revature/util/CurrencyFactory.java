package come.revature.util;

import com.revature.models.Bitcoin;
import com.revature.models.Currency;
import com.revature.models.Euro;
import com.revature.models.USDollar;
import com.revature.models.Yuan;

public class CurrencyFactory {
	
	public static Currency createCurrency(String country) {
		
		switch(country) {
		case "USA":
			return new USDollar();
		case "Germany":
			return new Euro();
		case "France":
			return new Euro();
		case "Italy":
			return new Euro();
		case "China":
			return new Yuan();
		default:
			return new Bitcoin();
		}
	}

}
