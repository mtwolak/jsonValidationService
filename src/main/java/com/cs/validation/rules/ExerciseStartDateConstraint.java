package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.time.LocalDate;

class ExerciseStartDateConstraint implements ValidationRule {

	@Override
	public boolean validate(Trade trade) {
		String style = trade.getStyle();
		LocalDate exerciseStartDate = trade.getExcerciseStartDate();
		return !isAmericanStyle(style) || isExerciseDateCorrect(trade, exerciseStartDate);
	}

	private boolean isExerciseDateCorrect(Trade trade, LocalDate exerciseStartDate) {
		return exerciseStartDate.isAfter(trade.getTradeDate()) && exerciseStartDate.isBefore(trade.getExpiryDate());
	}

	private boolean isAmericanStyle(String style) {
		return style != null && style.equals("American");
	}

	@Override
	public String getErrorMessage() {
		return "Incorrect exerciseStartDate.";
	}
}
