package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.time.LocalDate;

class ExpiryDateBeforeDeliveryDate implements ValidationRule {

	@Override
	public boolean validate(Trade trade) {
		LocalDate expiryDate = trade.getExpiryDate();
		LocalDate deliveryDate = trade.getDeliveryDate();
		LocalDate premiumDate = trade.getPremiumDate();
		return isDateBefore(expiryDate, deliveryDate) && isDateBefore(premiumDate, deliveryDate);
	}

	private boolean isDateBefore(LocalDate expiryDate, LocalDate deliveryDate) {
		return !areDatesPresent(expiryDate, deliveryDate) || expiryDate.isBefore(deliveryDate);
	}

	private boolean areDatesPresent(LocalDate expiryDate, LocalDate deliveryDate) {
		return expiryDate != null && deliveryDate != null;
	}

	@Override
	public String getErrorMessage() {
		return "Incorrect expiry date.";
	}
}
