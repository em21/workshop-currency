package uk.ac.glasgow.senotes.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ImperialPoundSterlingCurrencyParser implements CurrencyParser {
	
	@Override
	public List<Currency> parseCurrency(String currency) {
		
		//1. Construct a new list of Currency objects
		//   for storing the parsed denominations.
		List<Currency> currencyList = new ArrayList<Currency>();
		
		//2. Construct a new scanner for the currency String.
		Scanner sc = new Scanner(currency);
		//3. Set the scanners delimiter to the following String
		//   pattern:
		//				"£|\\.|s\\.|d\\."
		sc.useDelimiter("£|\\.|s\\.|d\\.");
		
		//4. Parse out each of the amounts for pounds shillings
		//   pence from the scanner.
		Currency pound = new ImperialPound(sc.nextInt());
		Currency shilling = new ImperialShilling(sc.nextInt());
		Currency d = new ImperialPenny(sc.nextInt());
		
		//5. Add 3 new currency objects to the result list for
		//   the parsed amounts.
		currencyList.add(pound);
		currencyList.add(shilling);
		currencyList.add(d);
		
		sc.close();
		//6. Return the result.
		return currencyList;
	}

}
