package com.techelevator.npgeek.Model.Weather;

public class Weather {

	private String parkCode;
	private int highTemp;
	private int lowTemp;
	private int dayValue;
	private String Forecast;

	public String getParkCode() { 
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getHighTemp() {
		return highTemp;
	}

	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp; 
	}

	public int getLowTemp() {
		return lowTemp;
	}

	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}

	public int getDayValue() {
		return dayValue;
	}

	public void setDayValue(int dayValue) {
		this.dayValue = dayValue;
	}

	public String getForecast() {
		return Forecast;
	}

	public void setForecast(String forecast) {
		Forecast = forecast;
	}
}
