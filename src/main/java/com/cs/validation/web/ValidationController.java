package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResponse;
import com.cs.validation.model.ValidationResponseWithTrade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("validation")
public class ValidationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

	@Autowired
	private ValidationService validationService;

	@PostMapping(value = "trades", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ValidationResponseWithTrade> validateTrades(@RequestBody List<Trade> trade) {
		LOGGER.info("Incoming trades for validation:" + trade.toString());
		List<ValidationResponseWithTrade> validate = validationService.validate(trade);
		LOGGER.info("Validation done, result:" + validate.toString());
		return validate;
	}

	@PostMapping(value = "trade", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ValidationResponse validateTrade(@RequestBody Trade trade) {
		LOGGER.info("Incoming trades for validation:" + trade.toString());
		List<ValidationResponseWithTrade> validate = validationService.validate(Collections.singletonList(trade));
		ValidationResponse validationResponse = new ValidationResponse(validate.get(0));
		LOGGER.info("Validation done, result:" + validationResponse.toString());
		return validationResponse;
	}
}
