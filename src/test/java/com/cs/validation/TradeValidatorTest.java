package com.cs.validation;

import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
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
		trade.setValueDate(LocalDate.parse("2018-02-01"));
		trade.setTradeDate(LocalDate.parse("2018-03-01"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isFalse();
		assertThat(validationResult.getErrorMessage()).isEmpty();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsAfterTradeDate() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-01-01"));
		trade.setTradeDate(LocalDate.parse("2000-01-01"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessage()).isEqualTo("Value date cannot be after trade date.");
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnSaturday() {
		Trade trade = new Trade();
		LocalDate saturday = LocalDate.parse("2018-08-04");
		trade.setValueDate(saturday);
		trade.setTradeDate(LocalDate.parse("2018-08-05"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(saturday.getDayOfWeek()).isEqualTo(DayOfWeek.SATURDAY);
		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessage()).isEqualTo("Value date cannot fall on weekend or non-working day.");
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnSunday() {
		Trade trade = new Trade();
		LocalDate sunday = LocalDate.parse("2018-08-05");
		trade.setValueDate(sunday);
		trade.setTradeDate(LocalDate.parse("2018-08-06"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(sunday.getDayOfWeek()).isEqualTo(DayOfWeek.SUNDAY);
		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessage()).isEqualTo("Value date cannot fall on weekend or non-working day.");
	}

	@Test
	public void shouldValidationPassWhenValueDateIsNotOnWeekendAndIsNotFreeDay() {
		Trade trade = new Trade();
		LocalDate sunday = LocalDate.parse("2018-08-06");
		trade.setValueDate(sunday);
		trade.setTradeDate(LocalDate.parse("2018-08-07"));

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(sunday.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
		assertThat(validationResult.hasErrors()).isFalse();
		assertThat(validationResult.getErrorMessage()).isEmpty();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnFreeDay() {
		Trade trade = new Trade();
		LocalDate valueDate = LocalDate.parse("2018-01-01");
		LocalDate tradeDate = LocalDate.parse("2018-08-06");
		trade.setValueDate(valueDate);
		trade.setTradeDate(tradeDate);

		ValidationResult validationResult = tradeValidator.validate(trade);

		assertThat(valueDate.getDayOfWeek()).isNotIn(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
		assertThat(validationResult.hasErrors()).isTrue();
		assertThat(validationResult.getErrorMessage()).isEqualTo("Value date cannot fall on weekend or non-working day.");
	}
}