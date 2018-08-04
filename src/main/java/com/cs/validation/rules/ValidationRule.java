package com.cs.validation.rules;

import com.cs.validation.model.Trade;

public interface ValidationRule {
	boolean validate(Trade trade);

	String getErrorMessage();
}
