package com.cs.validation.rules;

import com.cs.validation.Trade;

public interface ValidationRule {
	boolean validate(Trade trade);

	String getErrorMessage();
}
