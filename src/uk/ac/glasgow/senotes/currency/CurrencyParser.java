package uk.ac.glasgow.senotes.currency;

import java.util.List;

public interface CurrencyParser {
	
	/**
	 * Reads a String describing a currency specific
	 * format amount of money.
	 * @param currency
	 */
	public List<Currency> parseCurrency(String currency);
}
