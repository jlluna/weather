/**
 * 
 */
package com.weather.enums;

/**
 * Codes for Temperature Scales
 * @author Luis Luna
 *
 */
public enum TempScale {
	KELVIN("K"), CELSIUS("C"), FAHRENHEIT("F");

	private String code;

	TempScale(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
