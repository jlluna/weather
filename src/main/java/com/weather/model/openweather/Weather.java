/**
 * 
 */
package com.weather.model.openweather;

/**
 * @author Luis Luna
 *
 */
public class Weather {
	private Integer id;
    private String main;
    private String description;
    private String icon;
    
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
	 * @return the main
	 */
	public String getMain() {
		return main;
	}
	/**
	 * @param main the main to set
	 */
	public void setMain(String main) {
		this.main = main;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description=" + description + ", icon=" + icon + "]";
	}

}
