package uk.ac.glasgow.senotes.currency;


public class DecimalPenny extends Currency {

	public DecimalPenny(Integer amount) {
		super(amount);
	}

	@Override
	public Integer getPennyValue() {
		return 1*amount;
	}

}
