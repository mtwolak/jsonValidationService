package com.cs.validation.rules;

import com.cs.validation.Trade;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueDateAfterTradeDateTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new ValueDateAfterTradeDate();
	}

	@Test
	public void shouldValidationSuccessWhenValueDateIsBeforeTradeDate() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-02-01"));
		trade.setTradeDate(LocalDate.parse("2018-03-01"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsAfterTradeDate() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setTradeDate(LocalDate.parse("2000-01-01"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

}