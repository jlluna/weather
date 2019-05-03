/**
 * 
 */
package com.weather.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import com.weather.exception.WeatherServiceException;
import com.weather.model.WeatherResponse;
import com.weather.service.WeatherService;

/**
 * @author jose.luna
 *
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class WeatherControllerTest {
	
	@InjectMocks
	WeatherController weatherController;
	
	@Mock
	private WeatherService weatherService;
	
	
	@Test
	public void requestToHomePageTest() throws Exception {

		ModelAndView modelAndView = weatherController.home();
		
		assertNotNull(modelAndView);
		assertEquals("index", modelAndView.getViewName());
		
	}
	
	@Test
	public void requestToValidResultPageTest() throws Exception {
		Mockito.when(weatherService.getWeatherByCity("London"))
			.thenReturn(this.buildValidWeatherResponse());

		ModelAndView modelAndView = weatherController.getWeatherByCity("London");
		assertNotNull(modelAndView.getModel().get("response"));
		assertEquals("weather", modelAndView.getViewName());
		
	}
	
	@Test
	public void requestToErrorPageTest() throws Exception {
		Mockito.when(weatherService.getWeatherByCity("London")).thenThrow(new WeatherServiceException("Mock Error"));

		ModelAndView modelAndView = weatherController.getWeatherByCity("London");
		assertNotNull(modelAndView.getModel().get("message"));
		assertEquals("error", modelAndView.getViewName());
	}
	
	private WeatherResponse buildValidWeatherResponse() {
		WeatherResponse response = new WeatherResponse.Builder("London")
				.withDate("29/04/2019")
				.withWeather("Clouds")
				.withWeatherDesc("scattered clouds")
				.withTempCe(57.94)
				.withTempFa(14.41)
				.withSunrise("4:36 AM")
				.withSunset("7:18 PM")
				.build();
		
		return response;
	}

}
