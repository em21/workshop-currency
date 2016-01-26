package uk.ac.glasgow.senotes.currency;


public class ImperialPound extends Currency {

	public ImperialPound(Integer amount) {
		super(amount);
	}

	@Override
	public Integer getPennyValue() {
		return 240*amount;
	}

}
