package com.cs.validation.model;

import java.util.Collection;

public class ValidationResponse {

	private String validationStatus;
	private Collection<String> failedReasons;

	public ValidationResponse() {

	}

	public ValidationResponse(ValidationResponseWithTrade validationResponseWithTrade) {
		setValidationStatus(validationResponseWithTrade.getValidationStatus());
		setFailedReasons(validationResponseWithTrade.getFailedReasons());
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public Collection<String> getFailedReasons() {
		return failedReasons;
	}

	public void setFailedReasons(Collection<String> failedReasons) {
		this.failedReasons = failedReasons;
	}

	@Override
	public String toString() {
		return "ValidationResponse{" +
				"validationStatus='" + validationStatus + '\'' +
				", failedReasons=" + failedReasons +
				'}';
	}
}
