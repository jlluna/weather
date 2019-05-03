/**
 * 
 */
package com.weather.service;

import com.weather.exception.WeatherServiceException;
import com.weather.model.WeatherResponse;

/**
 * Interface for weather services
 * @author Luis Luna
 *
 */
public interface WeatherService {
	
	/**
	 * Get weather by city name 
	 * @param city
	 * @return Response from OpenWeather service
	 */
	WeatherResponse getWeatherByCity(String city) throws WeatherServiceException; 
}
