/**
 * 
 */
package com.weather.model.openweather;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Response Object for OpenWeatherMap service
 * @author Luis Luna
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenWeatherResponse {
	
	private Coord coord;
	private List<Weather> weather;
	private String base;
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private Sys sys;
	private Integer id;
    private String name;
    private Integer cod;
    
	/**
	 * @return the coord
	 */
	public Coord getCoord() {
		return coord;
	}
	/**
	 * @param coord the coord to set
	 */
	public void setCoord(Coord coord) {
		this.coord = coord;
	}
	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}
	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}
	/**
	 * @return the visibility
	 */
	public Integer getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	/**
	 * @return the clouds
	 */
	public Clouds getClouds() {
		return clouds;
	}
	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}
	/**
	 * @return the dt
	 */
	public Integer getDt() {
		return dt;
	}
	/**
	 * @param dt the dt to set
	 */
	public void setDt(Integer dt) {
		this.dt = dt;
	}
	/**
	 * @return the sys
	 */
	public Sys getSys() {
		return sys;
	}
	/**
	 * @param sys the sys to set
	 */
	public void setSys(Sys sys) {
		this.sys = sys;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the cod
	 */
	public Integer getCod() {
		return cod;
	}
	/**
	 * @param cod the cod to set
	 */
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	@Override
	public String toString() {
		return "OpenWeatherResponse [coord=" + coord + ", weather=" + weather + ", base=" + base + ", main=" + main
				+ ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds + ", dt=" + dt + ", sys=" + sys
				+ ", id=" + id + ", name=" + name + ", cod=" + cod + "]";
	}
    
}
