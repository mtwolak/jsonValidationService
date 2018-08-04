package com.cs.validation.rules;

import com.cs.validation.model.Trade;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SupportedStyles implements ValidationRule {

	private static final Set<String> SUPPORTED_STYLES = Stream.of("AMERICAN", "EUROPEAN").collect(Collectors.toSet());

	@Override
	public boolean validate(Trade trade) {
		String style = trade.getStyle();
		return style != null && isStyleSupported(style);
	}

	private boolean isStyleSupported(String style) {
		return SUPPORTED_STYLES.contains(style);
	}

	@Override
	public String getErrorMessage() {
		return "Style is not supported";
	}
}
