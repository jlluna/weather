/**
 * 
 */
package com.weather.model;

/**
 * Response object with weather info to show to user
 * @author Luis Luna
 *
 */
public class WeatherResponse {
	
	//Private constructor
	private WeatherResponse() {
		
	}
	
	//Builder
	public static class Builder {
		
		private String city;
		private String date;
		private String weather;
		private String weatherDesc;
		private Double tempFa;
		private Double tempCe;
		private String sunrise;
		private String sunset;
		private String json;
		
		public Builder(String city) {
	        this.city = city;
	    }
		
	    public Builder withDate(String date){
	        this.date = date;
	        return this;
	    }
	    
	    public Builder withWeather(String weather){
	        this.weather = weather;
	        return this;
	    }
	    
	    public Builder withWeatherDesc(String weatherDesc){
	        this.weatherDesc = weatherDesc;
	        return this;
	    }
	    
	    public Builder withTempFa(Double tempFa){
	        this.tempFa = tempFa;
	        return this;
	    }
	    
	    public Builder withTempCe(Double tempCe){
	        this.tempCe = tempCe;
	        return this;
	    }
	    
	    public Builder withSunrise(String sunrise){
	        this.sunrise = sunrise;
	        return this;
	    }
	    
	    public Builder withSunset(String sunset){
	        this.sunset = sunset;
	        return this;
	    }
	    
	    public Builder withJson(String json){
	        this.json = json;
	        return this;
	    }
	    
	    public WeatherResponse build(){
	    	WeatherResponse response = new WeatherResponse();
	    	response.city = this.city;
	        response.date = this.date;
	        response.weather = this.weather;
	        response.weatherDesc = this.weatherDesc;
	        response.tempCe = this.tempCe;
	        response.tempFa = this.tempFa;
	        response.sunrise = this.sunrise;
	        response.sunset = this.sunset;
	        response.json = this.json;
	        return response;
	    }
	}
	
	private String city;
	private String date;
	private String weather;
	private String weatherDesc;
	private Double tempFa;
	private Double tempCe;
	private String sunrise;
	private String sunset;
	private String json;
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @return the weather
	 */
	public String getWeather() {
		return weather;
	}
	/**
	 * @return the weatherDesc
	 */
	public String getWeatherDesc() {
		return weatherDesc;
	}
	/**
	 * @return the tempFa
	 */
	public Double getTempFa() {
		return tempFa;
	}
	/**
	 * @return the tempCe
	 */
	public Double getTempCe() {
		return tempCe;
	}
	/**
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}
	/**
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}
	/**
	 * @return the json
	 */
	public String getJson() {
		return json;
	}

}
