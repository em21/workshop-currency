package uk.ac.glasgow.senotes.currency;

import java.util.ArrayList;
import java.util.List;


public class ImperialToDecimalCurrencyConverter implements CurrencyConverter{
	
	//declare a new field to hold a list of Currency objects here.
	private static List<Currency> currency = new ArrayList<>();
	/**
	 * Adds an element of imperial currency (pounds, shilling or pence)
	 * to the converter. 
	 * @param c
	 */
	@Override
	public void addCurrency(Currency c) {
		//1. Add the currency to the list of currencies stored in
		//   in the money field above.
		currency.add(c);
	}

	/**
	 * Returns a 2 element list of new pounds and new pence
	 * at the 1971 conversion rate.  Any internal state is reset.
	 */
	@Override
	public List<Currency> dispense() {
		//1. Construct a new list to hold the currency of the new
		//     denomination.
		List<Currency> convertedCurrency = new ArrayList<>(); 
		//2. Declare a total integer variable.
		int total = 0;
		//3. For each currency object in the money field, add the
		//   penny value to the total.
		total += currency.get(0).getPennyValue();
		total += currency.get(1).getPennyValue();
		total += currency.get(2).getPennyValue();
		
		//4. Calculate the amount of pounds in the total by
		//   dividing by 240 (20*12).
		Currency newPound = new DecimalPound(total/240);

		//5. Calculate the amount of old pennies in the total by
		//   calculating the remainder of dividing by 240
		//   (% operator).
		int oldPennies = total % 240;
		
		//6. Calculate the amount of new pennies by multiplying
		//   the amount of old pennies by 5 and dividing by 12
		Currency newPence = new DecimalPenny((oldPennies*5)/12);
		
		//7. Add the new pounds and new pence amounts to the 
		//   new currency list as Currency objects.
		convertedCurrency.add(newPound);
		convertedCurrency.add(newPence);
		
		//8. Clear the money list.
		currency.remove(currency);
		
		//9. Return the result.
		return convertedCurrency;
	}

}
