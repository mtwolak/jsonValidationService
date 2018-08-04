package com.cs.validation.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
class ValidationController {

	@PostMapping("validate")
	String validate() {
		return "Its ok";
	}
}
