package com.cs.validation.model;

import java.util.Collection;

public class ValidationResponse {

	private String validationStatus;
	private Collection<String> failedReasons;
	private Trade trade;

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

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
}
