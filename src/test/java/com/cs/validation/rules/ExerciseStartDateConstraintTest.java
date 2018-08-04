package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExerciseStartDateConstraintTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new ExerciseStartDateConstraint();
	}

	@Test
	public void shouldValidationFailWhenAmericanStyleWithExerciseDateBeforeTradeDate() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("AMERICAN");
		trade.setExcerciseStartDate(LocalDate.parse("2010-02-02"));
		trade.setTradeDate(LocalDate.parse("2012-02-02"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationFailWhenAmericanStyleWithExerciseDateAfterExpiryDate() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("AMERICAN");
		trade.setExcerciseStartDate(LocalDate.parse("2012-02-02"));
		trade.setExpiryDate(LocalDate.parse("2010-02-02"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationPassWhenAmericanStyleWithExerciseDateAfterTradeAndBeforeExpiryDate() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("AMERICAN");
		trade.setExcerciseStartDate(LocalDate.parse("2012-02-02"));
		trade.setTradeDate(LocalDate.parse("2010-02-02"));
		trade.setExpiryDate(LocalDate.parse("2014-02-02"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}
}