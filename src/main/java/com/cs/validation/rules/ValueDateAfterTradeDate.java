package com.cs.validation.rules;

import com.cs.validation.Trade;

class ValueDateAfterTradeDate implements ValidationRule {
	@Override
	public boolean validate(Trade trade) {
		return trade.getValueDate().isBefore(trade.getTradeDate());
	}

	@Override
	public String getErrorMessage() {
		return "Value date cannot be after trade date.";
	}

}
