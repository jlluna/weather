/**
 * 
 */
package com.weather.client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.givenThat;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.weather.enums.OpenWeatherUrlParams;

/**
 * @author jose.luna
 *
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherClientTest {
	private static final Logger logger = LogManager.getLogger(OpenWeatherClientTest.class);
	
	private WireMockServer wireMockServer;
	
	private HashMap <String, String> parameters;
	
	@Autowired
	private OpenWeatherClient client;
	

	@Before
	public void configureSystemUnderTest() {
		parameters = new HashMap<>();
		parameters.put(OpenWeatherUrlParams.CITY_NAME.getValue(), "London");
		
        this.wireMockServer = new WireMockServer(options().port(8082));
        this.wireMockServer.start();
        
        configureFor("localhost", this.wireMockServer.port());
	}
	
	@After
    public void stopWireMockServer() {
        this.wireMockServer.stop();
    }
	
	@Test
	public void callOpenWeatherTest() throws Exception {
		
		givenThat(get(urlEqualTo("/data/2.5/weather?q=London&appid=44d624fed431f8cd654dded3df47cab7"))
				.willReturn(aResponse()
                .withStatus(200))
        );
		
		ResponseEntity<String> response = client.callOpenWeatherService(parameters);
		logger.debug(response);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
