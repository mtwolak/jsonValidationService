package com.cs.validation.rules;

import java.util.LinkedList;
import java.util.List;

public class ValidationRulesFactory {
	public static List<ValidationRule> createValidationRules() {
		List<ValidationRule> validationRules = new LinkedList<>();
		validationRules.add(new ValueDateAfterTradeDate());
		validationRules.add(new ValueDateNotOnWeekendOrNonWorkingDay());
		validationRules.add(new SupportedCounterParty());
		validationRules.add(new ValidCurrencyIsoCode());
		validationRules.add(new SupportedStyles());
		return validationRules;
	}
}
