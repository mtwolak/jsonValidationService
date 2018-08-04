package com.cs.validation;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeValidatorTest {

	private TradeValidator tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new TradeValidator();
	}

	@Test
	public void shouldValidationSuccessWhenValueDateIsBeforeTradeDate() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setTradeDate(LocalDate.parse("2018-02-01"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isFalse();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsAfterTradeDate() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setTradeDate(LocalDate.parse("2000-01-01"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessage()).isEqualTo("Value date cannot be after trade date");

	}
}