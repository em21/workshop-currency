package uk.ac.glasgow.senotes.currency;

import java.util.List;


public interface CurrencyConverter {
	
	/**
	 * Adds an amount of currency to the converter.
	 */
	public void addCurrency(Currency d);
	
	/**
	 * Returns a list of currency denominations 
	 * converted from the
	 * input currency to the new currency.
	 */
	public List<Currency> dispense ();
}
