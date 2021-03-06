package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResult;
import com.cs.validation.rules.ValidationRule;
import com.cs.validation.rules.ValidationRulesFactory;

import java.util.List;

class TradeValidator {

	private List<ValidationRule> validationRules;

	TradeValidator() {
		validationRules = ValidationRulesFactory.createValidationRules();
	}

	ValidationResult validate(Trade trade) {
		ValidationResult validationResult = new ValidationResult();

		for (ValidationRule validationRule : validationRules) {
			if (!validationRule.validate(trade)) {
				validationResult.addErrorMessage(validationRule.getErrorMessage());
			}
		}
		return validationResult;
	}
}
