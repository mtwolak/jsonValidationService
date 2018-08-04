package com.cs.validation;

class TradeValidator {
	ValidationResult validate(Trade trade) {
		ValidationResult validationResult = new ValidationResult();
		if(trade.getValueDate().isAfter(trade.getTradeDate())) {
			validationResult.addErrorMessage("Value date cannot be after trade date");
		}
		return validationResult;
	}
}
