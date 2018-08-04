package com.cs.validation.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validate")
public class ValidationController {

	@PostMapping
	public String validate() {
		return "Its ok";
	}
}
