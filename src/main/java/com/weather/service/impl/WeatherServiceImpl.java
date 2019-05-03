/**
 * 
 */
package com.weather.service.impl;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.client.OpenWeatherClient;
import com.weather.enums.FormatPatterns;
import com.weather.enums.OpenWeatherUrlParams;
import com.weather.enums.TempScale;
import com.weather.exception.WeatherServiceException;
import com.weather.model.WeatherResponse;
import com.weather.model.openweather.OpenWeatherResponse;
import com.weather.service.WeatherService;
import com.weather.util.Utils;

/**
 * Implementation for weather services
 * @author Luis Luna
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {
	private static final Logger LOGGER = LogManager.getLogger(WeatherServiceImpl.class);
	
	@Autowired
	private OpenWeatherClient client;

	/* (non-Javadoc)
	 * @see com.weather.service.WeatherService#getWeatherByCity(java.lang.String)
	 */
	@Override
	public WeatherResponse getWeatherByCity(String city) throws WeatherServiceException {
		OpenWeatherResponse openWeather;
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity<String> entityResp;
		WeatherResponse response;

		// OpenWeatherMap Service parameters
		HashMap <String, String> parameters = new HashMap<>();
		parameters.put(OpenWeatherUrlParams.CITY_NAME.getValue(), city);
		
		try {
			//Call OpenWeatherMap Service
			entityResp = client.callOpenWeatherService(parameters);
		
			//Convert JSON to OpenWeatherResponse object
			openWeather = mapper.readValue(entityResp.getBody(), OpenWeatherResponse.class);
			
			//Build WeatherResponse
			response = this.buildWeatherRespose(openWeather, entityResp.getBody());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new WeatherServiceException(e.getMessage());
		}
				
		LOGGER.debug(entityResp.getBody());
		LOGGER.debug(openWeather.toString());
		
		return response;
	}
	
	/**
	 * Build response object to show in weather view
	 * @param openWeather
	 * @param body
	 * @return WeatherResponse object
	 */
	private WeatherResponse buildWeatherRespose(OpenWeatherResponse openWeather, String body) {
		
		return new WeatherResponse.Builder(openWeather.getName())
				.withDate(Utils.getActualDate(FormatPatterns.ACTUAL_DATE_PATTERN.getValue()))
				.withWeather(openWeather.getWeather().get(0).getMain())
				.withWeatherDesc(openWeather.getWeather().get(0).getDescription())
				.withTempCe(Utils.tempConverter(openWeather.getMain().getTemp(), TempScale.CELSIUS.getCode()))
				.withTempFa(Utils.tempConverter(openWeather.getMain().getTemp(), TempScale.FAHRENHEIT.getCode()))
				.withSunrise(Utils.parseUtcTime(openWeather.getSys().getSunrise(), FormatPatterns.TIME_PATTERN.getValue()))
				.withSunset(Utils.parseUtcTime(openWeather.getSys().getSunset(), FormatPatterns.TIME_PATTERN.getValue()))
				.withJson(body)
				.build();
	}

}
