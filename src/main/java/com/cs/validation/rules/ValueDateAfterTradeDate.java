package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.time.LocalDate;

class ValueDateAfterTradeDate implements ValidationRule {
	@Override
	public boolean validate(Trade trade) {
		LocalDate valueDate = trade.getValueDate();
		return valueDate == null || valueDate.isBefore(trade.getTradeDate());
	}

	@Override
	public String getErrorMessage() {
		return "Value date cannot be after trade date.";
	}

}
