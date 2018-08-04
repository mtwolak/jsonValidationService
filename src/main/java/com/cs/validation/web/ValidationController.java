package com.cs.validation.web;

import com.cs.validation.model.Trade;
import com.cs.validation.model.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("validate")
public class ValidationController {

	@Autowired
	private ValidationService validationService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ValidationResponse> validate(@RequestBody List<Trade> trade) {
		return validationService.validate(trade);
	}
}
