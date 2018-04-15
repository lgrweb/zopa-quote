package com.zopa.quote;

import com.zopa.quote.exceptions.InvalidAmountException;
import com.zopa.quote.model.InputParameters;
import com.zopa.quote.service.QuoteService;

/**
 * @author Luis
 *
 */
public class Quote {
	
	private static final int ARGUMENTS_LENGTH = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Quote(args);
	}

	protected Quote(String[] args) {

		try {
			
			if (validateArguments(args)) {
				InputParameters inputParameters = new InputParameters(args[0], args[1]);
				
				QuoteService quoteService = new QuoteService(inputParameters);
				
				
			}
			
		} catch (IllegalArgumentException e) {
			System.out.print(e.getMessage());
			//System.exit(1);
		} catch (InvalidAmountException e) {
			System.out.print(e.getMessage());
			//System.exit(1);
		} 

	}

	private boolean validateArguments(String[] args) {

		if (args == null || args.length != ARGUMENTS_LENGTH) {
			throw new IllegalArgumentException(
					"Invalid arguments! You should pass the CSV file and the loan amount, in this order.");
		}

		return true;
	}

}
