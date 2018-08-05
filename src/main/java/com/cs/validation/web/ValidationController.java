package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResponse;
import com.cs.validation.model.ValidationResponseWithTrade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Api(description = "Provides simple validation for trades")
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Trades have been successfully validated"),
		@ApiResponse(code = 400, message = "Validation input is not correct")
})
@RequestMapping("validation")
public class ValidationController {

	@Autowired
	private ValidationService validationService;

	@ApiOperation(value = "Validate bulk of trades")
	@PostMapping(value = "trades", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ValidationResponseWithTrade> validateTrades(@RequestBody List<Trade> trade) {
		return validationService.validate(trade);
	}

	@ApiOperation(value = "Validate single trade")
	@PostMapping(value = "trade", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ValidationResponse validateTrade(@RequestBody Trade trade) {
		List<ValidationResponseWithTrade> validate = validationService.validate(Collections.singletonList(trade));
		return new ValidationResponse(validate.get(0));
	}
}
