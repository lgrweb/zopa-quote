package com.zopa.quote.exceptions;

public class InvalidAmountException extends BusinessException {

	private static final long serialVersionUID = -8745620504325271824L;
	
	public final static String INVALID_AMOUNT_TYPE = "Invalid requested amount! It should be and Integer value.";
	public final static String INVALID_AMOUNT_RANGE = "Invalid requested amount! The requested amount should be between 1000 and 15000.";
	public final static String INVALID_AMOUNT_INCREMENT = "Invalid requested amount! The requested amount should be an incremente of 100.";

	public InvalidAmountException(String message) {
		super(message);
	}

}
