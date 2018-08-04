package com.cs.validation.web;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResult;
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
	public void shouldGiveManyErrorMessagesWhenManyConstraintsFails() {
		Trade trade = new Trade();
		trade.setTradeDate(LocalDate.parse("2017-05-03"));
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setCustomer("Not supported customer");
		trade.setCcyPair("Not supported currency pair");
		trade.setStyle("Not supported style");

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessages()).containsOnly(
				"Value date cannot fall on weekend or non-working day.",
				"Value date cannot be after trade date.",
				"Customer is not supported",
				"Currency pair is not compliant with ISO code 4217",
				"Style is not supported");
	}

	@Test
	public void shouldGiveErrorWhenAmericanStyleWithExerciseDateNotAfterTradeDateOrBeforeExpirationDate() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("American");
		trade.setExcerciseStartDate(LocalDate.parse("2010-10-10"));
		trade.setTradeDate(LocalDate.parse("2012-10-10"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessages()).containsOnly("Incorrect exerciseStartDate.", "Value date cannot be after trade date.");

	}
}