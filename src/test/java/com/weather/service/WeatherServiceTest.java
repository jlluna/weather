/**
 * 
 */
package com.weather.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.weather.client.OpenWeatherClient;
import com.weather.enums.OpenWeatherUrlParams;
import com.weather.exception.WeatherServiceException;
import com.weather.model.WeatherResponse;
import com.weather.service.impl.WeatherServiceImpl;

/**
 * @author jose.luna
 *
 */
@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class WeatherServiceTest {
	private static final Logger logger = LogManager.getLogger(WeatherServiceTest.class);
	
	@InjectMocks
	private WeatherServiceImpl weatherService;
	
	@Mock
	private OpenWeatherClient client;
	
	private HashMap <String, String> parameters;
	
	@Before
	public void setUp() {			
		parameters = new HashMap<>();
		parameters.put(OpenWeatherUrlParams.CITY_NAME.getValue(), "London");
	} 
	
	@Test
	public void request200ValidResponseTest() throws Exception {
		
		Mockito.when(client.callOpenWeatherService(parameters))
			.thenReturn(this.buildValidOpenWeatherResponse());
		
		WeatherResponse response = this.weatherService.getWeatherByCity("London");
		logger.debug(response.toString());
		
		assertEquals("London",response.getCity());
		assertEquals("Clouds", response.getWeather());
		assertEquals("broken clouds", response.getWeatherDesc());
		assertEquals(Double.valueOf(10.1), response.getTempCe());
		assertEquals(Double.valueOf(50.18), response.getTempFa());
		assertEquals("4:34 AM", response.getSunrise());
		assertEquals("7:20 PM", response.getSunset());
	}
	
	@Test(expected = WeatherServiceException.class)
	public void request404ExceptionResponseTest() throws Exception {
		
		Mockito.when(client.callOpenWeatherService(parameters))
			.thenReturn(this.buildNotFoundResponse());
		
		this.weatherService.getWeatherByCity("NotValidCity");
	}
	
	@Test(expected = WeatherServiceException.class)
	public void request500ExceptionResponseTest() throws Exception {
		
		Mockito.when(client.callOpenWeatherService(parameters))
			.thenReturn(this.buildInternalServerErrorResponse());
		
		this.weatherService.getWeatherByCity("London");
	}
	
	private ResponseEntity<String> buildValidOpenWeatherResponse() {

		return new ResponseEntity<String>("{\"coord\":{\"lon\":-0.13,\"lat\":51.51},"
				+ "\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\","
				+ "\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":283.25,"
				+ "\"pressure\":1022,\"humidity\":81,\"temp_min\":280.15,\"temp_max\":286.48},"
				+ "\"visibility\":10000,\"wind\":{\"speed\":4.6,\"deg\":100},\"clouds\":{\"all\":70},"
				+ "\"dt\":1556658789,\"sys\":{\"type\":1,\"id\":1414,\"message\":0.0082,"
				+ "\"country\":\"GB\",\"sunrise\":1556598889,\"sunset\":1556652032},\"id\":2643743,"
				+ "\"name\":\"London\",\"cod\":200}", HttpStatus.OK);
	}
	
	private ResponseEntity<String> buildNotFoundResponse() {

		return new ResponseEntity<String>("{\"cod\": \"404\",\"message\": \"city not found\"}", HttpStatus.NOT_FOUND);
	}
	
	private ResponseEntity<String> buildInternalServerErrorResponse() {

		return new ResponseEntity<String>("{\"cod\": \"500\",\"message\": \"Internal Server Error\"}", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
