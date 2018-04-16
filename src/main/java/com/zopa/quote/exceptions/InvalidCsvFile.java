package com.zopa.quote.exceptions;

public class InvalidCsvFile extends BusinessException {

    private static final long serialVersionUID = -2855871087654284016L;

    public static final String INVALID_FILE = "Error opening de CSV file!";

    public InvalidCsvFile(final String message) {
        super(message);
    }

}
