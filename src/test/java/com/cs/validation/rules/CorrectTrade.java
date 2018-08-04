package com.cs.validation.rules;

import com.cs.validation.Trade;

import java.time.LocalDate;

class CorrectTrade {

	static Trade create() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-02-01"));
		trade.setTradeDate(LocalDate.parse("2018-03-01"));
		return trade;
	}
}