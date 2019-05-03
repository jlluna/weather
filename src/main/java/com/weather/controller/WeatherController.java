/**
 * 
 */
package com.weather.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weather.exception.WeatherServiceException;
import com.weather.model.WeatherResponse;
import com.weather.service.WeatherService;

/**
 * Controller for Weather App. petitions
 * @author jose.luna
 *
 */
@Controller
public class WeatherController {
	private static final Logger LOGGER = LogManager.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping(value = "/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
	         
	    return modelAndView;
	}
	
	@GetMapping(value = "/weather")
	public ModelAndView getWeatherByCity(@RequestParam String city) {
		ModelAndView modelAndView = new ModelAndView();
		WeatherResponse response;
		
		// Call to weather service
		try {
			response = this.weatherService.getWeatherByCity(city);
			
			modelAndView.setViewName("weather");
	        modelAndView.addObject("response", response);
		} catch (WeatherServiceException e) {
			LOGGER.error(e.getMessage());
			modelAndView.setViewName("error");
	        modelAndView.addObject("message", e.getMessage());
		}
         
        return modelAndView;
	}

}
