package com.cs.validation.model;

public class ValidationResponseWithTrade extends ValidationResponse {

	private Trade trade;

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

	@Override
	public String toString() {
		return "ValidationResponseWithTrade{" +
				"trade=" + trade + super.toString() + '}';
	}
}
