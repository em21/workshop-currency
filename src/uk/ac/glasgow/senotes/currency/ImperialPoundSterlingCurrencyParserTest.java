package uk.ac.glasgow.senotes.currency;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ImperialPoundSterlingCurrencyParserTest {

	private CurrencyParser cp;
	private CurrencyConverter cc;
	@Before
	public void setUp() throws Exception {
		cp = new ImperialPoundSterlingCurrencyParser();
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
	
	public void testAddCurrency(){
		
		//test cc.addCurrency(something)
		//see if something is in the list
		//the currencyList should have 'something' in the list
		
		//assertEquals(something, cc.getCurrencyList(0));
		
		
	}
	public void testDispose(){
		//dispense is a method to turn your old money into new money
		//it takes in old currency, turn them all into pennies
		//convert into new currency, clear the currencyList
		//then add new one in
				
		//test cc.dispose(old)
		//check if the result is the same as expected
		//assertEquals(new, cc.dispose(old))
	}

}
