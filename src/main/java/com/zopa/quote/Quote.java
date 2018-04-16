package com.zopa.quote;

import com.zopa.quote.exceptions.InvalidAmountException;
import com.zopa.quote.exceptions.InvalidCsvFile;
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
    public static void main(final String[] args) {
        new Quote(args);
    }

    protected Quote(final String[] args) {

        try {

            if (validateArguments(args)) {
                final InputParameters inputParameters = new InputParameters(args[0], args[1]);

                final QuoteService quoteService = new QuoteService(inputParameters);

            }

        } catch (final IllegalArgumentException e) {
            System.out.print(e.getMessage());
        } catch (final InvalidAmountException e) {
            System.out.print(e.getMessage());
        } catch (final InvalidCsvFile e) {
            e.printStackTrace();
        }

    }

    private boolean validateArguments(final String[] args) {

        if (args == null || args.length != ARGUMENTS_LENGTH) {
            throw new IllegalArgumentException("Invalid arguments! You should pass the CSV file and the loan amount, in this order.");
        }

        return true;
    }

}
