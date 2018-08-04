package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.time.LocalDate;

class ExerciseStartDateConstraint implements ValidationRule {

	@Override
	public boolean validate(Trade trade) {
		String style = trade.getStyle();
		LocalDate exerciseStartDate = trade.getExcerciseStartDate();
		LocalDate tradeDate = trade.getTradeDate();
		LocalDate expiryDate = trade.getExpiryDate();
		if (isAmericanStyle(style)) {
			return checkDateBefore(tradeDate, exerciseStartDate) && checkDateBefore(exerciseStartDate, expiryDate);
		} else {
			return true;
		}
	}

	private boolean checkDateBefore(LocalDate before, LocalDate after) {
		return before == null || after == null || before.isBefore(after);
	}

	private boolean isAmericanStyle(String style) {
		return style != null && style.equals("AMERICAN");
	}

	@Override
	public String getErrorMessage() {
		return "Incorrect exerciseStartDate.";
	}
}
