package uk.ac.glasgow.senotes.currency;


public class ImperialPenny extends Currency {

	public ImperialPenny(Integer amount) {
		super(amount);
	}

	@Override
	public Integer getPennyValue() {
		return 1*amount;
	}

}
