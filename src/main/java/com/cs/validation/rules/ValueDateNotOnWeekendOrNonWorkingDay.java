package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

class ValueDateNotOnWeekendOrNonWorkingDay implements ValidationRule {

	@Override
	public boolean validate(Trade trade) {
		LocalDate valueDate = trade.getValueDate();
		return valueDate == null || !EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY).contains(valueDate.getDayOfWeek()) && isNotFreeDay(valueDate);
	}

	private boolean isNotFreeDay(LocalDate valueDate) {
		return !FreeDays.getFreeDays(valueDate.getYear()).contains(valueDate);
	}

	@Override
	public String getErrorMessage() {
		return "Value date cannot fall on weekend or non-working day.";
	}

	//days depend on country, hence I added only few examples
	enum FreeDays {
		NewYear("01.01"),
		Epiphany("06.01"),
		Easter("01.04"),
		ChristmasFirstDay("25.12"),
		ChristmasSecondDay("26.12");

		private String dayWithMonth;

		FreeDays(String dayWithMonth) {
			this.dayWithMonth = dayWithMonth;
		}

		public static Set<LocalDate> getFreeDays(int forYear) {
			return Arrays.stream(values())
					.map(freeDay -> createDateWithSpecifiedYear(forYear, freeDay))
					.collect(Collectors.toSet());
		}

		private static LocalDate createDateWithSpecifiedYear(int forYear, FreeDays freeDay) {
			return LocalDate.parse(freeDay.dayWithMonth + "." + String.valueOf(forYear), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		}
	}
}
