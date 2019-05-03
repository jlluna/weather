/**
 * 
 */
package com.weather.enums;

/**
 * Enum to store URL parameters for OpenWeatherMap service
 * @author Luis Luna
 *
 */
public enum OpenWeatherUrlParams {
	CITY_NAME("q"), APPID("appid"), UNIT("units");

	private String value;

	OpenWeatherUrlParams(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
