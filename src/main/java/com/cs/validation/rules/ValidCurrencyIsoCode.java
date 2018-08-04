package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.util.Locale;
import java.util.regex.Pattern;

class ValidCurrencyIsoCode implements ValidationRule {

	static final Pattern REGEX_FORMAT = Pattern.compile("[A-Z]{3}[A-Z]{3}");

	@Override

	public boolean validate(Trade trade) {
		return REGEX_FORMAT.matcher(trade.getCcyPair().toUpperCase(Locale.ENGLISH)).matches();
	}

	@Override
	public String getErrorMessage() {
		return "Currency pair is not compliant with ISO code 4217";
	}
}
