package com.example.demo.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
//@Configuration
public class WeatherModel {

	private static final long serialVersionUID = 1L;

	private String siteid;

	private String humidity;

	private String temperature;

	private String windspeed;

	

//	public WeatherModel(String siteid, String humidity, String temperature, String windspeed, String createdate) {
//		super();
//		this.siteid = siteid;
//		this.humidity = humidity;
//		this.temperature = temperature;
//		this.windspeed = windspeed;
//		this.createdate = createdate;
//	}

	private Date createdate;

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindspeed() {
		return windspeed;
	}

	public void setWindspeed(String windspeed) {
		this.windspeed = windspeed;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date date) {
		this.createdate = date;
	}

	@Override
	public String toString() {
		return "Weather [siteid=" + siteid + ", humidity=" + humidity + ", temperature=" + temperature + "]";
	}

}
