package com.cs.validation;

import java.time.LocalDate;

public class Trade {

	private String customer;
	private String ccyPair;
	private String type;
	private String direction;
	private LocalDate tradeDate;
	private double amount1;
	private double amount2;
	private double rate;
	private LocalDate valueDate;
	private String legalEntity;
	private String trader;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public LocalDate getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(LocalDate tradeDate) {
		this.tradeDate = tradeDate;
	}

	public double getAmount1() {
		return amount1;
	}

	public void setAmount1(double amount1) {
		this.amount1 = amount1;
	}

	public double getAmount2() {
		return amount2;
	}

	public void setAmount2(double amount2) {
		this.amount2 = amount2;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public LocalDate getValueDate() {
		return valueDate;
	}

	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}
}
