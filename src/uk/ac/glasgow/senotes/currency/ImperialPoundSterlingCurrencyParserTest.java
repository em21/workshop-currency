package uk.ac.glasgow.senotes.currency;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImperialPoundSterlingCurrencyParserTest {

	private static CurrencyParser cp;
	private CurrencyConverter cc;
	@Before
	public void setUp() throws Exception {
		cp = new ImperialPoundSterlingCurrencyParser();
		cc = new ImperialToDecimalCurrencyConverter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testParseCurrency() {
		List<Currency> currency = cp.parseCurrency("�2.1s.4d.");
		assertEquals(2, currency.get(0).amount);
		assertEquals(1, currency.get(1).amount);
		assertEquals(4, currency.get(2).amount);
	
	}
	@Test
	//trying to get the reference to CurrencyConverter's list of currency
	public void testAddCurrency(){
		//create a new list of currency
		List<Currency> currency = new ArrayList<Currency>();
		
		//test addCurrency
		//hopefully it adds into the currency list above
		cc.addCurrency(new ImperialPound(2));
		cc.addCurrency(new ImperialShilling(1));
		cc.addCurrency(new ImperialPenny(4));

		//check the addCurrency method. It does the add properly (see dispense below as proof) 
		//it would be nice if we can refer the currency below with the actual CurrencyConverter's list
		//This however refer to the currency list created above, so its an empty list therefore error
		assertEquals(2, currency.get(0).amount);
		assertEquals(1, currency.get(1).amount);
		assertEquals(4, currency.get(2).amount);
	}
	@Test
	public void testDispense(){
		//parse the string as currency
		//List<Currency> currency = cp.parseCurrency("�2.1s.4d.");
		
		//dispense is a method to turn your old money into new money
		List<Currency> convertedCurrency = new ArrayList<Currency>();
		
		Currency pound = new ImperialPound(2);
		Currency shilling = new ImperialShilling(1);
		Currency d = new ImperialPenny(4);
		
		//adding old money
		cc.addCurrency(pound);
		cc.addCurrency(shilling);
		cc.addCurrency(d);			
		
		//it takes in old currency, turn them all into pennies
		//convert into new currency, clear the currencyList
		//then add new one in
		convertedCurrency = cc.dispense();		

		//check if the result is the same as expected
		assertEquals(2, convertedCurrency.get(0).amount);
		assertEquals(6, convertedCurrency.get(1).amount);
	}
}
