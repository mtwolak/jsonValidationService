package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResponse;
import com.cs.validation.model.ValidationResult;
import org.springframework.stereotype.Service;

@Service
class ValidationService {

	private final TradeValidator tradeValidator;

	ValidationService() {
		tradeValidator = new TradeValidator();
	}

	public ValidationResponse validate(Trade trade) {
		ValidationResult validationResult = tradeValidator.validate(trade);
		ValidationResponse validationResponse = new ValidationResponse();
		validationResponse.setValidationStatus(validationResult.hasErrors() ? "failed" : "success");
		validationResponse.setFailedReasons(validationResult.getErrorMessages());
		return validationResponse;
	}
}
