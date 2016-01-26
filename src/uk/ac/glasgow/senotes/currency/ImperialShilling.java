package uk.ac.glasgow.senotes.currency;


public class ImperialShilling extends Currency {

	public ImperialShilling(Integer amount) {
		super(amount);
	}

	@Override
	public Integer getPennyValue() {
		return 12*amount;
	}

}
