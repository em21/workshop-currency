package uk.ac.glasgow.senotes.currency;


public abstract class Currency {
	
	/**
	 * The amount of currency represented by this object.
	 */
	public int amount;
	
	public Currency(Integer amount){
		this.amount = amount;
	}
	
	/** 
	 * @return the value of this currency relative 
	 * to it's smallest denomination (penny).
	 */
	public abstract Integer getPennyValue();
}
