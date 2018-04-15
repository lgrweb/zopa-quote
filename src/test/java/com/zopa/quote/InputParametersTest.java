package com.zopa.quote;

import org.junit.Test;
import static org.junit.Assert.*;

import com.zopa.quote.exceptions.InvalidAmountException;
import com.zopa.quote.model.InputParameters;

public class InputParametersTest {

	@Test(expected = InvalidAmountException.class)
	public void shouldthrowErrorWhenCalledWithInvalidAmount() throws InvalidAmountException {
		new InputParameters("file", "amount");
	}

	@Test(expected = InvalidAmountException.class)
	public void shouldThrowErrorWhenCalledWithAmountLessThanRange() throws InvalidAmountException {
		new InputParameters("file", "100");
	}

	@Test(expected = InvalidAmountException.class)
	public void shouldPrintErrorWhenCalledWithAmountGreaterThanRange() throws InvalidAmountException {
		new InputParameters("file", "16000");
	}

	@Test(expected = InvalidAmountException.class)
	public void shouldPrintErrorWhenCalledWithWrongAmountIncrement() throws InvalidAmountException {
		new InputParameters("file", "1001");
	}
	
	@Test
	public void shouldCreateAnInputParametersInstance() throws InvalidAmountException {

		InputParameters inputParameters = new InputParameters("file", "1000");

		assertNotNull(inputParameters);
		assertEquals("file", inputParameters.getFile());
		assertEquals(new Integer(1000), inputParameters.getAmount());
	}
}
