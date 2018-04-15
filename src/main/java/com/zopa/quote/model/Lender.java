package com.zopa.quote.model;

import com.zopa.quote.util.Converters;

public class Lender {

	private String name;
	private Double rate;
	private Integer amount;

	public Lender(String name, String rate, String amount) {
		this.name = name;
		this.rate = convertRateFromString(amount);
		this.amount = convertAmountFromString(amount);
	}

	private Double convertRateFromString(String rate) {
		return Converters.stringToDouble(rate);
	}
	
	private Integer convertAmountFromString(String amount) {
		return Converters.stringToInteger(amount);
	}
	
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rate
	 */
	public final Double getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public final void setRate(Double rate) {
		this.rate = rate;
	}

	/**
	 * @return the amount
	 */
	public final Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public final void setAmount(Integer amount) {
		this.amount = amount;
	}

}
