package com.cs.validation.rules;

import com.cs.validation.CorrectTrade;
import com.cs.validation.model.Trade;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpiryDateBeforeDeliveryDateTest {

	private ValidationRule tradeValidator;

	@Before
	public void setUp() {
		tradeValidator = new ExpiryDateBeforeDeliveryDate();
	}

	@Test
	public void shouldValidationSuccessWhenExpiryAndPremiumDateIsBeforeDeliveryDate() {
		Trade trade = CorrectTrade.create();
		trade.setExpiryDate(LocalDate.parse("2010-02-02"));
		trade.setPremiumDate(LocalDate.parse("2010-02-02"));
		trade.setDeliveryDate(LocalDate.parse("2012-02-02"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isTrue();
	}

	@Test
	public void shouldValidationFailWhenExpiryDateIsAfterDeliveryDate() {
		Trade trade = CorrectTrade.create();
		trade.setExpiryDate(LocalDate.parse("2012-02-02"));
		trade.setDeliveryDate(LocalDate.parse("2010-02-02"));
		trade.setPremiumDate(null);

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationFailWhenPremiumDateIsAfterDeliveryDate() {
		Trade trade = CorrectTrade.create();
		trade.setPremiumDate(LocalDate.parse("2012-02-02"));
		trade.setDeliveryDate(LocalDate.parse("2010-02-02"));
		trade.setExpiryDate(null);

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}

	@Test
	public void shouldValidationFailWhenPremiumAndExpiryDateAreAfterDeliveryDate() {
		Trade trade = CorrectTrade.create();
		trade.setPremiumDate(LocalDate.parse("2012-02-02"));
		trade.setExpiryDate(LocalDate.parse("2013-02-02"));
		trade.setDeliveryDate(LocalDate.parse("2010-02-02"));

		boolean validationResult = tradeValidator.validate(trade);

		assertThat(validationResult).isFalse();
	}
}