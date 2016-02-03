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
		List<Currency> currency = cp.parseCurrency("£2.1s.4d.");
		assertEquals(2, currency.get(0).amount);
		assertEquals(1, currency.get(1).amount);
		assertEquals(4, currency.get(2).amount);
	
	}
	@Test
	public void testParseZero() {
		List<Currency> currency = cp.parseCurrency("£0.0s.0d.");
		assertEquals(0, currency.get(0).amount);
		assertEquals(0, currency.get(1).amount);
		assertEquals(0, currency.get(2).amount);
	}
	
	public void testParseNegative() {
		List<Currency> currency = cp.parseCurrency("£-1.0s.0d.");
		assertEquals(0, currency.get(0).amount);
		assertEquals(0, currency.get(1).amount);
		assertEquals(0, currency.get(2).amount);
	}
	
	@Test
	public void testConvert(){
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
	
	@Test
	public void testConvertZero(){
		List<Currency> convertedCurrency = new ArrayList<Currency>();
		
		Currency pound = new ImperialPound(0);
		Currency shilling = new ImperialShilling(0);
		Currency d = new ImperialPenny(0);
		
		//adding old money
		cc.addCurrency(pound);
		cc.addCurrency(shilling);
		cc.addCurrency(d);			
		
		//it takes in old currency, turn them all into pennies
		//convert into new currency, clear the currencyList
		//then add new one in
		convertedCurrency = cc.dispense();		

		//check if the result is the same as expected
		assertEquals(0, convertedCurrency.get(0).amount);
		assertEquals(0, convertedCurrency.get(1).amount);
	}
}
