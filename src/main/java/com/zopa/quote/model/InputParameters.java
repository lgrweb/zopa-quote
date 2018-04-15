package com.zopa.quote.model;

import com.zopa.quote.exceptions.InvalidAmountException;

public class InputParameters {

	private static final Integer MIN_AMOUNT = 1000;
	private static final Integer MAX_AMOUNT = 15000;
	private static final Integer INCREMENT_AMOUNT = 100;

	private String file;
	private Integer amount;

	public InputParameters(String file, String amount) throws InvalidAmountException {

		this.file = file;
		this.amount = convertAmountFromString(amount);

	}

	private Integer convertAmountFromString(String amount) throws InvalidAmountException {

		Integer parsedAmount = null;

		try {

			parsedAmount = Integer.parseInt(amount);

			checkAmountRange(parsedAmount);
			checkAmountIncrement(parsedAmount);

		} catch (NumberFormatException e) {
			throw new InvalidAmountException(InvalidAmountException.INVALID_AMOUNT_TYPE);
		} catch (InvalidAmountException e) {
			throw e;
		}

		return parsedAmount;
	}

	private void checkAmountIncrement(Integer amount) throws InvalidAmountException {
		if (amount % INCREMENT_AMOUNT != 0) {
			throw new InvalidAmountException(InvalidAmountException.INVALID_AMOUNT_INCREMENT);
		}
	}

	private void checkAmountRange(Integer amount) throws InvalidAmountException {
		if (amount < MIN_AMOUNT || amount > MAX_AMOUNT) {
			throw new InvalidAmountException(InvalidAmountException.INVALID_AMOUNT_RANGE);
		}
	}

	/**
	 * @return the file
	 */
	public final String getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public final void setFile(String file) {
		this.file = file;
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
