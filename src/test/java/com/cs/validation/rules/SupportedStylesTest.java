package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SupportedStylesTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new SupportedStyles();
	}

	@Test
	public void shouldValidationSuccessWhenStyleIsSupported() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("EUROPEAN");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}

	@Test
	public void shouldValidationFailWhenStyleIsNotSupported() {
		Trade trade = CorrectTrade.create();
		trade.setStyle("Not supported style");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}
}