package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResponse;
import com.cs.validation.model.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
class ValidationService {

	private final TradeValidator tradeValidator;

	ValidationService() {
		tradeValidator = new TradeValidator();
	}

	public List<ValidationResponse> validate(List<Trade> trades) {
		List<ValidationResponse> responses = new LinkedList<>();
		for (Trade trade : trades) {
			ValidationResult validationResult = tradeValidator.validate(trade);
			ValidationResponse validationResponse = new ValidationResponse();
			validationResponse.setValidationStatus(validationResult.hasErrors() ? "failed" : "success");
			validationResponse.setFailedReasons(validationResult.getErrorMessages());
			validationResponse.setTrade(trade);
			responses.add(validationResponse);
		}
		return responses;

	}
}
