package com.cs.validation;

import com.cs.validation.model.Trade;

import java.time.LocalDate;

public class CorrectTrade {

	public static Trade create() {
		Trade trade = new Trade();
		trade.setValueDate(LocalDate.parse("2018-02-01"));
		trade.setTradeDate(LocalDate.parse("2018-03-01"));
		trade.setCustomer("PLUTO1");
		trade.setCcyPair("EURUSD");
		trade.setStyle("European");
		return trade;
	}
}
