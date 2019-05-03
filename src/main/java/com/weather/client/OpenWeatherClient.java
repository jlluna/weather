/**
 * 
 */
package com.weather.client;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.weather.enums.OpenWeatherUrlParams;

/**
 * @author Luis Luna
 *
 */
@Component
public class OpenWeatherClient {
	private static final Logger LOGGER = LogManager.getLogger(OpenWeatherClient.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Value("${operations.serviceURL}")
	private String serviceURL;
	
	@Value("${operations.appid}")
	private String appid;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	/**
	 * @param parameters
	 * @return Response from OpenWeatherService
	 * @throws Exception 
	 */
	public ResponseEntity<String> callOpenWeatherService(Map<String, String> parameters) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		
		//Set Headers
		HttpEntity<?> entity = new HttpEntity<>(headers);

		//Build Url
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceURL);
		
		//Set APPID and request parameters
		parameters.put(OpenWeatherUrlParams.APPID.getValue(), appid);
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}
		LOGGER.debug("url: " + builder.toUriString());

		return restTemplate.exchange(
				builder.toUriString(), 
				HttpMethod.GET, 
				entity, 
				String.class);
	}

}
