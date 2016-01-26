package uk.ac.glasgow.senotes.currency;


public class DecimalPound extends Currency {

	public DecimalPound(Integer amount) {
		super(amount);
	}

	@Override
	public Integer getPennyValue() {
		return 100*amount;
	}

}
