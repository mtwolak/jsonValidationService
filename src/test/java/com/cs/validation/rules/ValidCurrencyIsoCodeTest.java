package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidCurrencyIsoCodeTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new ValidCurrencyIsoCode();
	}

	@Test
	public void shouldValidationFailWhenNotSupportedCurrency() {
		Trade trade = CorrectTrade.create();
		trade.setCcyPair("Unsupported currency");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationSuccessWhenSupportedCurrency() {
		Trade trade = CorrectTrade.create();
		trade.setCcyPair("EURUSD");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}
}