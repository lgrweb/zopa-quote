package com.zopa.quote;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.zopa.quote.exceptions.InvalidAmountException;

public class QuoteTest {

	private PrintStream console;
	private ByteArrayOutputStream bytes;

	@Before
	public void setUp() {
		bytes = new ByteArrayOutputStream();
		console = System.out;
		System.setOut(new PrintStream(bytes));
	}

	@Test
	public void shouldPrintAnErrorWhenCalledWithNoParameter() {
		new Quote(null);
		assertEquals("Invalid arguments! You should pass the CSV file and the loan amount, in this order.",
				bytes.toString());
	}

	@Test
	public void shouldPrintAnErrorWhenCalledWithOneParameter() {
		new Quote(new String[] { "file" });
		assertEquals("Invalid arguments! You should pass the CSV file and the loan amount, in this order.",
				bytes.toString());
	}

	@Test
	public void shouldPrintErrorWhenCalledWithInvalidAmount() {
		new Quote(new String[] { "file", "amount" });
		assertEquals(InvalidAmountException.INVALID_AMOUNT_TYPE, bytes.toString());
	}

	@Test
	public void shouldPrintErrorWhenCalledWithAmountLessThanRange() {
		new Quote(new String[] { "file", "100" });
		assertEquals(InvalidAmountException.INVALID_AMOUNT_RANGE, bytes.toString());
	}

	@Test
	public void shouldPrintErrorWhenCalledWithAmountGreaterThanRange() {
		new Quote(new String[] { "file", "16000" });
		assertEquals(InvalidAmountException.INVALID_AMOUNT_RANGE, bytes.toString());
	}
}
