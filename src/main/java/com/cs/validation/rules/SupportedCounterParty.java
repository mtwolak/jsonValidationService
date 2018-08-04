package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SupportedCounterParty implements ValidationRule {

	private static final Set<String> SUPPORTED_COUNTERPARTIES = Stream.of("PLUTO1", "PLUTO2").collect(Collectors.toSet());

	@Override
	public boolean validate(Trade trade) {
		return SUPPORTED_COUNTERPARTIES.contains(trade.getCustomer());
	}

	@Override
	public String getErrorMessage() {
		return "Customer is not supported";
	}
}
