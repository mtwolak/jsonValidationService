package com.cs.validation;

import java.util.Collection;
import java.util.LinkedList;

class ValidationResult {
	private Collection<String> errors;

	ValidationResult() {
		this.errors = new LinkedList<>();
	}

	boolean hasErrors() {
		return !errors.isEmpty();
	}

	Collection<String> getErrorMessages() {
		return new LinkedList<>(errors);
	}

	void addErrorMessage(String errorMessage) {
		this.errors.add(errorMessage);
	}
}
