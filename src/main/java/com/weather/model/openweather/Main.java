/**
 * 
 */
package com.weather.model.openweather;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Luis Luna
 *
 */
public class Main {
	private Double temp;
    private Integer pressure;
    private Integer humidity;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    
	/**
	 * @return the temp
	 */
	public Double getTemp() {
		return temp;
	}
	/**
	 * @param temp the temp to set
	 */
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	/**
	 * @return the pressure
	 */
	public Integer getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	/**
	 * @return the humidity
	 */
	public Integer getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the tempMin
	 */
	public Double getTempMin() {
		return tempMin;
	}
	/**
	 * @param tempMin the tempMin to set
	 */
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	/**
	 * @return the tempMax
	 */
	public Double getTempMax() {
		return tempMax;
	}
	/**
	 * @param tempMax the tempMax to set
	 */
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", tempMin=" + tempMin
				+ ", tempMax=" + tempMax + "]";
	}
    
}
