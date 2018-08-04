package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SupportedCounterPartyTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new SupportedCounterParty();
	}

	@Test
	public void shouldValidationSuccessWhenSupportedCustomer() {
		Trade trade = CorrectTrade.create();
		trade.setCustomer("PLUTO1");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}

	@Test
	public void shouldValidationFailWhenCustomerIsNotSupported() {
		Trade trade = CorrectTrade.create();
		trade.setCustomer("Not supported customer");

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}
}