package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueDateNotOnWeekendOrNonWorkingDayTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new ValueDateNotOnWeekendOrNonWorkingDay();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnSaturday() {
		Trade trade = CorrectTrade.create();
		LocalDate saturday = LocalDate.parse("2018-08-04");
		trade.setValueDate(saturday);
		trade.setTradeDate(LocalDate.parse("2018-08-05"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(saturday.getDayOfWeek()).isEqualTo(DayOfWeek.SATURDAY);
		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnSunday() {
		Trade trade = CorrectTrade.create();
		LocalDate sunday = LocalDate.parse("2018-08-05");
		trade.setValueDate(sunday);
		trade.setTradeDate(LocalDate.parse("2018-08-06"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(sunday.getDayOfWeek()).isEqualTo(DayOfWeek.SUNDAY);
		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationPassWhenValueDateIsNotOnWeekendAndIsNotFreeDay() {
		Trade trade = CorrectTrade.create();
		LocalDate sunday = LocalDate.parse("2018-08-06");
		trade.setValueDate(sunday);
		trade.setTradeDate(LocalDate.parse("2018-08-07"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(sunday.getDayOfWeek()).isEqualTo(DayOfWeek.MONDAY);
		assertThat(validationResult).isTrue();
	}

	@Test
	public void shouldValidationFailWhenValueDateIsOnFreeDay() {
		Trade trade = CorrectTrade.create();
		LocalDate valueDate = LocalDate.parse("2018-01-01");
		LocalDate tradeDate = LocalDate.parse("2018-08-06");
		trade.setValueDate(valueDate);
		trade.setTradeDate(tradeDate);

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(valueDate.getDayOfWeek()).isNotIn(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);
		assertThat(validationResult).isFalse();
	}
}