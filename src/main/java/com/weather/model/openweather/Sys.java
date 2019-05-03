/**
 * 
 */
package com.weather.model.openweather;

/**
 * @author Luis Luna
 *
 */
public class Sys {
	private Integer type;
	private Integer id;
    private String message;
    private String country;
    private Long sunrise;
    private Long sunset;
    
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the sunrise
	 */
	public Long getSunrise() {
		return sunrise;
	}
	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}
	/**
	 * @return the sunset
	 */
	public Long getSunset() {
		return sunset;
	}
	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}
	
	@Override
	public String toString() {
		return "Sys [type=" + type + ", id=" + id + ", message=" + message + ", country=" + country + ", sunrise="
				+ sunrise + ", sunset=" + sunset + "]";
	}

}
