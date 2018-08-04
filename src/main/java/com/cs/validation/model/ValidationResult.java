package com.cs.validation.model;

import java.util.Collection;
import java.util.LinkedList;

public class ValidationResult {
	private Collection<String> errors;

	public ValidationResult() {
		this.errors = new LinkedList<>();
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public Collection<String> getErrorMessages() {
		return new LinkedList<>(errors);
	}

	public void addErrorMessage(String errorMessage) {
		this.errors.add(errorMessage);
	}
}
