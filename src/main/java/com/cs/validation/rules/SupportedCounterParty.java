package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.util.HashSet;
import java.util.Set;

class SupportedCounterParty implements ValidationRule {

	private static final Set<String> SUPPORTED_COUNTERPARTIES = new HashSet<>();

	static {
		SUPPORTED_COUNTERPARTIES.add("PLUTO1");
		SUPPORTED_COUNTERPARTIES.add("PLUTO2");
	}

	@Override
	public boolean validate(Trade trade) {
		return SUPPORTED_COUNTERPARTIES.contains(trade.getCustomer());
	}

	@Override
	public String getErrorMessage() {
		return "Customer is not supported";
	}
}
