/**
 * 
 */
package com.weather.enums;

/**
 * Patterns for Date formatting
 * @author Luis Luna
 *
 */
public enum FormatPatterns {
	ACTUAL_DATE_PATTERN("dd/MM/yyyy"), TIME_PATTERN("h:m a");

	private String value;

	FormatPatterns(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
