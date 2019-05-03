/**
 * 
 */
package com.weather.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author Luis Luna
 *
 */
public class Utils {
	
	private static DateTimeFormatter formatter;
	private static LocalDateTime localDateTime;
	
	private static final int MILIS = 1000;
	private static final double ABS_ZERO = 273.15;	
	private static final double CONST_100 = 100.0;
	private static final double CONST_9 = 9.0;
	private static final double CONST_5 = 5.0;
	private static final double CONST_32 = 32.0;
	
	private Utils() {
		
    }
	
	/**
	 * Get string representation of actual date
	 * @param format
	 * @return Actual string date in given format
	 */
	public static String getActualDate(String format) {
		formatter = DateTimeFormatter.ofPattern(format);
		
		localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate();
		
		return localDate.format(formatter);
	}
	
	/**
	 * Parse Unix UTC time to String Date representation
	 * @param utcTime
	 * @param format
	 * @return String representation for given UTC time
	 */
	public static String parseUtcTime(Long utcTime, String format) {
		formatter = DateTimeFormatter.ofPattern(format);
		localDateTime = LocalDateTime.ofInstant(
				Instant.ofEpochMilli(utcTime * MILIS), ZoneOffset.UTC);

		return localDateTime.format(formatter);
	}
	
	/**
	 * Convert given temperature in Kº to Cº and Fº
	 * @param tempKelvin
	 * @param scale C - Celsius , F - Fahrenhiet
	 * @return Temperature in given scale
	 */
	public static Double tempConverter(Double tempKelvin, String scale) {
		Double celsius;
		Double fahrenheit;
        
		celsius = Math.round((tempKelvin - ABS_ZERO) * CONST_100) / CONST_100;
		fahrenheit = Math.round(((celsius * CONST_9/CONST_5) + CONST_32) * CONST_100) / CONST_100;
        
        switch(scale) {
	        case "C":
				return celsius;
			case "F":
				return fahrenheit;
			default:
				return tempKelvin;
        }
	}

}
