/**
 * 
 */
package com.weather.exception;

/**
 * @author jose.luna
 *
 */
public class WeatherServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WeatherServiceException() {
	}

	public WeatherServiceException(String message) {
		super(message);
	}

	public WeatherServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
