package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResult;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TradeValidatorTest {

	@Test
	public void shouldGiveManyErrorMessagesWhenManyConstraintsFails() {
		TradeValidator tradeValidator = new TradeValidator();

		Trade trade = new Trade();
		trade.setTradeDate(LocalDate.parse("2017-05-03"));
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setCustomer("Not supported customer");
		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessages()).contains(
				"Value date cannot fall on weekend or non-working day.",
				"Value date cannot be after trade date.",
				"Customer is not supported");
	}
}