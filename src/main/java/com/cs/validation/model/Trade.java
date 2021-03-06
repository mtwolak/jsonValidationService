package com.cs.validation.model;

import java.time.LocalDate;
import java.util.StringJoiner;

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
	private LocalDate excerciseStartDate;
	private LocalDate expiryDate;
	private LocalDate premiumDate;
	private LocalDate deliveryDate;
	private String legalEntity;
	private String trader;
	private String style;

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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public LocalDate getExcerciseStartDate() {
		return excerciseStartDate;
	}

	public void setExcerciseStartDate(LocalDate excerciseStartDate) {
		this.excerciseStartDate = excerciseStartDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public LocalDate getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(LocalDate premiumDate) {
		this.premiumDate = premiumDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Trade.class.getSimpleName() + "[", "]")
				.add("customer='" + customer + "'")
				.add("ccyPair='" + ccyPair + "'")
				.add("type='" + type + "'")
				.add("direction='" + direction + "'")
				.add("tradeDate=" + tradeDate)
				.add("amount1=" + amount1)
				.add("amount2=" + amount2)
				.add("rate=" + rate)
				.add("valueDate=" + valueDate)
				.add("excerciseStartDate=" + excerciseStartDate)
				.add("expiryDate=" + expiryDate)
				.add("premiumDate=" + premiumDate)
				.add("deliveryDate=" + deliveryDate)
				.add("legalEntity='" + legalEntity + "'")
				.add("trader='" + trader + "'")
				.add("style='" + style + "'")
				.toString();
	}
}
