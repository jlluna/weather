/**
 * 
 */
package com.weather.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.enums.FormatPatterns;
import com.weather.enums.TempScale;

/**
 * @author Luis Luna
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsTest {
	
	@Test
	public void utcTimeConverterTest() {
		Long sunrise = 1556488306L;

		String sunriseStr = Utils.parseUtcTime(sunrise, FormatPatterns.TIME_PATTERN.getValue());
		assertEquals("9:51 PM", sunriseStr);
	}
	
	@Test
	public void utcTimeConverterZeroTest() {
		Long sunrise = 0L;

		String sunriseStr = Utils.parseUtcTime(sunrise, FormatPatterns.TIME_PATTERN.getValue());
		assertEquals("12:0 AM", sunriseStr);
	}
	
	@Test
	public void utcTimeConverterMaxTest() {
		Long sunrise = Long.MAX_VALUE;

		String sunriseStr = Utils.parseUtcTime(sunrise, FormatPatterns.TIME_PATTERN.getValue());
		assertEquals("11:59 PM", sunriseStr);
	}
	
	@Test
	public void temperatureConverterTest() {
		Double kelvin, celsius, fahrenheit;

		kelvin = 10d;
		celsius = Utils.tempConverter(kelvin, TempScale.CELSIUS.getCode());
		fahrenheit = Utils.tempConverter(kelvin, TempScale.FAHRENHEIT.getCode());

		assertEquals(Double.valueOf(-263.15), celsius);
		assertEquals(Double.valueOf(-441.67), fahrenheit);
	}
	
	@Test
	public void temperatureConverterDefaultTest() {
		Double kelvin, defaultK;

		kelvin = 10d;
		defaultK = Utils.tempConverter(kelvin, "K");

		assertEquals(Double.valueOf(10), defaultK);
	}
	
	@Test
	public void temperatureConverterZeroTest() {
		Double kelvin, celsius, fahrenheit;

		kelvin = 0d;
		celsius = Utils.tempConverter(kelvin, TempScale.CELSIUS.getCode());
		fahrenheit = Utils.tempConverter(kelvin, TempScale.FAHRENHEIT.getCode());

		assertEquals(Double.valueOf(-273.15), celsius);
		assertEquals(Double.valueOf(-459.67), fahrenheit);
	}
	
	@Test
	public void temperatureConverterMaxTest() {
		Double kelvin, celsius, fahrenheit;

		kelvin = Double.MAX_VALUE;
		celsius = Utils.tempConverter(kelvin, TempScale.CELSIUS.getCode());
		fahrenheit = Utils.tempConverter(kelvin, TempScale.FAHRENHEIT.getCode());

		assertEquals(Double.valueOf(9.223372036854776E16), celsius);
		assertEquals(Double.valueOf(9.223372036854776E16), fahrenheit);
	}

}
