package com.paremal.lamda.operations;

public class Transaction {

	private final Trader trader;
	private final int year;
	private final int value;
	private final String currency;

	public Transaction(Trader trader, int year, int value, String currency) {
		this.trader = trader;
		this.year = year;
		this.value = value;
		this.currency= currency;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}
	

	public String getCurrency() {
		return currency;
	}

	public String toString() {
		return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value +", " + "Currency:" + this.currency + "}";
	}

}
